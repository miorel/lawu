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
import com.googlecode.lawu.net.irc.cmd.InviteCommand;
import com.googlecode.lawu.net.irc.cmd.JoinCommand;
import com.googlecode.lawu.net.irc.cmd.KickCommand;
import com.googlecode.lawu.net.irc.cmd.NickCommand;
import com.googlecode.lawu.net.irc.cmd.NoticeCommand;
import com.googlecode.lawu.net.irc.cmd.PingCommand;
import com.googlecode.lawu.net.irc.cmd.PrivmsgCommand;
import com.googlecode.lawu.net.irc.cmd.QuitCommand;
import com.googlecode.lawu.net.irc.cmd.UnknownCommand;

public interface IrcEventListener extends EventListener {
	public void nickEvent(IrcEvent<NickCommand> event);
	
	public void pingEvent(IrcEvent<PingCommand> event);

	public void noticeEvent(IrcEvent<NoticeCommand> event);
	
	public void privmsgEvent(IrcEvent<PrivmsgCommand> event);

	public void inviteEvent(IrcEvent<InviteCommand> event);

	public void quitEvent(IrcEvent<QuitCommand> event);

	public void kickEvent(IrcEvent<KickCommand> event);

	public void unknownCommandEvent(IrcEvent<UnknownCommand> event);

	public void joinEvent(IrcEvent<JoinCommand> event);
}
