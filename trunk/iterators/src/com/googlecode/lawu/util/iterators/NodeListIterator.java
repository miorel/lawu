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
 * @author Miorel-Lucian Palii
 */
public class NodeListIterator extends ListIterator<Node> {
	private final NodeList list;

	/**
	 * Constructs an iterator over the nodes of the specified list.
	 * 
	 * @param list
	 *            list over which to iterate
	 */
	public NodeListIterator(NodeList list) {
		super(0, list.getLength());
		this.list = list;
	}

	/**
	 * Constructs an iterator over the children of the specified node.
	 * 
	 * @param node
	 *            parent of the nodes over which to iterate
	 */
	public NodeListIterator(Node node) {
		this(node.getChildNodes());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Node get(int position) {
		return list.item(position);
	}
}
