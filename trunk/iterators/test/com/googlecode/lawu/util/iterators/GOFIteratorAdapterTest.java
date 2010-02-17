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
import java.util.NoSuchElementException;

import org.junit.Test;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.test.TestCases;

public class GOFIteratorAdapterTest extends UniversalIteratorTest {
	@Test(expected=NullPointerException.class)
	public void testConstructorWithNull() {
		new GOFIteratorAdapter<Object>(null);
	}
	
	@Test
	public void testInterfaces() {
		TestCases tc = new TestCases();
		for(final Integer[] integers: tc.getIntegerArrays())
			testUniversalIterator(new GOFIteratorAdapter<Integer>(new Iterator<Integer>() {
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
				public void reset() {
					pointer = 0;
				}
			}), Arrays.asList(integers));
	}
}