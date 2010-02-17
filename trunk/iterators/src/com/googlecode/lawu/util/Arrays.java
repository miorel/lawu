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

public class Arrays {
	private Arrays() {
	}

	public static Long[] box(long[] array) {
		Long[] ret = new Long[array.length];
		for(int i = 0; i != array.length; ++i)
			ret[i] = Long.valueOf(array[i]);
		return ret;
	}
	
	public static Short[] box(short[] array) {
		Short[] ret = new Short[array.length];
		for(int i = 0; i != array.length; ++i)
			ret[i] = Short.valueOf(array[i]);
		return ret;
	}
	
	public static Integer[] box(int[] array) {
		Integer[] ret = new Integer[array.length];
		for(int i = 0; i != array.length; ++i)
			ret[i] = Integer.valueOf(array[i]);
		return ret;
	}

	public static Character[] box(char[] array) {
		Character[] ret = new Character[array.length];
		for(int i = 0; i != array.length; ++i)
			ret[i] = Character.valueOf(array[i]);
		return ret;
	}
	
	public static Byte[] box(byte[] array) {
		Byte[] ret = new Byte[array.length];
		for(int i = 0; i != array.length; ++i)
			ret[i] = Byte.valueOf(array[i]);
		return ret;
	}
	
	public static Float[] box(float[] array) {
		Float[] ret = new Float[array.length];
		for(int i = 0; i != array.length; ++i)
			ret[i] = Float.valueOf(array[i]);
		return ret;
	}
	
	public static Double[] box(double[] array) {
		Double[] ret = new Double[array.length];
		for(int i = 0; i != array.length; ++i)
			ret[i] = Double.valueOf(array[i]);
		return ret;
	}
}
