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

public class InviteCommand extends AbstractIrcCommand implements IncomingIrcCommand {
	private final String nick;
	private final String channel;
	
	public InviteCommand(String nick, String channel) {
		validateNick(nick);
		validateChannel(channel);
		this.nick = nick;
		this.channel = channel;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public String getNick() {
		return nick;
	}

	@Override
	public UniversalIterator<String> getArguments() {
		return iterator(nick, channel);
	}

	@Override
	public String getCommand() {
		return "INVITE";
	}

	@Override
	public IrcEvent<InviteCommand> getEvent(final IrcClient client, final Entity origin) {
		return new AbstractIrcEvent<InviteCommand>(client, origin, this) {
			@Override
			protected void doTrigger(IrcEventListener listener) {
				listener.inviteEvent(this);
			}		
		};
	}
	
	public static InviteCommand build(String[] param) {
		validateParam(param, 2);
		return new InviteCommand(param[0], param[1]);
	}
}
