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

import com.googlecode.lawu.event.EventListener;
import com.googlecode.lawu.net.irc.cmd.CtcpCommand;
import com.googlecode.lawu.net.irc.cmd.InviteCommand;
import com.googlecode.lawu.net.irc.cmd.JoinCommand;
import com.googlecode.lawu.net.irc.cmd.KickCommand;
import com.googlecode.lawu.net.irc.cmd.NickCommand;
import com.googlecode.lawu.net.irc.cmd.NoticeCommand;
import com.googlecode.lawu.net.irc.cmd.PingCommand;
import com.googlecode.lawu.net.irc.cmd.PrivmsgCommand;
import com.googlecode.lawu.net.irc.cmd.QuitCommand;
import com.googlecode.lawu.net.irc.cmd.UnknownCommand;

/**
 * A listener for IRC protocol events (commands).
 * 
 * @author Miorel-Lucian Palii
 */
public interface IrcEventListener extends EventListener {
	/**
	 * Invoked when someone changes IRC nicks.
	 * 
	 * @param event
	 *            an event object
	 */
	public void nickEvent(IrcEvent<NickCommand> event);
	
	/**
	 * Invoked on a ping.
	 * 
	 * @param event
	 *            an event object
	 */
	public void pingEvent(IrcEvent<PingCommand> event);

	/**
	 * Invoked on receipt of a notice.
	 * 
	 * @param event
	 *            an event object
	 */
	public void noticeEvent(IrcEvent<NoticeCommand> event);

	/**
	 * Invoked on receipt of a private message. This is a misnomer, since IRC
	 * private messages can be sent to an entire channel.
	 * 
	 * @param event
	 *            an event object
	 */
	public void privmsgEvent(IrcEvent<PrivmsgCommand> event);

	/**
	 * Invoked on receipt of an invitation to join a channel.
	 * 
	 * @param event
	 *            an event object
	 */
	public void inviteEvent(IrcEvent<InviteCommand> event);

	/**
	 * Invoked when someone quits the IRC network.
	 * 
	 * @param event
	 *            an event object
	 */
	public void quitEvent(IrcEvent<QuitCommand> event);

	/**
	 * Invoked when someone gets kicked from a channel.
	 * 
	 * @param event
	 *            an event object
	 */
	public void kickEvent(IrcEvent<KickCommand> event);

	/**
	 * Invoked when an unrecognized command is received.
	 * 
	 * @param event
	 *            an event object
	 */
	public void unknownCommandEvent(IrcEvent<UnknownCommand> event);

	/**
	 * Invoked when someone joins a channel.
	 * 
	 * @param event
	 *            an event object
	 */
	public void joinEvent(IrcEvent<JoinCommand> event);

	/**
	 * Invoked when an unrecognized client-to-client protocol (CTCP) command is
	 * received.
	 * 
	 * @param event
	 *            an event object
	 */
	public void unknwonCtcpEvent(IrcEvent<CtcpCommand> event);
}
