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
import com.googlecode.lawu.util.Iterators;

/**
 * Interface for an iterator whose traversal order can be reversed.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type over which the iteration takes place
 * @see Iterators#reverse(Iterator)
 */
public interface ReversibleIterator<T> extends UniversalIterator<T> {
	/**
	 * Gives a copy of this iterator that visits exactly the same elements but
	 * in reverse order.
	 * 
	 * @return the reverse of this iterator
	 */
	public ReversibleIterator<T> reverse();
	
	@Override
	public ReversibleIterator<T> iterator();
}
