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
package com.googlecode.lawu.util;

/**
 * An object producer.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type of produced objects
 */
public interface Factory<T> {
	/**
	 * Builds and returns an object.
	 * 
	 * @return a newly-built object 
	 */
	public T build();
}
