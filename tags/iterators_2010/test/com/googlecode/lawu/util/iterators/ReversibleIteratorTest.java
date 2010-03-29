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

import org.junit.Ignore;

@Ignore
public class ReversibleIteratorTest extends UniversalIteratorTest {
	public ReversibleIteratorTest() {
	}
	
	protected <T> void testReversibleIterator(ReversibleIterator<T> iterator, List<T> list) {
		testUniversalIterator(iterator, list);
		
		List<T> reverseList = new ArrayList<T>();
		for(T element: list)
			reverseList.add(0, element);
		testUniversalIterator(iterator.reverse(), reverseList);
		
		testUniversalIterator(iterator.reverse().reverse(), list);
	}
}
