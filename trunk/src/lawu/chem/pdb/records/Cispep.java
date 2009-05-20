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

public class Cispep {
// COLUMNS       DATA TYPE        FIELD         DEFINITION
// -------------------------------------------------------------
//  1 -  6       Record name      "CISPEP"
//  8 - 10       Integer          serNum        Record serial number.
// 12 - 14       LString(3)       pep1          Residue name.
// 16            Character        chainID1      Chain identifier.
// 18 - 21       Integer          seqNum1       Residue sequence number.
// 22            AChar            icode1        Insertion code.
// 26 - 28       LString(3)       pep2          Residue name.
// 30            Character        chainID2      Chain identifier.
// 32 - 35       Integer          seqNum2       Residue sequence number.
// 36            AChar            icode2        Insertion code.
// 44 - 46       Integer          modNum        Identifies the specific model.
// 54 - 59       Real(6.2)        measure       Measure of the angle in degrees.
	public Cispep() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Cispep) {
			Cispep r = (Cispep) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
