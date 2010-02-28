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

import com.googlecode.lawu.util.iterators.UniversalIterator;

public abstract class IrcNicknameCommand extends AbstractIrcCommand {
	private final String nick;
	
	public IrcNicknameCommand(String nick) {
		validateNick(nick);
		this.nick = nick;
	}
	
	public String getNick() {
		return nick;
	}
	
	@Override
	public UniversalIterator<String> getArguments() {
		return iterator(nick);
	}
}
