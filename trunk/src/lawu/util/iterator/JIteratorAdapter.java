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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Miorel-Lucian Palii
 *
 */
public class JIteratorAdapter<T> extends AbstractUniversalIterator<T> {
	private final List<T> list;
	private final Iterator<T> iterator;
	private int pointer;

	/**
	 * @param iterator
	 */
	public JIteratorAdapter(Iterator<T> iterator) {
		this.list = new ArrayList<T>();
		this.iterator = iterator;
		reset();
	}

	public void advance() {
		++this.pointer;
		current();
	}

	public T current() {
		T ret = null;
		if(this.pointer < this.list.size())
			ret = this.list.get(this.pointer);
		else if(this.iterator.hasNext()) {
			ret = this.iterator.next();
			this.list.add(ret);
		}
		return ret;
	}

	public boolean isDone() {
		return this.pointer >= this.list.size() && !this.iterator.hasNext();
	}

	public void reset() {
		this.pointer = 0;
	}
}
