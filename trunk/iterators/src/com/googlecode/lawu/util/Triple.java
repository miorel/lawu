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
 * Groups three values in an immutable triple.
 * 
 * @author Miorel-Lucian Palii
 * @param <T> first type in triple
 * @param <U> second type in triple
 * @param <V> third type in triple
 */
public class Triple<T, U, V> {
	private final T first;
	private final U second;
	private final V third;
	
	/**
	 * Constructs a triple of the three specified values.
	 * 
	 * @param first the first value in the triple
	 * @param second the second value in the triple
	 * @param third the third value in the triple
	 */
	public Triple(T first, U second, V third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	/**
	 * Retrieves the first value in the triple.
	 * 
	 * @return the first value in the triple
	 */
	public T getFirst() {
		return first;
	}

	/**
	 * Retrieves the second value in the triple.
	 * 
	 * @return the second value in the triple
	 */
	public U getSecond() {
		return second;
	}
	
	/**
	 * Retrieves the third value in the triple.
	 * 
	 * @return the third value in the triple
	 */
	public V getThird() {
		return third;
	}
	
	/**
	 * Returns a string representation of the values in the triple.
	 * 
	 * @return a string representation of the triple
	 */
	@Override
	public String toString() {
		return String.format("[%s, %s, %s]", getFirst(), getSecond(), getThird());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(this == obj)
			ret = true;
		else if(obj instanceof Triple<?, ?, ?>) {
			Triple<?, ?, ?> triple = (Triple<?, ?, ?>) obj;
			ret = (this.first == null ? triple.first == null : this.first.equals(triple.first))
				&& (this.second == null ? triple.second == null : this.second.equals(triple.second))
				&& (this.third == null ? triple.third == null : this.third.equals(triple.third));
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
		int t = third == null ? 0 : third.hashCode();
		return (f * prime + s) * prime + t;
	}
}
