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

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.googlecode.lawu.test.StandardTestCases;

public class ArrayIteratorTest {
	@Test
	public void testNormalOperation() {
		for(Integer[] integers: StandardTestCases.INTEGER_ARRAYS)
			test(integers);
	}
	
	@Test
	public void testException() {
		boolean exception = false;
		try {
			new ArrayIterator<Integer>((Integer[]) null);
		}
		catch(Exception e) {
			exception = true;
		}
		if(!exception)
			Assert.fail("Null argument wasn't captured at construct time.");
	}
	
	protected void test(Integer... integers) {		
		ArrayIterator<Integer> iterator = new ArrayIterator<Integer>(integers);
		Assert.assertNotNull(iterator);
		
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		
		for(Integer integer: integers)
			a.add(integer);
		for(Integer integer: iterator)
			b.add(integer);
		Assert.assertEquals("For-each iteration fails.", a, b);
		
		b.clear();
		iterator.reset();
		for(Integer integer: iterator)
			b.add(integer);
		Assert.assertEquals("The iterator does not reset properly.", a, b);
		
		b.clear();
		for(Integer integer: iterator.reverse())
			b.add(0, integer);
		Assert.assertEquals("Reversing doesn't work properly.", a, b);

		b.clear();
		for(Integer integer: iterator.reverse().reverse())
			b.add(integer);
		Assert.assertEquals("The reverse of the reverse is not the original iterator.", a, b);
	}
}