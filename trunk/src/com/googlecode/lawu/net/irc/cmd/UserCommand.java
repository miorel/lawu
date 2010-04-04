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

public class UserCommand extends AbstractIrcCommand {
	public static final int MODE_INVISIBLE = 1 << 3;
	public static final int MODE_WALLOPS = 1 << 2;
	
	private final String userName;
	private final int initialMode;
	private final String realName;
	
	public UserCommand(String userName, int initialMode, String realName) {
		validateString("user name", userName, false, false);
		if(initialMode < 0)
			throw new IllegalArgumentException("The initial mode may not be negative.");
		validateString("real name", realName, false, true);
		this.userName = userName;
		this.initialMode = initialMode;
		this.realName = realName;
	}
	
	public UserCommand(String userName, String realName) {
		this(userName, MODE_INVISIBLE | MODE_WALLOPS, realName);
	}
	
	public String getUserName() {
		return userName;
	}

	public String getRealName() {
		return realName;
	}
	
	public int getInitialMode() {
		return initialMode;
	}
	
	@Override
	public UniversalIterator<String> getArguments() {
		return iterator(userName, Integer.toString(getInitialMode()), "*", realName);
	}

	@Override
	public String getCommand() {
		return "USER";
	}
}
