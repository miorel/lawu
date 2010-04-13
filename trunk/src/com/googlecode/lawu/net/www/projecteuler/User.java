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
package com.googlecode.lawu.net.www.projecteuler;

import java.net.URL;
import java.util.Locale;

import com.googlecode.lawu.util.Strings;

public class User {
	private final String username;
	
	public User(String username) {
		username = username.toLowerCase(Locale.ENGLISH);
		if(!username.matches("[\\w\\.]{1,25}"))
			throw new IllegalArgumentException("Invalid username.");
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}

	public URL getUserPageUrl() {
		return Strings.getUrl("http://projecteuler.net/index.php?section=profile&profile=" + this.username);
	}
	
	@Override
	public int hashCode() {
		return this.username.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj == this || (obj instanceof User && this.username.equals(((User) obj).username)); 
	}
	
	@Override
	public String toString() {
		return "Project Euler user " + this.username;
	}
}
