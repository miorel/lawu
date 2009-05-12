/*
 * lawu
 * Copyright (C) 2009 Miorel-Lucian Palii
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
package lawu.util.iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Miorel-Lucian Palii
 */
public class JEnumerationAdapter<T> extends AbstractUniversalIterator<T> {
	private final List<T> list;
	private final Enumeration<T> enumeration;
	private int pointer;
	
	/**
	 * @param enumeration
	 */
	public JEnumerationAdapter(Enumeration<T> enumeration) {
		this.list = new ArrayList<T>();
		this.enumeration = enumeration;
		reset();
	}

	public void advance() {
		++this.pointer;
		current();
	}

	public T current() {
		T ret = null;
		if(this.pointer < this.list.size())
			ret = this.list.get(this.pointer);
		else if(this.enumeration.hasMoreElements()) {
			ret = this.enumeration.nextElement();
			this.list.add(ret);
		}
		return ret;
	}

	public boolean isDone() {
		return this.pointer >= this.list.size()
			&& !this.enumeration.hasMoreElements();
	}

	public void reset() {
		this.pointer = 0;
	}
}
