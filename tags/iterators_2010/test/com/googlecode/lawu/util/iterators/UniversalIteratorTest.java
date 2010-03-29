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
import java.util.Enumeration;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.util.Factory;

@Ignore
public abstract class UniversalIteratorTest {
	public UniversalIteratorTest() {
	}
	
	protected <T> void testUniversalIterator(Factory<UniversalIterator<T>> factory, List<T> list) {
		UniversalIterator<T> iterator;
		
		iterator = factory.build();
		iterator.reset();
		Assert.assertEquals("Iterable implementation behaves unexpectedly.", list, readIterable(iterator));
		
		iterator = factory.build();
		iterator.reset();
		Assert.assertEquals("java.util.Iterator implementation behaves unexpectedly.", list, readJIterator(iterator));
		
		iterator = factory.build();
		iterator.reset();
		Assert.assertEquals("Enumeration implementation behaves unexpectedly.", list, readEnumeration(iterator));
		
		iterator = factory.build();
		iterator.reset();
		Assert.assertEquals("Gang of Four iterator implementation behaves unexpectedly.", list, readGOFIterator(iterator));
	}
	
	protected <T> void testUniversalIterator(final UniversalIterator<T> iterator, List<T> list) {
		testUniversalIterator(new Factory<UniversalIterator<T>>() {
			@Override
			public UniversalIterator<T> build() {
				return iterator;
			}
		}, list);
	}
	
	protected <T> List<T> readIterable(Iterable<T> iterable) {
		List<T> ret = new ArrayList<T>();
		for(T element: iterable)
			ret.add(element);
		return ret;
	}

	protected <T> List<T> readJIterator(java.util.Iterator<T> iterator) {
		List<T> ret = new ArrayList<T>();
		while(iterator.hasNext())
			ret.add(iterator.next());
		return ret;
	}
	
	protected <T> List<T> readEnumeration(Enumeration<T> enumeration) {
		List<T> ret = new ArrayList<T>();
		while(enumeration.hasMoreElements())
			ret.add(enumeration.nextElement());
		return ret;
	}
	
	protected <T> List<T> readGOFIterator(Iterator<T> iterator) {
		List<T> ret = new ArrayList<T>();
		for(iterator.reset(); !iterator.isDone(); iterator.advance())
			ret.add(iterator.current());
		return ret;
	}
}