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
package com.googlecode.lawu.util.iterators;

import java.util.Arrays;

import org.junit.Test;

import com.googlecode.lawu.test.TestCases;

public class ArrayIteratorTest extends ReversibleIteratorTest {	
	@Test(expected=NullPointerException.class)
	public void testConstructorWithNull() {
		new ArrayIterator<Object>((Object[]) null);
	}
	
	@Test
	public void testInterfaces() {
		TestCases tc = new TestCases();
		for(Integer[] integers: tc.getIntegerArrays())
			testReversibleIterator(new ArrayIterator<Integer>(integers), Arrays.asList(integers)); 
	}
}