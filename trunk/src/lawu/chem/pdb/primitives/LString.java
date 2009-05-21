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
public class LString {
	private java.lang.String string;
	private int width = UNINITIALIZED;
	
	private static final int UNINITIALIZED = -1;
	
	public LString(java.lang.String string) {
		setString(string);
	}
	
	public LString(java.lang.String string, int width) {
		this.width = width;
		setString(string);
	}
	
	protected void setString(java.lang.String string) {
		if(string == null)
			throw new NullPointerException("");
		if(this.width == UNINITIALIZED)
			this.width = string.length();
		else if(this.width != string.length())
			throw new RuntimeException("");
		this.string = string;
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
		if(o instanceof LString)
			ret = this.string.equals(((LString) o).string);
		return ret;
	}
}
