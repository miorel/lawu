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

import static com.googlecode.lawu.util.Iterators.iterator;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.net.irc.cmd.InviteCommand;
import com.googlecode.lawu.net.irc.cmd.JoinCommand;
import com.googlecode.lawu.net.irc.cmd.KickCommand;
import com.googlecode.lawu.net.irc.cmd.NickCommand;
import com.googlecode.lawu.net.irc.cmd.NoticeCommand;
import com.googlecode.lawu.net.irc.cmd.PassCommand;
import com.googlecode.lawu.net.irc.cmd.PongCommand;
import com.googlecode.lawu.net.irc.cmd.PrivmsgCommand;
import com.googlecode.lawu.net.irc.cmd.QuitCommand;
import com.googlecode.lawu.net.irc.cmd.SqueryCommand;
import com.googlecode.lawu.net.irc.cmd.UserCommand;
import com.googlecode.lawu.net.irc.cmd.WhoisCommand;

public class IrcCommands {
	private IrcCommands() {
	}
	
	public static void pong(IrcClient client, Iterator<String> targets) {
		client.send(new PongCommand(targets));
	}
	
	public static void pong(IrcClient client, String... targets) {
		pong(client, iterator(targets));
	}
	
	public static void pass(IrcClient client, String password) {
		client.send(new PassCommand(password));
	}

	public static void quit(IrcClient client) {
		client.send(new QuitCommand());
	}

	public static void quit(IrcClient client, String message) {
		client.send(new QuitCommand(message));
	}
	
	public static void invite(IrcClient client, String nick, String channel) {
		client.send(new InviteCommand(nick, channel));
	}

	public static void join(IrcClient client, String channel) {
		client.send(new JoinCommand(channel));
	}

	public static void join(IrcClient client, String channel, String key) {
		client.send(new JoinCommand(channel, key));
	}

	public static void nick(IrcClient client, String nick) {
		client.send(new NickCommand(nick));
	}

	public static void whois(IrcClient client, String nick) {
		client.send(new WhoisCommand(nick));
	}
	
	public static void kick(IrcClient client, String channel, String nick) {
		client.send(new KickCommand(channel, nick));
	}
	
	public static void kick(IrcClient client, String channel, String nick, String message) {
		client.send(new KickCommand(channel, nick, message));
	}
	
	public static void privmsg(IrcClient client, String target, String message) {
		client.send(new PrivmsgCommand(target, message));
	}

	public static void squery(IrcClient client, String target, String message) {
		client.send(new SqueryCommand(target, message));
	}
	
	public static void notice(IrcClient client, String target, String message) {
		client.send(new NoticeCommand(target, message));
	}
	
	public static void user(IrcClient client, String userName, String realName) {
		client.send(new UserCommand(userName, realName));
	}
	
	public static void user(IrcClient client, String userName, int initialMode, String realName) {
		client.send(new UserCommand(userName, initialMode, realName));
	}
}
