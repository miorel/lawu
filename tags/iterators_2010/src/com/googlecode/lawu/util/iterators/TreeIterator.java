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

import java.util.Stack;

import com.googlecode.lawu.dp.Iterator;

/**
 * <p>
 * Abstract, template method-based iterator over a tree or tree-like structure.
 * </p>
 * <p>
 * The traversal is currently done depth-first (though this is not set in
 * stone). This class works by managing a stack of iterators.
 * </p>
 * <p>
 * Tree surgeries during the traversal are likely to produce unexpected results
 * and should therefore be avoided. "Trees" containing cycles will produce
 * infinite traversals unless you find a clever way to avoid visiting elements
 * multiple times.
 * </p>
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type over which the iteration takes place
 */
public abstract class TreeIterator<T> extends AbstractUniversalIterator<T> {
	private final Stack<Iterator<T>> iterators = new Stack<Iterator<T>>();

	/**
	 * Default constructor, does nothing special.
	 */
	public TreeIterator() {
	}

	/**
	 * Advances this iterator to the next tree element.
	 */
	@Override
	public void advance() {
		if(!isDone()) {
			T current = current();
			iterators.peek().advance();
			iterators.push(childIterator(current));
			while(!isDone() && iterators.peek().isDone())
				iterators.pop();
		}
	}
	
	/**
	 * Defines the mechanism for obtaining the children of a particular element.
	 * 
	 * @param element parent of the elements to iterate over
	 * @return an iterator over the element's children
	 */
	protected abstract Iterator<T> childIterator(T element);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() {
		return iterators.peek().current();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDone() {
		return iterators.isEmpty();
	}

	/**
	 * Moves this iterator to the root of the tree traversal.
	 */
	@Override
	public void reset() {
		iterators.clear();
		iterators.add(getInitialIterator());
	}
	
	/**
	 * Defines the mechanism for getting the initial element iterator. This will
	 * most likely just be a single element iterator, containing the root of the
	 * traversal.
	 * 
	 * @return the initial element iterator
	 */
	protected abstract Iterator<T> getInitialIterator();
}