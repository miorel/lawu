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
package com.googlecode.lawu.net.irc.cmd;

import static com.googlecode.lawu.util.Iterators.iterator;

import com.googlecode.lawu.net.irc.Entity;
import com.googlecode.lawu.net.irc.IrcClient;
import com.googlecode.lawu.net.irc.event.AbstractIrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEventListener;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class KickCommand extends AbstractIrcCommand implements IncomingIrcCommand {
	private final String channel;
	private final String nick;
	private final String message;
	
	public KickCommand(String channel, String nick, String message) {
		validateChannel(channel);
		validateNick(nick);
		validateMessage(message, false);
		this.channel = channel;
		this.nick = nick;
		this.message = message;
	}
	
	public KickCommand(String channel, String nick) {
		this(channel, nick, null);
	}
	
	public String getChannel() {
		return channel;
	}
	
	public String getNick() {
		return nick;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean hasMessage() {
		return message == null;
	}
	
	@Override
	public UniversalIterator<String> getArguments() {
		return hasMessage() ? iterator(channel, nick, message) : iterator(channel, nick);
	}

	@Override
	public String getCommand() {
		return "KICK";
	}

	@Override
	public IrcEvent<KickCommand> getEvent(final IrcClient client, final Entity origin) {
		return new AbstractIrcEvent<KickCommand>(client, origin, this) {
			@Override
			protected void doTrigger(IrcEventListener listener) {
				listener.kickEvent(this);
			}		
		};
	}
	
	public static KickCommand build(String[] param) {
		validateParam(param, 2, 3);
		return param.length == 2 ? new KickCommand(param[0], param[1]) : new KickCommand(param[0], param[1], param[2]);
	}
}
