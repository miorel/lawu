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

import java.util.List;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class ListIterator<T> extends AbstractUniversalIterator<T> {
	private final List<T> list;
	private int pointer;
	
	/**
	 * @param list
	 */
	public ListIterator(List<T> list) {
		this.list = list;
		reset();
	}
	
	@Override
	public void advance() {
		++this.pointer;
	}

	@Override
	public T current() {
		return this.list.get(this.pointer);
	}

	@Override
	public boolean isDone() {
		return this.pointer >= this.list.size();
	}

	@Override
	public void reset() {
		this.pointer = 0;
	}
}
