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
 * <p>
 * An iterator over a list.
 * </p> 
 *
 * <p>
 * There is no defense mechanism preventing modification of the underlying
 * list while this iterator is in use. Any changes will therefore propagate
 * through to users of this iterator. Taking advantage of this is discouraged.
 * </p>
 * 
 * @author Miorel-Lucian Palii
 * @param <T> type of elements in the list
 */
public class ListIterator<T> extends AbstractUniversalIterator<T> {
	private final List<T> list;
	private int pointer;
	
	/**
	 * Constructs an iterator over the specified list.
	 *  
	 * @param list list over which to iterate
	 * @throws IllegalArgumentException if passed <code>null</code>
	 */
	public ListIterator(List<T> list) throws IllegalArgumentException {
		if(list == null)
			throw new IllegalArgumentException("Can't iterate over null list.");
		this.list = list;
		reset();
	}

	/**
	 * Advances this iterator to the next position in the list.
	 */
	@Override
	public void advance() {
		++pointer;
	}

	/**
	 * Retrieves the current element in the list.
	 * 
	 * @return the current list element
	 */
	@Override
	public T current() {
		return list.get(pointer);
	}

	/**
	 * Checks whether this iterator has reached the end of the list.
	 * 
	 * @return whether the end of the list has been reached
	 */
	@Override
	public boolean isDone() {
		return pointer >= list.size();
	}

	/**
	 * Moves this iterator to the beginning of the list.
	 */
	@Override
	public void reset() {
		pointer = 0;
	}
}
