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

/**
 * A query message sent to an IRC service.
 * 
 * @author Miorel-Lucian Palii
 */
public class SqueryCommand extends IrcTargetMessageCommand {
	/**
	 * Builds a service query command with the specified message directed at the
	 * target.
	 * 
	 * @param target
	 *            the message target
	 * @param message
	 *            the query
	 */
	public SqueryCommand(String target, String message) {
		super(target, message);
	}
	
	@Override
	public String getCommand() {
		return "SQUERY";
	}
}
