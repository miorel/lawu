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

import java.util.Iterator;

/**
 * Adapter for a Java <code>Iterator</code>. Because Java's
 * <code>Iterator</code>s do not provide a <code>reset()</code>-like
 * operation, the returned iterator will not be resettable.
 * 
 * @author Miorel-Lucian Palii
 * @param <T> type over which the iteration takes place
 */
public class JIteratorAdapter<T> extends IteratorAdapter<T> {
	private final Iterator<T> iterator;

	/**
	 * Constructs an iterator that adapts the specified Java
	 * <code>Iterator</code>.
	 *  
	 * @param iterator the adaptee
	 * @throws IllegalArgumentException if passed <code>null</code>
	 */
	public JIteratorAdapter(Iterator<T> iterator) throws IllegalArgumentException {
		if(iterator == null)
			throw new IllegalArgumentException("Can't adapt null iterator.");
		this.iterator = iterator;
		init();
	}

	/**
	 * Constructs an iterator that adapts the specified <code>Iterable</code>.
	 *  
	 * @param iterable the adaptee
	 * @throws IllegalArgumentException if passed <code>null</code>
	 */
	public JIteratorAdapter(Iterable<T> iterable) throws IllegalArgumentException {
		if(iterable == null)
			throw new IllegalArgumentException("Can't adapt null iterable.");
		Iterator<T> iterator = iterable.iterator();
		if(iterator == null)
			throw new IllegalArgumentException("Can't adapt null iterator.");
		this.iterator = iterator;
		init();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doAdvance() {
		setCurrent(iterator.next());
		if(!iterator.hasNext())
			markAsDone();
	}
}
