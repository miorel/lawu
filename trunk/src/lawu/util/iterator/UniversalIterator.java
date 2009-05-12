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

import lawu.dp.Iterator;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public interface UniversalIterator<T> extends Iterator<T>,
		java.util.Iterator<T>, Iterable<T>, Enumeration<T> {
	public UniversalIterator<T> iterator();
}
