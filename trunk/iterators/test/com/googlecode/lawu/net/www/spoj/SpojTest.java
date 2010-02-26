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
package com.googlecode.lawu.net.www.spoj;

import static com.googlecode.lawu.util.Iterators.iterator;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.googlecode.lawu.net.www.spoj.User;

public class SpojTest {
	@Test(expected=NullPointerException.class)
	public void testConstructorWithNull() {
		new User(null);
	}
	
	@Test
	public void testConstructorWithIllegalArguments() {
		for(String username: iterator("", "a", "ab", "_", "_ab", "0", "0ab", "abcdefghijklmno")) {
			boolean success = false;
			try {
				new User(username);
			}
			catch(IllegalArgumentException e) {
				success = true;
			}
			if(!success)
				Assert.fail("Invalid username " + username + " did not throw an IllegalArgumentException.");
		}
	}
	
	@Test
	public void testSubmissions() throws IOException {
		for(String username: iterator("mlpalii", "r4ven", "hua", "mauriciofmar3", "rsalazar", "terinjokes", "john_jones", "made_up_user")) {
			User user = new User(username);
			user.getSubmissions();
		}
	}
}
