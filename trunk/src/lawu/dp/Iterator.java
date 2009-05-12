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
package lawu.dp;

/**
 * The Gang of Four's favorite iterator interface. Abstracts the traversal of an
 * aggregate structure from the underlying representation. Note that method
 * names have been modified from those given by the Gang of Four but the
 * behavior is the same. Use an iterator as follows:
 * 
 * <pre>
 * Iterator&lt;SomeType&gt; iter = someMethod();
 * for(iter.reset(); !iter.isDone(); iter.advance()) {
 *    // do something with iter.current()
 * }
 * </pre>
 * 
 * @author Miorel-Lucian Palii
 * @param <T> the type over which this iterator iterates
 */
public interface Iterator<T> {
	/**
	 * Moves this iterator to the beginning of the traversal.
	 */
	public void reset();

	/**
	 * Checks whether or not this iterator has exhausted all the elements of its
	 * underlying structure.
	 * 
	 * @return whether or not this iterator has exhausted all its elements
	 */
	public boolean isDone();

	/**
	 * Advances this iterator to the next element.
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
