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

public class Link {
// COLUMNS      DATA TYPE        FIELD        DEFINITION
// -----------------------------------------------------------------
//  1 - 6       Record name      "LINK   "
// 13 - 16      Atom             name1        Atom name.
// 17           Character        altLoc1      Alternate location indicator.
// 18 - 20      Residue name     resName1     Residue name.
// 22           Character        chainID1     Chain identifier.
// 23 - 26      Integer          resSeq1      Residue sequence number.
// 27           AChar            iCode1       Insertion code.
// 43 - 46      Atom             name2        Atom name.
// 47           Character        altLoc2      Alternate location indicator.
// 48 - 50      Residue name     resName2     Residue name.
// 52           Character        chainID2     Chain identifier.
// 53 - 56      Integer          resSeq2      Residue sequence number.
// 57           AChar            iCode2       Insertion code.
// 60 - 65      SymOP            sym1         Symmetry operator for 1st atom.
// 67 - 72      SymOP            sym2         Symmetry operator for 2nd atom.
	public Link() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Link) {
			Link r = (Link) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
