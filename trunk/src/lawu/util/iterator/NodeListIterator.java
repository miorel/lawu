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

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Miorel-Lucian Palii
 */
public class NodeListIterator extends AbstractUniversalIterator<Node> {
	private final NodeList list;
	private int pointer;

	/**
	 * @param list
	 */
	public NodeListIterator(NodeList list) {
		this.list = list;
		reset();
	}

	public void advance() {
		++this.pointer;
	}

	public Node current() {
		return this.list.item(this.pointer);
	}

	public boolean isDone() {
		return this.pointer >= this.list.getLength();
	}

	public void reset() {
		this.pointer = 0;
	}
}
