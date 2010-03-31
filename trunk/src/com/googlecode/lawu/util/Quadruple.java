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
 * Groups four values in an immutable quadruple.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            the first type in the quadruple
 * @param <U>
 *            the second type in the quadruple
 * @param <V>
 *            the third type in the quadruple
 * @param <W>
 *            the fourth type in the quadruple
 */
public final class Quadruple<T,U,V,W> {
	private final T first;
	private final U second;
	private final V third;
	private final W fourth;

	/**
	 * Constructs a quadruple of the four specified values.
	 * 
	 * @param first
	 *            the first value in the quadruple
	 * @param second
	 *            the second value in the quadruple
	 * @param third
	 *            the third value in the quadruple
	 * @param fourth
	 *            the fourth value in the quadruple
	 */
	public Quadruple(T first, U second, V third, W fourth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}
	
	/**
	 * Retrieves the first value in the quadruple.
	 * 
	 * @return the first value in the quadruple
	 */
	public T getFirst() {
		return first;
	}

	/**
	 * Retrieves the second value in the quadruple.
	 * 
	 * @return the second value in the quadruple
	 */
	public U getSecond() {
		return second;
	}

	/**
	 * Retrieves the third value in the quadruple.
	 * 
	 * @return the third value in the quadruple
	 */
	public V getThird() {
		return third;
	}
	
	/**
	 * Retrieves the fourth value in the quadruple.
	 * 
	 * @return the fourth value in the quadruple
	 */
	public W getFourth() {
		return fourth;
	}
	
	/**
	 * Returns a string representation of the values in the quadruple.
	 * 
	 * @return a string representation of the quadruple
	 */
	@Override
	public String toString() {
		return String.format("(%s, %s, %s, %s)", first, second, third, fourth);
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(this == obj)
			ret = true;
		else if(obj instanceof Quadruple<?,?,?,?>) {
			Quadruple<?,?,?,?> pair = (Quadruple<?,?,?,?>) obj;
			ret = (this.first == null ? pair.first == null : this.first.equals(pair.first))
				&& (this.second == null ? pair.second == null : this.second.equals(pair.second))
				&& (this.third == null ? pair.third == null : this.third.equals(pair.third))
				&& (this.fourth == null ? pair.fourth == null : this.fourth.equals(pair.third));
		}
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int f = first == null ? 0 : first.hashCode();
		int s = second == null ? 0 : second.hashCode();
		int t = third == null ? 0 : third.hashCode();
		int g = fourth == null ? 0 : fourth.hashCode();
		return ((f * prime + s) * prime + t) * prime + g;
	}
}
