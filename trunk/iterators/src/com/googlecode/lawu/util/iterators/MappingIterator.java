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
import com.googlecode.lawu.util.Mapper;

/**
 * Applies a mapping function to a traversal.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            domain of mapping function
 * @param <U>
 *            range of mapping function
 */
public class MappingIterator<T, U> extends AbstractUniversalIterator<U> {
	private final Mapper<? super T, ? extends U> mapper;
	private final Iterator<? extends T> iterator;

	/**
	 * Constructs an iterator that applies the specified mapping function to the
	 * given traversal.
	 * 
	 * @param mapper
	 *            the mapping function
	 * @param iterator
	 *            the traversal to map
	 */
	public MappingIterator(Mapper<? super T, ? extends U> mapper, Iterator<? extends T> iterator) {
		if(iterator == null)
			throw new IllegalArgumentException("Can't map null iterator.");
		if(mapper == null)
			throw new IllegalArgumentException("Can't use null mapper.");
		this.iterator = iterator;
		this.mapper = mapper;
		reset();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void advance() {
		this.iterator.advance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public U current() {
		return mapper.map(iterator.current());
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
	}
}
