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

public class Site {
// COLUMNS       DATA TYPE         FIELD            DEFINITION
// ------------------------------------------------------------------------
//  1 -  6       Record name       "SITE    "
//  8 - 10       Integer           seqNum      Sequence number.
// 12 - 14       LString(3)        siteID      Site name.
// 16 - 17       Integer           numRes      Number of residues comprising 
//                                             site.
// 19 - 21       Residue name      resName1    Residue name for first residue
//                                             comprising site.
// 23            Character         chainID1    Chain identifier for first residue
//                                             comprising site.
// 24 - 27       Integer           seq1        Residue sequence number for first
//                                             residue comprising site.
// 28            AChar             iCode1      Insertion code for first residue
//                                             comprising site.
// 30 - 32       Residue name      resName2    Residue name for second residue
//                                             comprising site.
// 34            Character         chainID2    Chain identifier for second 
//                                             residue
//                                             comprising site.
// 35 - 38       Integer           seq2        Residue sequence number for second
//                                             residue comprising site.
// 39            AChar             iCode2      Insertion code for second residue
//                                             comprising site.
// 41 - 43       Residue name      resName3    Residue name for third residue
//                                             comprising site.
// 45            Character         chainID3    Chain identifier for third residue
//                                             comprising site.
// 46 - 49       Integer           seq3        Residue sequence number for third
//                                             residue comprising site.
// 50            AChar             iCode3      Insertion code for third residue
//                                             comprising site.
// 52 - 54       Residue name      resName4    Residue name for fourth residue
//                                             comprising site.
// 56            Character         chainID4    Chain identifier for fourth 
//                                             residue
//                                             comprising site.
// 57 - 60       Integer           seq4        Residue sequence number for fourth
//                                             residue comprising site.
// 61            AChar             iCode4      Insertion code for fourth residue
//                                             comprising site.
	public Site() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Site) {
			Site r = (Site) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
