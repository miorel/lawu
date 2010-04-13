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

/**
 * Takes a URL and returns a (usually) shorter one that redirects to the same
 * resource.
 * 
 * @author Miorel-Lucian Palii
 */
public interface UrlShortener {
	/**
	 * Shortens the specified URL.
	 * 
	 * @param longUrl
	 *            the URL to shorten
	 * @return a shortened URL
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public String shorten(String longUrl) throws IOException;
}
