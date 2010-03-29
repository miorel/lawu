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
 * An iterator over an array.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type of elements in the array
 */
public class ArrayIterator<T> extends ListIterator<T> {
	private final T[] array;

	/**
	 * Constructs an iterator over the specified array.
	 * 
	 * @param array
	 *            array over which to iterate
	 */
	public ArrayIterator(T[] array) {
		super(0, array.length);
		this.array = array;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected T get(int position) {
		return array[position];
	}
}
