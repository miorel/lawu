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
public class Character extends AbstractCharacter {
	public Character() {
		this(' ');
	}
	
	public Character(char value) {
		super(value);
	}
	
	public Character(java.lang.String value) {
		super(value);
	}

	@Override
	protected boolean isValid(char character) {
		return 32 <= character && character <= 126;
	}
}
