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

public class Cryst {
// COLUMNS      DATA TYPE            FIELD        DEFINITION
// ----------------------------------------------------------
//  1 -  6      Record name          "CRYST1"
//  7 - 15      Real(9.3)            a            a (Angstroms).
// 16 - 24      Real(9.3)            b            b (Angstroms).
// 25 - 33      Real(9.3)            c            c (Angstroms).
// 34 - 40      Real(7.2)            alpha        alpha (degrees).
// 41 - 47      Real(7.2)            beta         beta (degrees).
// 48 - 54      Real(7.2)            gamma        gamma (degrees).
// 56 - 66      LString              sGroup       Space group.
// 67 - 70      Integer              z            Z value.
	public Cryst() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Cryst) {
			Cryst r = (Cryst) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
