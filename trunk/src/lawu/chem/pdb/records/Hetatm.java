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

public class Hetatm {
// COLUMNS     DATA TYPE        FIELD         DEFINITION
// --------------------------------------------------------------
//  1 - 6      Record name      "HETATM"
//  7 - 11     Integer          serial        Atom serial number.
// 13 - 16     Atom             name          Atom name.
// 17          Character        altLoc        Alternate location indicator.
// 18 - 20     Residue name     resName       Residue name.
// 22          Character        chainID       Chain identifier.
// 23 - 26     Integer          resSeq        Residue sequence number.
// 27          AChar            iCode         Code for insertion of residues.
// 31 - 38     Real(8.3)        x             Orthogonal coordinates for X.
// 39 - 46     Real(8.3)        y             Orthogonal coordinates for Y.
// 47 - 54     Real(8.3)        z             Orthogonal coordinates for Z.
// 55 - 60     Real(6.2)        occupancy     Occupancy.
// 61 - 66     Real(6.2)        tempFactor    Temperature factor.
// 77 - 78     LString(2)       element       Element symbol; right-justified.
// 79 - 80     LString(2)       charge        Charge on the atom.
	public Hetatm() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Hetatm) {
			Hetatm r = (Hetatm) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
