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

public class Siguij {
// COLUMNS      DATA TYPE        FIELD         DEFINITION
// ------------------------------------------------------------
//  1 - 6       Record name      "SIGUIJ"
//  7 - 11      Integer          serial        Atom serial number.
// 13 - 16      Atom             name          Atom name.
// 17           Character        altLoc        Alternate location indicator.
// 18 - 20      Residue name     resName       Residue name.
// 22           Character        chainID       Chain identifier.
// 23 - 26      Integer          resSeq        Residue sequence number.
// 27           AChar            iCode         Insertion code.
// 29 - 35      Integer          sig[1][1]     Sigma U(1,1)
// 36 - 42      Integer          sig[2][2]     Sigma U(2,2)
// 43 - 49      Integer          sig[3][3]     Sigma U(3,3)
// 50 - 56      Integer          sig[1][2]     Sigma U(1,2)
// 57 - 63      Integer          sig[1][3]     Sigma U(1,3)
// 64 - 70      Integer          sig[2][3]     Sigma U(2,3)
// 77 - 78      LString(2)       element       Element symbol, right-justified.
// 79 - 80      LString(2)       charge        Charge on the atom.
	public Siguij() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Siguij) {
			Siguij r = (Siguij) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
