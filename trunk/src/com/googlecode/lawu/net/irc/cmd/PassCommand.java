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

import static com.googlecode.lawu.util.Iterators.*;
import com.googlecode.lawu.util.iterators.UniversalIterator;

/**
 * An IRC password command.
 * 
 * @author Miorel-Lucian Palii
 */
public class PassCommand extends AbstractIrcCommand {
	private final String password;
	
	public PassCommand(String password) {
		validateString("password", password, false, false);
		this.password = password;
	}

	/**
	 * Returns the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	@Override
	public UniversalIterator<String> getArguments() {
		return iterator(this.password);
	}

	@Override
	public String getCommand() {
		return "PASS";
	}
}
