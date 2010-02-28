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

import com.googlecode.lawu.util.Strings;

public abstract class AbstractIrcCommand implements IrcCommand {
	public AbstractIrcCommand() {
	}
		
	protected void validateNick(String nick) {
		validateString("nickname", nick, false, false);
	}

	protected void validateChannel(String channel) {
		validateString("channel name", channel, false, false);
	}
	
	protected void validateMessage(String message, boolean required) {
		validateString("message", message, !required, required);
	}

	protected static void validateParam(String[] param, int size) {
		validateParam(param, size, size);
	}
	
	protected static void validateParam(String[] param, int minSize, int maxSize) {
		if(param == null)
			throw new IllegalArgumentException("The parameter array may not be null.");
		if(param.length < minSize || param.length > maxSize)
			throw new IllegalArgumentException("The parameter array had unexpected size.");
		for(String p: param)
			if(p == null)
				throw new IllegalArgumentException("Null parameter not allowed.");	
	}
	
	protected static void validateString(String identifier, String string, boolean nullAllowed, boolean emptyAllowed) {
		String problem = null;
		if(string == null) {
			if(!nullAllowed) {
				problem = "The " + identifier + " may not be null";
				if(emptyAllowed)
					problem += ", use the empty string instead";
				problem += ".";
			}
		}
		else if(string.isEmpty()) {
			if(!emptyAllowed) {
				problem = "The " + identifier + " may not be zero length";
				if(nullAllowed)
					problem += ", use null instead";
				problem += ".";
			}
		}
		else if(!Strings.isSingleLine(string))
			problem = "The " + identifier + " may not be multi-line.";
		if(problem != null)
			throw new IllegalArgumentException(problem);
	}
}
