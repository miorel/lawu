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

public class Master {
// COLUMNS    DATA TYPE      FIELD         DEFINITION
// -------------------------------------------------------------------
//  1 -  6    Record name    "MASTER"
// 11 - 15    Integer        numRemark     Number of REMARK records
// 16 - 20    Integer        "0"
// 21 - 25    Integer        numHet        Number of HET records
// 26 - 30    Integer        numHelix      Number of HELIX records
// 31 - 35    Integer        numSheet      Number of SHEET records
// 36 - 40    Integer        numTurn       Number of TURN records
// 41 - 45    Integer        numSite       Number of SITE records
// 46 - 50    Integer        numXform      Number of coordinate 
//                                         transformation
//                                         records (ORIGX+SCALE+MTRIX)
// 51 - 55    Integer        numCoord      Number of atomic coordinate 
//                                         records (ATOM+HETATM)
// 56 - 60    Integer        numTer        Number of TER records
// 61 - 65    Integer        numConect     Number of CONECT records
// 66 - 70    Integer        numSeq        Number of SEQRES records
	public Master() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Master) {
			Master r = (Master) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
