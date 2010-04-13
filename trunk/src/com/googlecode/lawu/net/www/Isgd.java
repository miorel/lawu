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
package com.googlecode.lawu.net.www;

import java.io.IOException;
import java.net.URL;

import com.googlecode.lawu.util.Streams;
import com.googlecode.lawu.util.Strings;

/**
 * A {@link UrlShortener} that uses the <a href="http://is.gd/">is.gd</a>
 * service.
 * 
 * @author Miorel-Lucian Palii
 */
public class Isgd implements UrlShortener {
	/**
	 * Constructs a new URL shortener.
	 */
	public Isgd() {
	}
	
	public String shorten(String longUrl) throws IOException {
		String requestUrl = String.format("http://is.gd/api.php?longurl=%s", Strings.encodeUtf8(longUrl));
		return Streams.slurp(new URL(requestUrl)).toString().trim();
	}
}
