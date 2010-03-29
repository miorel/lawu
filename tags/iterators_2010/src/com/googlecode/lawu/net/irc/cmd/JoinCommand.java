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

public class JoinCommand extends AbstractIrcCommand implements IncomingIrcCommand {
	private final String channel;
	private final String key;
	
	public JoinCommand(String channel, String key) {
		validateChannel(channel);
		validateString("channel key", key, true, false);
		this.channel = channel;
		this.key = key;
	}
	
	public JoinCommand(String channel) {
		this(channel, null);
	}

	public static JoinCommand build(String[] param) {
		validateParam(param, 1);
		return new JoinCommand(param[0]);
	}
	
	public String getChannel() {
		return channel;
	}
	
	public String getKey() {
		return key;
	}
	
	public boolean hasKey() {
		return key != null;
	}

	@Override
	public UniversalIterator<String> getArguments() {
		return hasKey() ? iterator(channel, key) : iterator(channel);
	}

	@Override
	public String getCommand() {
		return "JOIN";
	}
	
	@Override
	public IrcEvent<JoinCommand> getEvent(final IrcClient client, final Entity origin) {
		return new AbstractIrcEvent<JoinCommand>(client, origin, this) {
			@Override
			protected void doTrigger(IrcEventListener listener) {
				listener.joinEvent(this);
			}		
		};
	}
}
