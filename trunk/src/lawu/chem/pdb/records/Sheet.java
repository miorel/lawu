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

public class Sheet {
// COLUMNS     DATA TYPE        FIELD           DEFINITION
// --------------------------------------------------------------
//  1 -  6     Record name      "SHEET "
//  8 - 10     Integer          strand       Strand number which starts at 1 
//                                           for each strand within a sheet 
//                                           and increases by one.
// 12 - 14     LString(3)       sheetID      Sheet identifier.
// 15 - 16     Integer          numStrands   Number of strands in sheet.
// 18 - 20     Residue name     initResName  Residue name of initial residue.
// 22          Character        initChainID  Chain identifier of initial 
//                                           residue in strand.
// 23 - 26     Integer          initSeqNum   Sequence number of initial 
//                                           residue in strand.
// 27          AChar            initICode    Insertion code of initial residue
//                                           in strand.
// 29 - 31     Residue name     endResName   Residue name of terminal residue.
// 33          Character        endChainID   Chain identifier of terminal
//                                           residue.
// 34 - 37     Integer          endSeqNum    Sequence number of terminal
//                                           residue.
// 38          AChar            endICode     Insertion code of terminal 
//                                           residue.
// 39 - 40     Integer          sense        Sense of strand with respect to
//                                           previous strand in the sheet. 0
//                                           if first strand, 1 if parallel,
//                                           -1 if anti-parallel.
// 42 - 45     Atom             curAtom      Registration. Atom name in 
//                                           current strand.
// 46 - 48     Residue name     curResName   Registration. Residue name in
//                                           current strand.
// 50          Character        curChainId   Registration. Chain identifier in
//                                           current strand.
// 51 - 54     Integer          curResSeq    Registration. Residue sequence
//                                           number in current strand.
// 55          AChar            curICode     Registration. Insertion code in
//                                           current strand.
// 57 - 60     Atom             prevAtom     Registration. Atom name in
//                                           previous strand.
// 61 - 63     Residue name     prevResName  Registration. Residue name in
//                                           previous strand.
// 65          Character        prevChainId  Registration. Chain identifier in
//                                           previous strand.
// 66 - 69     Integer          prevResSeq   Registration. Residue sequence
//                                           number in previous strand.
// 70          AChar            prevICode    Registration. Insertion code in
//                                               previous strand.
	public Sheet() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Sheet) {
			Sheet r = (Sheet) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
