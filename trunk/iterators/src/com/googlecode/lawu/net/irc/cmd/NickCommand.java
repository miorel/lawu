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

public class NickCommand extends IrcNicknameCommand implements IncomingIrcCommand {
	public NickCommand(String nick) {
		super(nick);
	}
	
	@Override
	public String getCommand() {
		return "NICK";
	}

	@Override
	public IrcEvent<NickCommand> getEvent(final IrcClient client, final Entity origin) {
		return new AbstractIrcEvent<NickCommand>(client, origin, this) {
			@Override
			protected void doTrigger(IrcEventListener listener) {
				listener.nickEvent(this);
			}		
		};
	}
	
	public static NickCommand build(String[] param) {
		validateParam(param, 1);
		return new NickCommand(param[0]);
	}
}
