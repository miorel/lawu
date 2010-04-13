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

import com.googlecode.lawu.json.JsonObject;
import com.googlecode.lawu.json.JsonParser;
import com.googlecode.lawu.json.JsonString;
import com.googlecode.lawu.util.Streams;
import com.googlecode.lawu.util.Strings;

/**
 * A {@link UrlShortener} that uses the <a href="http://bit.ly/">bit.ly</a>
 * service.
 * 
 * @author Miorel-Lucian Palii
 */
public class Bitly implements UrlShortener {
	private final String login;
	private final String apiKey;
	
	private final JsonParser parser;

	/**
	 * Constructs a new URL shortener using the specified login and API key.
	 * 
	 * @param login
	 *            the <code>bit.ly</code> login
	 * @param apiKey
	 *            the <code>bit.ly</code> API key
	 */
	public Bitly(String login, String apiKey) {
		if(login == null)
			throw new NullPointerException("The login may not be null.");
		if(login.isEmpty())
			throw new IllegalArgumentException("The login may not be zero length.");
		if(apiKey == null)
			throw new NullPointerException("The API key may not be null.");
		if(apiKey .isEmpty())
			throw new IllegalArgumentException("The API key may not be zero length.");
		this.login = login;
		this.apiKey = apiKey;
		this.parser = new JsonParser();
	}
	
	/**
	 * Returns this shortener's login.
	 * 
	 * @return the <code>bit.ly</code> login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Returns this shortener's API key.
	 * 
	 * @return the <code>bit.ly</code> API key
	 */
	public String getApiKey() {
		return this.apiKey;
	}
	
	public String shorten(String longUrl) throws IOException {
		if(longUrl.indexOf("://") < 0)
			longUrl = "http://" + longUrl;
		String requestUrl = String.format("http://api.bit.ly/shorten?version=2.0.1&longUrl=%s&format=json&login=%s&apiKey=%s", Strings.encodeUtf8(longUrl), Strings.encodeUtf8(this.login), Strings.encodeUtf8(this.apiKey));
		CharSequence json = Streams.slurp(new URL(requestUrl));
		JsonObject jsonObj = (JsonObject) this.parser.parse(json); 
		return ((JsonString) jsonObj.get("results", longUrl, "shortUrl")).getValue();
	}
}
