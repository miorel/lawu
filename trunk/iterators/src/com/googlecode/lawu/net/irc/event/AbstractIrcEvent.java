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
package com.googlecode.lawu.net.irc.event;

import com.googlecode.lawu.event.AbstractEvent;
import com.googlecode.lawu.net.irc.Entity;
import com.googlecode.lawu.net.irc.IrcClient;
import com.googlecode.lawu.net.irc.cmd.IncomingIrcCommand;

public abstract class AbstractIrcEvent<C extends IncomingIrcCommand> extends AbstractEvent<IrcEventListener> implements IrcEvent<C> {
	private final IrcClient client;
	private final Entity origin;
	private final C command;
	
	public AbstractIrcEvent(IrcClient client, Entity origin, C command) {
		if(client == null)
			throw new IllegalArgumentException("The client may not be null.");
		if(command == null)
			throw new IllegalArgumentException("The command may not be null.");
		this.client = client;
		this.origin = origin;
		this.command = command;
	}

	@Override
	public IrcClient getClient() {
		return client;
	}

	@Override
	public Entity getOrigin() {
		return origin;
	}
	
	@Override
	public C getCommand() {
		return command;
	}
}
