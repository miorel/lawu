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

public class Seqadv {
// COLUMNS       DATA TYPE       FIELD      DEFINITION
// -----------------------------------------------------------------
//  1 -  6       Record name     "SEQADV"
//  8 - 11       IDcode          idCode    ID code of this entry.
// 13 - 15       Residue name    resName   Name of the PDB residue in conflict.
// 17            Character       chainID   PDB chain identifier.
// 19 - 22       Integer         seqNum    PDB sequence number.
// 23            AChar           iCode     PDB insertion code.
// 25 - 28       LString         database  
// 30 - 38       LString         dbIdCode  Sequence database accession number.
// 40 - 42       Residue name    dbRes     Sequence database residue name.
// 44 - 48       Integer         dbSeq     Sequence database sequence number.
// 50 - 70       LString         conflict  Conflict comment.
	public Seqadv() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Seqadv) {
			Seqadv r = (Seqadv) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
