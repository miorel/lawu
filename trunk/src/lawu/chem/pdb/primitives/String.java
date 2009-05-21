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
package lawu.chem.pdb.primitives;

/**
 * @author Miorel-Lucian Palii
 */
public class String {
	private java.lang.String string;
	
	public String() {
		this(""); //$NON-NLS-1$
	}
	
	public String(java.lang.String string) {
		setString(string);
	}
	
	protected void setString(java.lang.String string) {
		if(string == null)
			throw new NullPointerException("");
		this.string = string.trim().replaceAll(" {2,}", " "); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	public java.lang.String getString() {
		return this.string;
	}
	
	@Override
	public java.lang.String toString() {
		return getString();
	}
	
	@Override
	public int hashCode() {
		return getString().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof String)
			ret = this.string.equals(((String) o).string);
		return ret;
	}
}
