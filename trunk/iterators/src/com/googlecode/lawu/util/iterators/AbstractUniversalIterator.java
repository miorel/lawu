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

import java.util.NoSuchElementException;

/**
 * Skeleton implementation of a <code>UniversalIterator</code>. Subclasses need
 * only implement the Gang of Four iterator methods.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type over which the iteration takes place
 */
public abstract class AbstractUniversalIterator<T> implements
	UniversalIterator<T> {
	/**
	 * Default constructor, does nothing.
	 */
	public AbstractUniversalIterator() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		return !isDone();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T next() {
		if(isDone())
			throw new NoSuchElementException("The iterator is done.");
		T ret = current();
		advance();
		return ret;
	}

	/**
	 * Always throws an <code>UnsupportedOperationException</code>. I adhere to
	 * the Dave Small philosophy that this method is an abomination. The ability
	 * to remove an element is not inherent to iterators, nor does it make sense
	 * for all iterators.
	 * 
	 * @throws UnsupportedOperationException
	 *             always
	 */
	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
			"This operation is an abomination.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniversalIterator<T> iterator() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasMoreElements() {
		return hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T nextElement() {
		return next();
	}
}
