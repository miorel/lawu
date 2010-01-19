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
public class AChar extends AbstractCharacter {
	public AChar() {
		this('A');
	}
	
	public AChar(char value) {
		super(value);
	}
	
	public AChar(java.lang.String value) {
		super(value);
	}

	@Override
	protected boolean isValid(char character) {
		return ('a' <= character && character <= 'z')
			|| ('A' <= character && character <= 'Z');
	}
}
