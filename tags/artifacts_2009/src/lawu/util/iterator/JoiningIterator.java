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

import lawu.dp.Iterator;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class JoiningIterator<T> extends AbstractUniversalIterator<T> {
	private final Iterator<? extends Iterator<? extends T>> iterator;
	
	/**
	 * @param iterator
	 */
	public JoiningIterator(Iterator<? extends Iterator<? extends T>> iterator) {
		this.iterator = iterator;
		reset();
	}
	
	public void advance() {
		while(this.iterator.current().isDone() && !this.iterator.isDone()) {
			this.iterator.advance();
			this.iterator.current().reset();
		}
		this.iterator.current().advance();
	}

	public T current() {
		return this.iterator.current().current();
	}

	public boolean isDone() {
		return this.iterator.isDone();
	}

	public void reset() {
		this.iterator.reset();
		if(!this.iterator.isDone())
			this.iterator.current().reset();
	}
}
