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
package lawu.util;

/**
 * @author Miorel-Lucian Palii
 * @param <T> the type which this filter filters
 */
public interface Filter<T> {
	public static final Filter<Object> NON_NULL = new Filter<Object>() {
		public boolean keep(Object element) {
			return element != null;
		}
	};
	
	/**
	 * @param element the element to check
	 * @return whether or not to keep the element
	 */
	public boolean keep(T element);
}
