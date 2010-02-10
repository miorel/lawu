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
 * <p>
 * Holds a value.
 * </p>
 * <p>
 * Believe it or not, this class could be useful in some rare situations. For
 * example, if an anonymous class requires a local variable to be
 * <code>final</code> but you don't want it to be, simply put it in a final
 * wrapper!
 * </p>
 * 
 * @author Miorel-Lucian Palii
 * @param <T> type of objects the wrapper may hold
 */
public class Wrapper<T> {
	public T value;
	
	/**
	 * Constructs a wrapper initially holding <code>null</code>.
	 */
	public Wrapper() {
		this(null);
	}
	
	/**
	 * Constructs a wrapper initially holding the specified value.
	 * 
	 * @param value the initial value
	 */
	public Wrapper(T value) {
		this.value = value;
	}
}
