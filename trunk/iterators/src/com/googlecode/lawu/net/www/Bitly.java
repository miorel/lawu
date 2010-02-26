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

import com.googlecode.lawu.json.JsonObject;
import com.googlecode.lawu.json.JsonParser;
import com.googlecode.lawu.json.JsonString;
import com.googlecode.lawu.util.Iterators;
import com.googlecode.lawu.util.Strings;

public class Bitly extends UrlShortener {
	private final String login;
	private final String apiKey;
	
	private final JsonParser parser;
	
	public Bitly(String login, String apiKey) {
		if(login == null || login.isEmpty())
			throw new IllegalArgumentException("The login may not be null or zero length.");
		if(apiKey == null || apiKey.isEmpty())
			throw new IllegalArgumentException("The API key may not be null or zero length.");
		this.login = login;
		this.apiKey = apiKey;
		this.parser = new JsonParser();
	}
	
	protected String getLogin() {
		return login;
	}

	protected String getApiKey() {
		return apiKey;
	}
	
	public String shorten(String longUrl) {
		if(longUrl.indexOf("://") < 0)
			longUrl = "http://" + longUrl;
		String requestUrl = null;
		try {
			requestUrl = String.format("http://api.bit.ly/shorten?version=2.0.1&longUrl=%s&format=json&login=%s&apiKey=%s", URLEncoder.encode(longUrl, "UTF-8"), URLEncoder.encode(getLogin(), "UTF-8"), URLEncoder.encode(getApiKey(), "UTF-8"));
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
		String json = null;
		try {
			json = Strings.join("\n", Iterators.lines(new URL(requestUrl).openStream()));
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
		JsonObject jsonObj = (JsonObject) parser.parse(json); 
		return ((JsonString) jsonObj.get("results", longUrl, "shortUrl")).getValue();
	}
}
