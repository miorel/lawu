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
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import com.googlecode.lawu.test.StandardTestCases;

public class AbstractUniversalIteratorTest {
	@Test
	public void testNormalOperation() {
		for(Integer[] integers: StandardTestCases.INTEGER_ARRAYS)
			test(integers);
	}
	
	protected void test(final Integer... integers) {
		AbstractUniversalIterator<Integer> iterator = new AbstractUniversalIterator<Integer>() {
			private int pointer = 0;
			
			@Override
			public void advance() {
				++pointer;
			}

			@Override
			public Integer current() {
				if(isDone())
					throw new NoSuchElementException();
				return integers[pointer];
			}

			@Override
			public boolean isDone() {
				return pointer >= integers.length;
			}

			@Override
			public void reset() throws IllegalStateException {
				pointer = 0;
			}
		};
		
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		
		for(Integer integer: integers)
			a.add(integer);		
		for(Integer integer: iterator)
			b.add(integer);
		Assert.assertEquals("Iterable implementation is flawed.", a, b);
		
		iterator.reset();
		b.clear();
		while(iterator.hasNext())
			b.add(iterator.next());
		Assert.assertEquals("java.util.Iterator implementation is flawed.", a, b);

		iterator.reset();
		b.clear();
		while(iterator.hasMoreElements())
			b.add(iterator.next());
		Assert.assertEquals("Enumeration implementation is flawed.", a, b);
		
		iterator.reset();
		b.clear();
		for(iterator.reset(); !iterator.isDone(); iterator.advance())
			b.add(iterator.current());
		Assert.assertEquals("Gang of Four iterator implementation is flawed.", a, b);
	}
}