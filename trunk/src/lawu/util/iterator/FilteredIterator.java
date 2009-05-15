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

import lawu.dp.Iterator;
import lawu.util.Filter;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class FilteredIterator<T> extends AbstractUniversalIterator<T> {
	private final Filter<? super T> filter;
	private final Iterator<? extends T> iterator;
	private boolean beginning;
	
	/**
	 * @param filter
	 * @param iterator
	 */
	public FilteredIterator(Filter<? super T> filter, Iterator<? extends T> iterator) {
		this.filter = filter;
		this.iterator = iterator;
		this.beginning = false;
		reset();
	}
	
	public void advance() {
		this.beginning = false;
		do this.iterator.advance();
		while(!this.iterator.isDone() && !this.filter.keep(this.iterator.current()));
	}

	public T current() {
		return this.iterator.current();
	}

	public boolean isDone() {
		return this.iterator.isDone();
	}

	public void reset() {
		if(!this.beginning) { 
			this.iterator.reset();
			if(!this.filter.keep(this.iterator.current()))
				advance();
			this.beginning = true;
		}
	}
}
