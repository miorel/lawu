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
public class Continuation {
	private int number;
	
	public Continuation() {
		this(0);
	}
	
	public Continuation(int number) {
		setNumber(number);
	}
	
	public Continuation(java.lang.String number) {
		setNumber(number);
	}
	
	protected void setNumber(java.lang.String number) {
		if(number == null)
			throw new NullPointerException("");
		if(number.matches(" *")) //$NON-NLS-1$
			setNumber(0);
		else if(number.matches(" *\\d+")) //$NON-NLS-1$
			setNumber(java.lang.Integer.parseInt(number.trim()));
		else
			throw new RuntimeException("");
	}
	
	protected void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public java.lang.String toString() {
		return java.lang.String.format("%2d", //$NON-NLS-1$
				java.lang.Integer.valueOf(this.number));
	}
	
	@Override
	public int hashCode() {
		return this.number;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Continuation)
			return this.number == ((Continuation) o).number;
		return ret;
	}
}
