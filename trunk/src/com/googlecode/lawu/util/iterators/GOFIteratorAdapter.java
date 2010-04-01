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

import com.googlecode.lawu.dp.Iterator;

/**
 * Adapts a {@linkplain Iterator Gang of Four iterator} to a
 * {@link UniversalIterator} by wrapping it.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type over which the iteration takes place
 */
public class GOFIteratorAdapter<T> extends AbstractUniversalIterator<T> {
	private final Iterator<T> iterator;

	/**
	 * Constructs an adapter for the specified iterator.
	 * 
	 * @param iterator
	 *            the adaptee
	 */
	public GOFIteratorAdapter(Iterator<T> iterator) {
		if(iterator == null)
			throw new NullPointerException("Can't adapt null iterator.");
		this.iterator = iterator;
	}

	@Override
	public void advance() {
		iterator.advance();
	}

	@Override
	public T current() {
		return iterator.current();
	}

	@Override
	public boolean isDone() {
		return iterator.isDone();
	}

	@Override
	public void reset() throws IllegalStateException {
		iterator.reset();
	}
}
