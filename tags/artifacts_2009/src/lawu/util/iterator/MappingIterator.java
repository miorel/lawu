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
import lawu.util.Mapper;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 * @param <U>
 */
public class MappingIterator<T, U> extends AbstractUniversalIterator<U> {
	private final Mapper<? super T, ? extends U> mapper;
	private final Iterator<? extends T> iterator;
	
	/**
	 * @param mapper
	 * @param iterator
	 */
	public MappingIterator(Mapper<? super T, ? extends U> mapper,
			Iterator<? extends T> iterator) {
		this.mapper = mapper;
		this.iterator = iterator;
		reset();
	}
	
	public void advance() {
		this.iterator.advance();
	}

	public U current() {
		return this.mapper.map(this.iterator.current());
	}

	public boolean isDone() {
		return this.iterator.isDone();
	}

	public void reset() {
		this.iterator.reset();
	}
}
