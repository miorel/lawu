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

import com.googlecode.lawu.dp.Iterator;

/**
 * An IRC pong message.
 * 
 * @author Miorel-Lucian Palii
 * @see PingCommand
 */
public class PongCommand extends IrcTargetsCommand {
	/**
	 * Builds an IRC pong with the specified targets.
	 * 
	 * @param targets
	 *            the entities to pong
	 */
	public PongCommand(Iterator<String> targets) {
		super(targets);
	}
	
	@Override
	public String getCommand() {
		return "PONG";
	}
}
