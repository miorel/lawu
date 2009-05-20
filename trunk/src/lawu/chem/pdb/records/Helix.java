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

public class Helix {
// COLUMNS       DATA TYPE        FIELD        DEFINITION
// --------------------------------------------------------------------
//  1 -  6       Record name      "HELIX "
//  8 - 10       Integer          serNum       Serial number of the helix.
//                                             This starts at 1 and increases
//                                             incrementally.
// 12 - 14       LString(3)       helixID      Helix identifier. In addition
//                                             to a serial number, each helix is
//                                             given an alphanumeric character
//                                             helix identifier.
// 16 - 18       Residue name     initResName  Name of the initial residue.
// 20            Character        initChainID  Chain identifier for the chain
//                                             containing this helix.
// 22 - 25       Integer          initSeqNum   Sequence number of the initial
//                                             residue.
// 26            AChar            initICode    Insertion code of the initial
//                                             residue.
// 28 - 30       Residue name     endResName   Name of the terminal residue of
//                                             the helix.
// 32            Character        endChainID   Chain identifier for the chain
//                                             containing this helix.
// 34 - 37       Integer          endSeqNum    Sequence number of the terminal
//                                             residue.
// 38            AChar            endICode     Insertion code of the terminal
//                                             residue.
// 39 - 40       Integer          helixClass   Helix class (see below).
// 41 - 70       String           comment      Comment about this helix.
// 72 - 76       Integer          length       Length of this helix.
	public Helix() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Helix) {
			Helix r = (Helix) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
