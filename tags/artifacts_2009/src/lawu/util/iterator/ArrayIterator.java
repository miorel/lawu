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

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class ArrayIterator<T> extends AbstractUniversalIterator<T> {
	private final T[] array;
	private int pointer;
	
	/**
	 * @param array
	 */
	public ArrayIterator(T... array) {
		this.array = array;
		reset();
	}
	
	public void advance() {
		++this.pointer;
	}

	public T current() {
		return this.array[this.pointer];
	}

	public boolean isDone() {
		return this.pointer >= this.array.length;
	}

	public void reset() {
		this.pointer = 0;
	}
}
