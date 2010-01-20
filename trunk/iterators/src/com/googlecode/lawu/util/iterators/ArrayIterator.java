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

/**
 * <p>
 * An iterator over an array.
 * </p>
 * 
 * <p>
 * There is no defense mechanism preventing modification of the underlying
 * array while this iterator is in use. Any changes will therefore propagate
 * through to users of this iterator. Taking advantage of this is discouraged.
 * </p>
 * 
 * @author Miorel-Lucian Palii
 * @param <T> type of elements in the array
 */
public class ArrayIterator<T> extends AbstractUniversalIterator<T> {
	private final T[] array;
	private int pointer;
		
	/**
	 * Constructs an iterator over the specified array. The varargs parameter
	 * makes for some syntactic sugar.
	 *  
	 * @param array array over which to iterate
	 * @throws IllegalArgumentException if passed a <code>null</code> array
	 */
	public ArrayIterator(T... array) throws IllegalArgumentException {
		if(array == null)
			throw new IllegalArgumentException("Can't iterate over null array.");
		this.array = array;
		reset();
	}

	/**
	 * Advances this iterator to the next position in the array.
	 */
	@Override
	public void advance() {
		++pointer;
	}

	/**
	 * Retrieves the current element in the array.
	 * 
	 * @return the current array element
	 */
	@Override
	public T current() {
		return array[pointer];
	}

	/**
	 * Checks whether this iterator has reached the end of the array.
	 * 
	 * @return whether the end of the array has been reached
	 */
	@Override
	public boolean isDone() {
		return pointer >= array.length;
	}

	/**
	 * Moves this iterator to the beginning of the array.
	 */
	@Override
	public void reset() {
		pointer = 0;
	}
}
