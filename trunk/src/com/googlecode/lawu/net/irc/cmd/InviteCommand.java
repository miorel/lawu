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

/**
 * A channel invitation command.
 * 
 * @author Miorel-Lucian Palii
 */
public class InviteCommand extends AbstractIrcCommand implements IncomingIrcCommand {
	private final String nick;
	private final String channel;

	/**
	 * Builds a command indicating that the specified nick was invited to the
	 * specified channel.
	 * 
	 * @param nick
	 *            the nick of the user being invited
	 * @param channel
	 *            the channel the user is being invited to
	 */
	public InviteCommand(String nick, String channel) {
		validateNick(nick);
		validateChannel(channel);
		this.nick = nick;
		this.channel = channel;
	}

	/**
	 * Gets the channel the user is being invited to.
	 * 
	 * @return the channel the user is being invited to
	 */
	public String getChannel() {
		return this.channel;
	}

	/**
	 * Gets the nick of the user being invited.
	 * 
	 * @return the invited user
	 */
	public String getNick() {
		return this.nick;
	}

	@Override
	public UniversalIterator<String> getArguments() {
		return iterator(this.nick, this.channel);
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

	/**
	 * Builds a channel invitation command using the specified parameters.
	 * 
	 * @param param
	 *            the command parameters
	 * @return a channel invitation command
	 */
	public static InviteCommand build(String[] param) {
		validateParam(param, 2);
		return new InviteCommand(param[0], param[1]);
	}
}
