/*
 * lawu
 * Copyright (C) 2009 Miorel-Lucian Palii
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
package lawu.util.iterator;

import java.util.NoSuchElementException;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public abstract class AbstractUniversalIterator<T> implements UniversalIterator<T> {
	/**
	 * 
	 */
	public AbstractUniversalIterator() {
	}
	
	public boolean hasNext() {
		return !isDone();
	}

	public T next() {
		if(isDone())
			throw new NoSuchElementException("");
		T ret = current();
		advance();
		return ret;
	}

	/**
	 * Always throws an <code>UnsupportedOperationException</code>. I adhere to
	 * the Dave Small philosophy that this method is an abomination. The
	 * ability to remove an element is not inherent to iterators, nor does it
	 * make sense for all iterators. 
	 * 
	 * @throws UnsupportedOperationException always
	 */
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	public UniversalIterator<T> iterator() {
		return this;
	}

	public boolean hasMoreElements() {
		return hasNext();
	}

	public T nextElement() {
		return next();
	}	
}
