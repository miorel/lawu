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
 * An iterator that joins the traversals of a group of iterators into one.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 */
public class JoiningIterator<T> extends AbstractUniversalIterator<T> {
	private final Iterator<? extends Iterator<? extends T>> iterator;

	/**
	 * Unfolds an iterator of iterators by joining the elements of its elements.
	 * 
	 * @param iterator
	 *            list over which to iterate
	 */
	public JoiningIterator(Iterator<? extends Iterator<? extends T>> iterator) {
		if(iterator == null)
			throw new IllegalArgumentException("Can't unfold null iterator.");
		this.iterator = iterator;
		reset();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void advance() {
		while(iterator.current().isDone() && !iterator.isDone()) {
			iterator.advance();
			iterator.current().reset();
		}
		iterator.current().advance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() {
		return iterator.current().current();
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
	public void reset() {
		iterator.reset();
		if(!iterator.isDone())
			iterator.current().reset();
	}
}
