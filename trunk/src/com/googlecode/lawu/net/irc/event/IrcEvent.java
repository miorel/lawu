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

import com.googlecode.lawu.event.Event;
import com.googlecode.lawu.net.irc.Entity;
import com.googlecode.lawu.net.irc.IrcClient;
import com.googlecode.lawu.net.irc.cmd.IncomingIrcCommand;

/**
 * Decorates an incoming IRC command as an event object with information about
 * the client that received it and the entity that originated it.
 * 
 * @author Miorel-Lucian Palii
 * @param <C>
 *            the type of command held
 */
public interface IrcEvent<C extends IncomingIrcCommand> extends Event<IrcEventListener> {
	/**
	 * Retrieves a reference to the client that received the command.
	 * 
	 * @return the client that received the command.
	 */
	public IrcClient getClient();
	
	/**
	 * Retrieves the entity that originated the command.
	 * 
	 * @return the origin of the command
	 */
	public Entity getOrigin();
	
	/**
	 * Retrieves the decorated IRC command. 
	 * 
	 * @return the IRC command
	 */
	public C getCommand();
}
