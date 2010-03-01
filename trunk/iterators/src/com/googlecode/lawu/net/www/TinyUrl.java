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

import java.net.URL;
import java.net.URLEncoder;

import com.googlecode.lawu.util.Streams;

public class TinyUrl extends UrlShortener {
	public TinyUrl() {
	}
	
	public String shorten(String longUrl) {
		if(longUrl.indexOf("://") < 0)
			longUrl = "http://" + longUrl;
		String requestUrl = null;
		try {
			requestUrl = String.format("http://tinyurl.com/api-create.php?url=%s", URLEncoder.encode(longUrl, "UTF-8"));
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
		String text = null;
		try {
			text = Streams.slurp(new URL(requestUrl)).toString();
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
		return text.trim();
	}
}
