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

public class NoticeCommand extends IrcTargetMessageCommand implements IncomingIrcCommand {	
	public NoticeCommand(String target, String message) {
		super(target, message);
	}
	
	@Override
	public String getCommand() {
		return "NOTICE";
	}

	@Override
	public IrcEvent<NoticeCommand> getEvent(final IrcClient client, final Entity origin) {
		return new AbstractIrcEvent<NoticeCommand>(client, origin, this) {
			@Override
			protected void doTrigger(IrcEventListener listener) {
				listener.noticeEvent(this);
			}		
		};
	}
	
	public static NoticeCommand build(String[] param) {
		validateParam(param, 2);
		return new NoticeCommand(param[0], param[1]);
	}
}
