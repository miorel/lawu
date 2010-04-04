/*
 * Copyright (C) 2010 Miorel-Lucian Palii
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package com.googlecode.lawu.net.irc;

import static com.googlecode.lawu.net.irc.IrcCommands.nick;
import static com.googlecode.lawu.net.irc.IrcCommands.pong;
import static com.googlecode.lawu.net.irc.IrcCommands.user;
import static com.googlecode.lawu.util.Iterators.adapt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.event.EventManager;
import com.googlecode.lawu.net.LineOrientedClient;
import com.googlecode.lawu.net.event.AbstractNetworkEventListener;
import com.googlecode.lawu.net.event.ConnectedEvent;
import com.googlecode.lawu.net.irc.cmd.IncomingIrcCommand;
import com.googlecode.lawu.net.irc.cmd.IrcCommand;
import com.googlecode.lawu.net.irc.cmd.PingCommand;
import com.googlecode.lawu.net.irc.cmd.UnknownCommand;
import com.googlecode.lawu.net.irc.event.AbstractIrcEventListener;
import com.googlecode.lawu.net.irc.event.IrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEventListener;
import com.googlecode.lawu.nio.Registrar;

public class IrcClient extends LineOrientedClient {
	public final static String COMMAND_REGEX = "\\s*(?::(\\S+)\\s+)?(\\S+)\\s*(.*)";
	public final static String PARAM_REGEX = ":[\\S\\s]*|\\S+";
	
	private final static Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_REGEX);
	private final static Pattern PARAM_PATTERN = Pattern.compile(PARAM_REGEX);
	
	private final static Map<String, Method> IRC_STRING_COMMANDS = new HashMap<String, Method>();
	static {
		ResourceBundle ircStringCmds = ResourceBundle.getBundle(IrcCommands.class.getPackage().getName() + ".IrcCommandList");
		for(String cmd: adapt(ircStringCmds.getKeys())) {
			Method m = null;
			try {
				m = Class.forName(ircStringCmds.getString(cmd)).getMethod("build", String[].class);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			if(m != null)
				IRC_STRING_COMMANDS.put(cmd.toUpperCase(Locale.ENGLISH), m);
		}
	}
	
	private final EventManager<IrcEventListener> ircEventManager;
	
	private String desiredNick;
	private String userName;
	private String realName;
	
	public IrcClient(SocketAddress address, Registrar registrar) {
		this(address, registrar, null);
	}

	public IrcClient(SocketAddress address, Registrar registrar, SelectorProvider provider) {
		super(address, registrar, provider);
		this.ircEventManager = new EventManager<IrcEventListener>();
		addIrcEventListener(new AbstractIrcEventListener() {
			@Override
			public void pingEvent(IrcEvent<PingCommand> event) {
				pong(IrcClient.this, event.getCommand().getTargets());
			}
		});
		addNetworkEventListener(new AbstractNetworkEventListener() {
			@Override
			public void connected(ConnectedEvent event) {
				nick(IrcClient.this, getDesiredNick());
				user(IrcClient.this, getUserName(), getRealName());
			}
		});
	}

	public String getDesiredNick() {
		if(desiredNick == null)
			setDesiredNick(getUserName());
		return desiredNick;
	}
	
	public void setDesiredNick(String desiredNick) {
		if(desiredNick != null && desiredNick.isEmpty())
			throw new IllegalArgumentException("The desired nickname may not have zero length, use null instead to choose value automatically.");
		this.desiredNick = desiredNick;
	}

	public String getUserName() {
		if(userName == null) {
			String user = System.getProperty("user.name");
			if(user == null) {
				StringBuilder sb = new StringBuilder();
				Random rnd = new Random();
				for(int n = 8; n >= 0; --n)
					sb.append((char) ('a' + rnd.nextInt('z' - 'a' + 1)));
				user = sb.toString();
			}
			setUserName(user);
		}
		return userName;
	}
	
	public void setUserName(String userName) {
		if(userName != null && userName.isEmpty())
			throw new IllegalArgumentException("The user name may not have zero length, use null instead to choose value automatically.");
		this.userName = userName;
	}
	
	public String getRealName() {
		if(realName == null)
			realName = " ";
		return realName;
	}
	
	public void setRealName(String realName) {
		if(realName != null && realName.isEmpty())
			throw new IllegalArgumentException("The real name may not be zero length, use null instead.");
		this.realName = realName;
	}
	
	@Override
	protected void process(String line) {
		Matcher m = COMMAND_PATTERN.matcher(line);
		if(m.matches()) {
			String origin = m.group(1);
			String command = m.group(2);
			String params = m.group(3);
			Stack<String> paramStack = new Stack<String>();
			m = PARAM_PATTERN.matcher(params);
			while(m.find())
				paramStack.push(m.group());
			if(!paramStack.isEmpty() && paramStack.peek().startsWith(":"))
				paramStack.push(paramStack.pop().substring(1));
			Entity originObj = origin == null ? null : Entity.forInfo(origin, getAddress());
			String[] param = paramStack.toArray(new String[paramStack.size()]);
			if(command.matches("\\d{3}"))
				;//processCommand(originObj, Integer.parseInt(command), param);
			else
				processCommand(originObj, command.toUpperCase(), param);
		}
		else {
			throw new RuntimeException();
		}
	}
	
	protected void processCommand(Entity origin, String command, String[] param) {
		IncomingIrcCommand commandObj = null;
		Method method = IRC_STRING_COMMANDS.get(command.toUpperCase(Locale.ENGLISH));
		if(method != null) {
			try {
				commandObj = (IncomingIrcCommand) method.invoke(null, (Object) param);
			}
			catch(InvocationTargetException e) {
				e.getCause().printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(commandObj == null) {
			System.err.println("Can't parse " + command + " command.");
			commandObj = new UnknownCommand(command, param);	
		}
		distributeIrcEvent(commandObj.getEvent(this, origin));
	}
	
	public void addIrcEventListener(IrcEventListener listener) {
		ircEventManager.addListener(listener);
	}

	protected void distributeIrcEvent(IrcEvent<?> event) {
		ircEventManager.distribute(event);
	}

	public void removeIrcEventListener(IrcEventListener listener) {
		ircEventManager.removeListener(listener);
	}
	
	public void send(IrcCommand command) {
		StringBuilder sb = new StringBuilder(command.getCommand());
		for(Iterator<String> args = command.getArguments(); !args.isDone();) {
			String arg = args.current();
			args.advance();
			sb.append(' ');
			if(args.isDone() && !arg.matches("\\S+"))
				sb.append(':');
			sb.append(arg);
		}
		send(sb);
	}
}
