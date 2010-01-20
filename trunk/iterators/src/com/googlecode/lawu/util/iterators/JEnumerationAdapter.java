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

import java.util.Enumeration;

/**
 * Adapter for a Java <code>Enumeration</code>. Because
 * <code>Enumeration</code>s do not provide a <code>reset()</code>-like
 * operation, the returned iterator will not be resettable.
 * 
 * @author Miorel-Lucian Palii
 * @param <T> type over which the iteration takes place
 */
public class JEnumerationAdapter<T> extends IteratorAdapter<T> {
	private final Enumeration<T> enumeration;
	
	/**
	 * Constructs an iterator that adapts the specified
	 * <code>Enumeration</code>.
	 *  
	 * @param enumeration the adaptee
	 * @throws IllegalArgumentException if passed <code>null</code>
	 */
	public JEnumerationAdapter(Enumeration<T> enumeration) throws IllegalArgumentException {
		if(enumeration == null)
			throw new IllegalArgumentException("Can't adapt null iterator.");
		this.enumeration = enumeration;
		init();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doAdvance() {
		setCurrent(enumeration.nextElement());
		if(!enumeration.hasMoreElements())
			markAsDone();
	}
}
