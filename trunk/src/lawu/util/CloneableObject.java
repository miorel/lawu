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

import lawu.Main;

/**
 * @author Miorel-Lucian Palii
 */
public class CloneableObject implements Cloneable {
	@Override
	protected CloneableObject clone() {
		CloneableObject ret = null;
		try {
			ret = (CloneableObject) super.clone();
		}
		catch(CloneNotSupportedException e) {
			throw new Error(Main.getString("CloneableObject.0"), e); //$NON-NLS-1$
		}
		return ret;
	}
}
