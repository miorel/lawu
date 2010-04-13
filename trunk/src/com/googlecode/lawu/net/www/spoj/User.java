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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.googlecode.lawu.util.Iterators.*;
import com.googlecode.lawu.util.Strings;
import com.googlecode.lawu.util.iterators.ReversibleIterator;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class User {
	private final String username;
	private final List<Submission> submissions = new ArrayList<Submission>();
	
	private boolean readSubmissions = false;
	
	public User(String username) {
		username = username.toLowerCase(Locale.ENGLISH);
		if(!username.matches("[a-z][a-z\\d_]{2,13}"))
			throw new IllegalArgumentException("Invalid username.");
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public URL getSubmissionsUrl() {
		return Strings.getUrl("http://www.spoj.pl/status/" + this.username + "/signedlist/");
	}

	public URL getUserPageUrl() {
		return Strings.getUrl("http://www.spoj.pl/users/" + this.username + "/");
	}
	
	public ReversibleIterator<Submission> getSubmissions() throws IOException {
		ReversibleIterator<Submission> ret;
		synchronized(submissions) {
			if(!readSubmissions) {
				submissions.clear();
				UniversalIterator<String> lines = lines(getSubmissionsUrl());
				while(!lines.isDone() && !lines.current().matches("\\s*(?:\\|-+){7}\\|\\s*"))
					lines.advance();
				if(!lines.isDone())
					lines.advance();
				for(String line: lines) {
					if(line.matches("\\\\-+\\/"))
						break;
					submissions.add(Submission.parse(this, line));
				}
				readSubmissions = true;
			}
			ret = copy(iterator(submissions)).reverse();
		}
		return ret;
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
		return "SPOJ user " + this.username;
	}
}
