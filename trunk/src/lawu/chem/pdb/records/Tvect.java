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

public class Tvect {
// COLUMNS     DATA TYPE       FIELD       DEFINITION
// ---------------------------------------------------
//  1 -  6     Record name     "TVECT "
//  8 - 10     Integer         serial      Serial number.
// 11 - 20     Real(10.5)      t[1]        Components of translation vector.
// 21 - 30     Real(10.5)      t[2]        Components of translation vector.
// 31 - 40     Real(10.5)      t[3]        Components of translation vector.
// 41 - 70     String          text        Comment.
	public Tvect() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Tvect) {
			Tvect r = (Tvect) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
