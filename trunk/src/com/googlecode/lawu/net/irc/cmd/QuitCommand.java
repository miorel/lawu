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

import com.googlecode.lawu.net.irc.Entity;
import com.googlecode.lawu.net.irc.IrcClient;
import com.googlecode.lawu.net.irc.event.AbstractIrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEvent;
import com.googlecode.lawu.net.irc.event.IrcEventListener;
import com.googlecode.lawu.util.Iterators;
import com.googlecode.lawu.util.iterators.UniversalIterator;

/**
 * A command to quit IRC>
 * 
 * @author Miorel-Lucian Palii
 */
public class QuitCommand extends AbstractIrcCommand implements IncomingIrcCommand {
	private final String message;

	/**
	 * Builds a quit command with the specified message.
	 * 
	 * @param message
	 *            the quit message
	 */
	public QuitCommand(String message) {
		if(message != null && message.isEmpty())
			message = null;
		this.message = message;
		validateMessage(message, false);
	}

	/**
	 * Builds a quit command with no message.
	 */
	public QuitCommand() {
		this(null);
	}

	/**
	 * Gets this command's message.
	 * 
	 * @return this command's message, or <code>null</code if it doesn't have
	 *         one
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Checks whether this command has a message.
	 * 
	 * @return whether this command has a message
	 */
	public boolean hasMessage() {
		return this.message == null;
	}

	@Override
	public UniversalIterator<String> getArguments() {
		return hasMessage() ? Iterators.iterator(this.message) : Iterators.<String>iterator();
	}

	@Override
	public String getCommand() {
		return "QUIT";
	}

	/**
	 * Builds an IRC quit command using the specified parameters.
	 * 
	 * @param param
	 *            the command parameters
	 * @return an IRC quit command
	 */
	public static QuitCommand build(String[] param) {
		validateParam(param, 0, 1);
		return new QuitCommand(param.length == 0 ? null : param[0]);
	}
	
	@Override
	public IrcEvent<QuitCommand> getEvent(final IrcClient client, final Entity origin) {
		return new AbstractIrcEvent<QuitCommand>(client, origin, this) {
			@Override
			protected void doTrigger(IrcEventListener listener) {
				listener.quitEvent(this);
			}		
		};
	}
}
