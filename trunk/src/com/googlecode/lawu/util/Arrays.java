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
 * Various methods for manipulating arrays.
 * 
 * @author Miorel-Lucian Palii
 * @see java.util.Arrays
 */
public class Arrays {
	/**
	 * There is no need to instantiate this class.
	 */
	private Arrays() {
	}

	/**
	 * Boxes a <code>double</code> array as a <code>Double</code> array.
	 * 
	 * @param array
	 *            the array to box
	 * @return a boxed copy of the array
	 */
	public static Double[] box(double[] array) {
		Double[] ret = new Double[array.length];
		for(int i = array.length; --i >= 0;)
			ret[i] = Double.valueOf(array[i]);
		return ret;
	}

	/**
	 * Boxes a <code>short</code> array as a <code>Short</code> array.
	 * 
	 * @param array
	 *            the array to box
	 * @return a boxed copy of the array
	 */
	public static Short[] box(short[] array) {
		Short[] ret = new Short[array.length];
		for(int i = array.length; --i >= 0;)
			ret[i] = Short.valueOf(array[i]);
		return ret;
	}

	/**
	 * Boxes a <code>float</code> array as a <code>Float</code> array.
	 * 
	 * @param array
	 *            the array to box
	 * @return a boxed copy of the array
	 */
	public static Float[] box(float[] array) {
		Float[] ret = new Float[array.length];
		for(int i = array.length; --i >= 0;)
			ret[i] = Float.valueOf(array[i]);
		return ret;
	}

	/**
	 * Boxes a <code>byte</code> array as a <code>Byte</code> array.
	 * 
	 * @param array
	 *            the array to box
	 * @return a boxed copy of the array
	 */
	public static Byte[] box(byte[] array) {
		Byte[] ret = new Byte[array.length];
		for(int i = array.length; --i >= 0;)
			ret[i] = Byte.valueOf(array[i]);
		return ret;
	}

	/**
	 * Boxes a <code>int</code> array as a <code>Integer</code> array.
	 * 
	 * @param array
	 *            the array to box
	 * @return a boxed copy of the array
	 */
	public static Integer[] box(int[] array) {
		Integer[] ret = new Integer[array.length];
		for(int i = array.length; --i >= 0;)
			ret[i] = Integer.valueOf(array[i]);
		return ret;
	}

	/**
	 * Boxes a <code>char</code> array as a <code>Character</code> array.
	 * 
	 * @param array
	 *            the array to box
	 * @return a boxed copy of the array
	 */
	public static Character[] box(char[] array) {
		Character[] ret = new Character[array.length];
		for(int i = array.length; --i >= 0;)
			ret[i] = Character.valueOf(array[i]);
		return ret;
	}

	/**
	 * Boxes a <code>long</code> array as a <code>Long</code> array.
	 * 
	 * @param array
	 *            the array to box
	 * @return a boxed copy of the array
	 */
	public static Long[] box(long[] array) {
		Long[] ret = new Long[array.length];
		for(int i = array.length; --i >= 0;)
			ret[i] = Long.valueOf(array[i]);
		return ret;
	}
}
