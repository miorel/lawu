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

import java.util.Enumeration;

import lawu.dp.UnresettableIteratorException;

/**
 * @author Miorel-Lucian Palii
 */
public class JEnumerationAdapter<T> extends AbstractUniversalIterator<T> {
	private final Enumeration<T> enumeration;
	private T current;
	private boolean beginning;
	private boolean done;
	
	/**
	 * @param enumeration
	 */
	public JEnumerationAdapter(Enumeration<T> enumeration) {
		this.enumeration = enumeration;
		advance();
		this.beginning = true;
	}

	public void advance() {
		this.beginning = false;
		if(this.enumeration.hasMoreElements()) {
			this.current = this.enumeration.nextElement();
			this.done = false;
		}
		else {
			this.current = null;
			this.done = true;
		}
	}

	public T current() {
		return this.current;
	}

	public boolean isDone() {
		return this.done;
	}

	public void reset() throws UnresettableIteratorException{
		if(!this.beginning)
			throw new UnresettableIteratorException("");
	}
}
