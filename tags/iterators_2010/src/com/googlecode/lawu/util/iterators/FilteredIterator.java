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
import com.googlecode.lawu.util.Filter;

/**
 * Applies a filter to a traversal.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type over which the iteration takes place
 */
public class FilteredIterator<T> extends AbstractUniversalIterator<T> {
	private final Filter<? super T> filter;
	private final Iterator<? extends T> iterator;
	private boolean beginning;

	/**
	 * Constructs an iterator that applies the specified filter to the given
	 * traversal.
	 * 
	 * @param filter
	 *            the filter to apply
	 * @param iterator
	 *            the traversal to filter
	 */
	public FilteredIterator(Filter<? super T> filter, Iterator<? extends T> iterator) {
		if(iterator == null)
			throw new IllegalArgumentException("Can't filter null iterator.");
		if(filter == null)
			throw new IllegalArgumentException("Can't use null filter.");
		this.filter = filter;
		this.iterator = iterator;
		this.beginning = false;
		reset();
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public void advance() {
		beginning = false;
		do
			iterator.advance();
		while(!iterator.isDone() && !filter.keep(iterator.current()));
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public T current() {
		return iterator.current();
	}

	/**
	 * {inheritDoc}
	 */
	@Override	
	public boolean isDone() {
		return iterator.isDone();
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public void reset() {
		if(!beginning) {
			iterator.reset();
			if(!filter.keep(iterator.current()))
				advance();
			beginning = true;
		}
	}
}
