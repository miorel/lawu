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
package com.googlecode.lawu.util.iterators;

import java.util.Enumeration;

import com.googlecode.lawu.dp.Iterator;

/**
 * Interface combining Java's <code>Iterator</code>, <code>Iterable</code>, and
 * <code>Enumeration</code> with the Gang of Four iterator.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type over which the iteration takes place
 */
public interface UniversalIterator<T> extends Iterator<T>, java.util.Iterator<T>, Iterable<T>, Enumeration<T> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniversalIterator<T> iterator();
}
