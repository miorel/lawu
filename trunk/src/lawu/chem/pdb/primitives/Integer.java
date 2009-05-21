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
public class Integer {
	private int value;
	
	public Integer() {
		this(0);
	}
	
	public Integer(java.lang.String value) {
		setValue(value);
	}
	
	public Integer(int value) {
		setValue(value);
	}
	
	protected void setValue(java.lang.String value) {
		if(value == null)
			throw new NullPointerException("");
		if(!value.matches(" *-?\\d+")) //$NON-NLS-1$
			throw new RuntimeException("");
		setValue(java.lang.Integer.parseInt(value.trim()));
	}
	
	protected void setValue(int value) {
		this.value = value;
	}
	
	public int getInteger() {
		return this.value;
	}
	
	@Override
	public java.lang.String toString() {
		return java.lang.Integer.toString(this.value);
	}
	
	@Override
	public int hashCode() {
		return this.value;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Integer) {
			Integer i = (Integer) o;
			ret = i.value == this.value;
		}
		return ret;
	}
}
