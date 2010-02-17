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
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.googlecode.lawu.test.TestCases;
import com.googlecode.lawu.util.Factory;

public class JIteratorAdapterTest extends UniversalIteratorTest {
	@Test(expected=NullPointerException.class)
	public void testConstructorWithNull() {
		new JIteratorAdapter<Object>((Iterator<Object>) null);
	}
	
	@Test
	public void testInterfaces() {
		TestCases tc = new TestCases();
		for(Integer[] integers: tc.getIntegerArrays()) {
			final List<Integer> list = Arrays.asList(integers);
			testUniversalIterator(new Factory<UniversalIterator<Integer>>() {
				@Override
				public UniversalIterator<Integer> build() {
					return new JIteratorAdapter<Integer>(list.iterator());
				}
			}, list); 
		}
	}
}