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
package com.googlecode.lawu.util;

/**
 * Groups two values in an immutable pair.
 * 
 * @author Miorel-Lucian Palii
 * @param <T> first type in pair
 * @param <U> second type in pair
 */
public class Pair<T, U> {
	private final T first;
	private final U second;
	
	/**
	 * Constructs a pair of the two specified values.
	 * 
	 * @param first the first value in the pair
	 * @param second the second value in the pair 
	 */
	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}
	
	/**
	 * Retrieves the first value in the pair.
	 * 
	 * @return the first value in the pair
	 */
	public T getFirst() {
		return this.first;
	}

	/**
	 * Retrieves the first value in the pair.
	 * 
	 * @return the first value in the pair
	 */
	public U getSecond() {
		return this.second;
	}
	
	/**
	 * Returns a string representation of the values in the pair.
	 * 
	 * @return a string representation of the pair
	 */
	@Override
	public String toString() {
		return String.format("[%s, %s]", getFirst(), getSecond());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(this == obj)
			ret = true;
		else if(obj instanceof Pair) {
			Pair<?, ?> pair = (Pair<?, ?>) obj;
			ret = (this.first == null ? pair.first == null : this.first.equals(pair.first))
				&& (this.second == null ? pair.second == null : this.second.equals(pair.second));
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int f = first == null ? 0 : first.hashCode();
		int s = second == null ? 0 : second.hashCode();
		return f * prime + s;
	}
}
