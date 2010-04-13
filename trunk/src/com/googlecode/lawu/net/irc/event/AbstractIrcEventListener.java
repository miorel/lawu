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
 * Basic implementation of the {@link IrcEventListener} interface providing
 * empty implementations for all the methods.
 * 
 * @author Miorel-Lucian Palii
 */
public abstract class AbstractIrcEventListener implements IrcEventListener {
	@Override
	public void pingEvent(IrcEvent<PingCommand> event) {
	}

	@Override
	public void inviteEvent(IrcEvent<InviteCommand> event) {
	}

	@Override
	public void kickEvent(IrcEvent<KickCommand> event) {
	}

	@Override
	public void nickEvent(IrcEvent<NickCommand> event) {
	}

	@Override
	public void noticeEvent(IrcEvent<NoticeCommand> event) {
	}

	@Override
	public void privmsgEvent(IrcEvent<PrivmsgCommand> event) {
	}

	@Override
	public void quitEvent(IrcEvent<QuitCommand> event) {
	}

	@Override
	public void unknownCommandEvent(IrcEvent<UnknownCommand> event) {
	}

	@Override
	public void joinEvent(IrcEvent<JoinCommand> event) {
	}
	
	@Override
	public void unknwonCtcpEvent(IrcEvent<CtcpCommand> event) {
	}
}
