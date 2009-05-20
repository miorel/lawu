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
package lawu.chem.pdb.records;

public class Conect {
// COLUMNS       DATA TYPE       FIELD         DEFINITION
// -------------------------------------------------------
//  1 -  6       Record name     "CONECT"
//  7 - 11       Integer         serial        Atom serial number
// 12 - 16       Integer         serial        Serial number of bonded atom
// 17 - 21       Integer         serial        Serial number of bonded atom
// 22 - 26       Integer         serial        Serial number of bonded atom
// 27 - 31       Integer         serial        Serial number of bonded atom
	public Conect() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Conect) {
			Conect r = (Conect) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
