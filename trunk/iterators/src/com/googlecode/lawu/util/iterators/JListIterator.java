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

import java.util.List;

/**
 * An iterator over a Java <code>List</code>.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type of elements in the list
 */
public class JListIterator<T> extends ListIterator<T> {
	private final List<T> list;

	/**
	 * Constructs an iterator over the specified list.
	 * 
	 * @param list
	 *            list over which to iterate
	 */
	public JListIterator(List<T> list) {
		super(0, list.size());
		this.list = list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected T get(int position) {
		return list.get(position);
	}
}
