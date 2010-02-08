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

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * An iterator over the nodes of a <code>NodeList</code>.
 * 
 * There is no defense mechanism preventing modification of the underlying
 * list while this iterator is in use. Any changes will therefore propagate
 * through to users of this iterator. Taking advantage of this is discouraged.
 * 
 * @author Miorel-Lucian Palii
 */
public class NodeListIterator extends AbstractUniversalIterator<Node> {
	private final NodeList list;
	private int pointer;
	
	/**
	 * Constructs an iterator over the nodes of the specified list.
	 *  
	 * @param list list over which to iterate
	 */
	public NodeListIterator(NodeList list) {
		if(list == null)
			throw new IllegalArgumentException("Can't iterate over null list.");
		this.list = list;
		reset();
	}

	/**
	 * Advances this iterator to the next position in the list.
	 */
	@Override
	public void advance() {
		++pointer;
	}

	/**
	 * Retrieves the current node in the list.
	 * 
	 * @return the current node
	 */
	@Override
	public Node current() {
		return list.item(pointer);
	}

	/**
	 * Checks whether this iterator has reached the end of the list.
	 * 
	 * @return whether the end of the list has been reached
	 */
	@Override
	public boolean isDone() {
		return pointer >= list.getLength();
	}

	/**
	 * Moves this iterator to the beginning of the list.
	 */
	@Override
	public void reset() {
		pointer = 0;
	}
}
