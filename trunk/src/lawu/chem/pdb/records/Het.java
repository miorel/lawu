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

public class Het {
// COLUMNS     DATA TYPE     FIELD         DEFINITION
// ------------------------------------------------------
//  1 -  6     Record name   "HET      "
//  8 - 10     LString(3)    hetID         Het identifier, right-justified.
// 13          Character     ChainID       Chain identifier.
// 14 - 17     Integer       seqNum        Sequence number.
// 18          AChar         iCode         Insertion code.
// 21 - 25     Integer       numHetAtoms   Number of HETATM records for the
//                                         group present in the entry.
// 31 - 70     String        text          Text describing Het group.
	public Het() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Het) {
			Het r = (Het) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
