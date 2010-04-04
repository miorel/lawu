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

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.net.irc.Entity;
import com.googlecode.lawu.net.irc.IrcClient;
import com.googlecode.lawu.net.irc.event.AbstractIrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEventListener;

/**
 * An IRC ping message.
 * 
 * @author Miorel-Lucian Palii
 * @see PongCommand
 */
public class PingCommand extends IrcTargetsCommand implements IncomingIrcCommand {	
	/**
	 * Builds an IRC ping with the specified targets.
	 * 
	 * @param targets
	 *            the pingers
	 */
	public PingCommand(Iterator<String> targets) {
		super(targets);
	}
	
	@Override
	public String getCommand() {
		return "PING";
	}

	@Override
	public IrcEvent<PingCommand> getEvent(final IrcClient client, final Entity origin) {
		return new AbstractIrcEvent<PingCommand>(client, origin, this) {
			@Override
			protected void doTrigger(IrcEventListener listener) {
				listener.pingEvent(this);
			}		
		};
	}
	
	/**
	 * Builds an IRC ping using the specified parameters.
	 * 
	 * @param param
	 *            the command parameters
	 * @return an IRC ping
	 */
	public static PingCommand build(String[] param) {
		validateParam(param, 1);
		return new PingCommand(iterator(param[0].split("\\s+")));
	}
}
