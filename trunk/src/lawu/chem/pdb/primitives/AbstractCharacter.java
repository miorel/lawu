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
public abstract class AbstractCharacter {
	private char character;
	
	public AbstractCharacter(char value) {
		setCharacter(value);
	}
	
	public AbstractCharacter(java.lang.String value) {
		if(value == null)
			throw new NullPointerException("");
		if(value.length() != 1)
			throw new RuntimeException("");
		setCharacter(value.charAt(0));
	}

	protected void setCharacter(char value) {
		if(!isValid(value))
			throw new RuntimeException("");
		this.character = value;
	}
	
	protected abstract boolean isValid(char character);
	
	public char getCharacter() {
		return this.character;
	}
	
	@Override
	public java.lang.String toString() {
		return java.lang.Character.toString(this.character);
	}

	@Override
	public int hashCode() {
		return getCharacter();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o != null && getClass() == o.getClass())
			ret = ((AbstractCharacter) o).character == this.character;
		return ret;
	}
}
