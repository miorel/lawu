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

public class Seqres {
// COLUMNS      DATA TYPE       FIELD          DEFINITION
// -------------------------------------------------------------------
//  1 -  6      Record name     "SEQRES"
//  9 - 10      Integer         serNum         Serial number of the SEQRES record
//                                                 for the current chain. Starts at 1
//                                                 and increments by one each line.
//                                                 Reset to 1 for each chain.
// 12           Character       chainID        Chain identifier. This may be any
//                                                 single legal character, including a
//                                                 blank which is used if there is
//                                                 only one chain.
// 14 - 17      Integer         numRes         Number of residues in the chain.
//                                                 This value is repeated on every
//                                                 record.
// 20 - 22      Residue name    resName        Residue name.
// 24 - 26      Residue name    resName        Residue name.
// 28 - 30      Residue name    resName        Residue name.
// 32 - 34      Residue name    resName        Residue name.
// 36 - 38      Residue name    resName        Residue name.
// 40 - 42      Residue name    resName        Residue name.
// 44 - 46      Residue name    resName        Residue name.
// 48 - 50      Residue name    resName        Residue name.
// 52 - 54      Residue name    resName        Residue name.
// 56 - 58      Residue name    resName        Residue name.
// 60 - 62      Residue name    resName        Residue name.
// 64 - 66      Residue name    resName        Residue name.
// 68 - 70      Residue name    resName        Residue name.
	public Seqres() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Seqres) {
			Seqres r = (Seqres) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
