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

public class Dbref {
// COLUMNS       DATA TYPE          FIELD          DEFINITION
// ----------------------------------------------------------------
//  1 - 6        Record name        "DBREF "
//  8 - 11       IDcode             idCode         ID code of this entry.
// 13            Character          chainID        Chain identifier.
// 15 - 18       Integer            seqBegin       Initial sequence number 
//                                                 of the PDB sequence segment.
// 19            AChar              insertBegin    Initial insertion code 
//                                                 of the PDB sequence segment.
// 21 - 24       Integer            seqEnd         Ending sequence number 
//                                                 of the PDB sequence segment.
// 25            AChar              insertEnd      Ending insertion code 
//                                                 of the PDB sequence segment.
// 27 - 32       LString            database       Sequence database name. 
// 34 - 41       LString            dbAccession    Sequence database accession code.
// 43 - 54      LString            dbIdCode        Sequence database 
//                                                 identification code.
// 56 - 60      Integer            dbseqBegin      Initial sequence number of the
//                                                 database seqment.
// 61           AChar              idbnsBeg        Insertion code of initial residue
//                                                 of the segment, if PDB is the
//                                                 reference.
// 63 - 67      Integer            dbseqEnd        Ending sequence number of the
//                                                 database segment.
// 68           AChar              dbinsEnd        Insertion code of the ending
//                                                 residue of the segment, if PDB is
//                                                 the reference.
	public Dbref() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Dbref) {
			Dbref r = (Dbref) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
