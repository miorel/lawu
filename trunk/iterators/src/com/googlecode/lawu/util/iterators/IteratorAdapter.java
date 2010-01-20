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
 * Adapts a Gang of Four iterator to a <tt>UniversalIterator</tt> by wrapping
 * it.
 * 
 * @author Miorel-Lucian Palii
 * @param <T> type over which the iteration takes place.
 */
public class IteratorAdapter<T> extends AbstractUniversalIterator<T> {
	private Iterator<T> iterator;
	
	/**
	 * Constructs an adapter for the specified iterator.
	 * 
	 * @throws IllegalArgumentException if passed a <tt>null</tt> iterator.
	 */
	public IteratorAdapter(Iterator<T> iterator) {
		setIterator(iterator);
	}
	
	/**
	 * No-argument constructor to allow subclasses that can't immediately pass 
	 * an object via <tt>super()</tt>. Such subclasses should still call
	 * <tt>setIterator()</tt> within their constructors. 
	 */
	protected IteratorAdapter() {
		this.iterator = null;
	}

	/**
	 * Sets the adapted iterator. Should only be called once and from a
	 * constructor. 
	 */
	protected void setIterator(Iterator<T> iterator) {
		if(iterator == null)
			throw new IllegalArgumentException("Can't adapt null iterator.");
		this.iterator = iterator;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void advance() {
		iterator.advance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() {
		return iterator.current();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDone() {
		return iterator.isDone();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reset() throws IllegalStateException {
		iterator.reset();
	}	
}
