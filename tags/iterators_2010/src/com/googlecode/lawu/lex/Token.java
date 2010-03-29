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
package com.googlecode.lawu.lex;

public class Token<P extends TokenPattern> {
	private final P type;
	private final String value;
	
	public Token(P type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public P getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}
}

