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
 * Abstract, template method-based iterator over a list or list-like structure.
 * </p>
 * <p>
 * Subclasses need only to define the starting and ending positions in the list,
 * as well as the mechanism for accessing the element at a given position. 
 * </p>
 * <p>
 * In general, there is no defense mechanism preventing modification of any
 * underlying list while this iterator is in use. Any changes will therefore
 * propagate through to users of this iterator. Taking advantage of this is
 * discouraged.
 * </p>
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type of elements in the list
 */
public abstract class ListIterator<T> extends AbstractUniversalIterator<T> implements Cloneable, ReversibleIterator<T> {
	private int begin;
	private int end;
	private int increment;	

	private int pointer;

	/**
	 * Constructs an iterator that will traverse the list values in the
	 * specified range of positions. The first position is inclusive, the
	 * last position is not inclusive.
	 * 
	 * @param begin the first position in the range
	 * @param end the position immediately after the last position in the range
	 */
	public ListIterator(int begin, int end) {
		this.begin = begin;
		this.end = end;
		this.increment = begin < end ? 1 : -1;
		reset();
	}
	
	/**
	 * Advances this iterator to the next position in the underlying list or
	 * list-like structure.
	 */
	@Override
	public void advance() {
		if(!isDone())
			pointer += increment;
	}

	/**
	 * Defines how this iterator accesses the element at the specified position
	 * in the underlying list or list-like structure.
	 * 
	 * @param position index of the element to return
	 * @return the element at the specified position in the list
	 */
	protected abstract T get(int position);
	
	/**
	 * Retrieves the current element in the underlying list or list-like
	 * structure.
	 * 
	 * @return the current list element
	 */
	@Override
	public T current() {
		return get(pointer);
	}
	
	/**
	 * Checks whether this iterator has reached the end of the list traversal.
	 * 
	 * @return whether the end of the list traversal has been reached
	 */
	@Override
	public boolean isDone() {
		return pointer == end;
	}

	/**
	 * Moves this iterator to the beginning of its list traversal.
	 */
	@Override
	public void reset() {
		pointer = begin;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected ListIterator<T> clone() {
		ListIterator<T> ret = null;
		try {
			ret = (ListIterator<T>) super.clone();
		}
		catch(CloneNotSupportedException e) {
			throw new Error("A cloneable object threw a CNSE!", e);
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReversibleIterator<T> reverse() {
		ListIterator<T> ret = clone();
		ret.begin = end - increment;
		ret.end = begin - increment;
		ret.increment = -increment;
		ret.reset();
		return ret;
	}	
}
