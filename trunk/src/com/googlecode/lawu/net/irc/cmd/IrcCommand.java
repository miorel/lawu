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

import com.googlecode.lawu.util.iterators.UniversalIterator;

/**
 * Object representation of an IRC command.
 * 
 * @author Miorel-Lucian Palii
 */
public interface IrcCommand {
	/**
	 * Returns the command's identifying string.
	 * 
	 * @return the command's identifier
	 */
	public String getCommand();
	
	/**
	 * Returns an iterator over the command's arguments.
	 * 
	 * @return the command's arguments
	 */
	public UniversalIterator<String> getArguments();
}
