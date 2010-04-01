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
 *            type over which the iteration takes place
 */
public class JoiningIterator<T> extends AbstractUniversalIterator<T> {
	private final Iterator<? extends Iterator<? extends T>> iterator;

	/**
	 * Unfolds an iterator of iterators by joining the elements of its elements.
	 * 
	 * @param iterator
	 *            iterator of iterators over which to iterate :)
	 */
	public JoiningIterator(Iterator<? extends Iterator<? extends T>> iterator) {
		if(iterator == null)
			throw new NullPointerException("Can't unfold a null iterator.");
		this.iterator = iterator;
		reset();
	}

	@Override
	public void advance() {
		iterator.current().advance();
		validateState();
	}

	@Override
	public T current() {
		return iterator.current().current();
	}

	@Override
	public boolean isDone() {
		return iterator.isDone();
	}

	@Override
	public void reset() {
		iterator.reset();
		if(!iterator.isDone()) {
			iterator.current().reset();
			validateState();
		}
	}
	
	private void validateState() {
		while(iterator.current().isDone()) {
			iterator.advance();
			if(iterator.isDone())
				break;
			iterator.current().reset();
		}	
	}
}
