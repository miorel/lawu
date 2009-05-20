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

public class Modres {
// COLUMNS    DATA TYPE        FIELD         DEFINITION
// ----------------------------------------------------
//  1 - 6     Record name      "MODRES"
//  8 - 11    IDcode           idCode     ID code of this entry.
// 13 - 15    Residue name     resName    Residue name used in this entry.
// 17         Character        chainID    Chain identifier.
// 19 - 22    Integer          seqNum     Sequence number.
// 23         AChar            iCode      Insertion code.
// 25 - 27    Residue name     stdRes     Standard residue name.
// 30 - 70    String           comment    Description of the residue
//                                        modification
	public Modres() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Modres) {
			Modres r = (Modres) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
