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
package com.googlecode.lawu.dp;

/**
 * The Gang of Four's favorite iterator interface. Abstracts the traversal of an
 * aggregate structure from the underlying representation. Note that method
 * names have been modified from those given by the Gang of Four but the
 * behavior is the same.
 * 
 * Use an iterator as follows:
 *
 * <pre>
 * Iterator&lt;SomeType&gt; iter = someMethod();
 * for(iter.reset(); !iter.isDone(); iter.advance()) {
 *    // do something with iter.current()
 * }
 * </pre>
 * 
 * @author Miorel-Lucian Palii
 * @param <T> type over which the iteration takes place
 */
public interface Iterator<T> {
	/**
	 * Moves this iterator to the beginning of the traversal. Some iterators
	 * cannot be reset once the iteration started. For example, an iterator
	 * over the lines of an input stream probably can't reread old lines. But
	 * all iterators should allow exception-less calls to <tt>reset()</tt>
	 * before any calls to <tt>advance()</tt>.  
	 * 
	 * @throws IllegalStateException if resetting this iterator is impossible
	 */
	public void reset() throws IllegalStateException;

	/**
	 * Checks whether this iterator has exhausted all the elements of its
	 * underlying structure.
	 * 
	 * @return whether all elements have been exhausted
	 */
	public boolean isDone();

	/**
	 * Advances this iterator to the next element in the traversal. Behavior
	 * is undefined if the iterator is done.
	 */
	public void advance();

	/**
	 * Retrieves the current element in the traversal represented by this
	 * iterator.
	 * 
	 * @return the current element in the traversal
	 */
	public T current();
}
