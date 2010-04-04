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

import java.util.Arrays;
import java.util.Locale;

import com.googlecode.lawu.net.irc.Entity;
import com.googlecode.lawu.net.irc.IrcClient;
import com.googlecode.lawu.net.irc.event.AbstractIrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEventListener;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class UnknownCommand extends AbstractIrcCommand implements IncomingIrcCommand {
	private final String command;
	private final String[] param;
	
	public UnknownCommand(String command, String[] param) {
		validateString("command ", command, false, false);
		validateParam(param, 0, Integer.MAX_VALUE);
		this.command = command.toUpperCase(Locale.ENGLISH);
		this.param = Arrays.copyOf(param, param.length);
	}

	@Override
	public UniversalIterator<String> getArguments() {
		return iterator(this.param);
	}

	@Override
	public String getCommand() {
		return this.command;
	}

	@Override
	public IrcEvent<UnknownCommand> getEvent(final IrcClient client, final Entity origin) {
		return new AbstractIrcEvent<UnknownCommand>(client, origin, this) {
			@Override
			protected void doTrigger(IrcEventListener listener) {
				listener.unknownCommandEvent(this);
			}		
		};
	}
}
