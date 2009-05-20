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

public class Jrnl {
// COLUMNS    DATA TYPE      FIELD     DEFINITION                                   
// -----------------------------------------------
//  1 -  6    Record name    "JRNL  "                                               
// 13 - 70    LString        text      See Details below.                            
// 
// COLUMNS         DATA TYPE            FIELD                   DEFINITION
// -------------------------------------------------------------------------
//  1 -  6         Record name          "JRNL "
// 13 - 16         LString(3)           "REF"
// 20 - 34         LString(15)          "TO BE PUBLISHED"
// 
// COLUMNS        DATA TYPE           FIELD              DEFINITION
// --------------------------------------------------------------------------------
//  1 -  6        Record name         "JRNL "
// 13 - 16        LString(3)          "REF"
// 17 - 18        Continuation continuation       Allows long publication names.
// 20 - 47        LString             pubName     Name of the publication including
//                                                section or series designation. This is
//                                                the only field of this sub-record which
//                                                may be continued on successive
//                                                sub-records.
// 50 - 51        LString(2)          "V."        Appears in the first sub-record only,
//                                                and only if column 55 is non-blank.
// 52 - 55        String              volume      Right-justified blank-filled volume
//                                                information; appears in the first
//                                                sub-record only.
// 57 - 61        String              page        First page of the article; appears in the
//                                                first sub-record only.
// 63 - 66        Integer             year        Year of publication; first sub-record
//                                                only.
// 
// COLUMNS         DATA TYPE           FIELD                DEFINITION
// -------------------------------------------------------------------------------
//  1 -  6         Record name         "JRNL "
// 13 - 16         LString(4)          "PUBL"
// 17 - 18         Continuation    continuation    Allows long publisher and place names.
// 20 - 70         LString             pub        City of publication and name of the
//                                                publisher/institution.
// 
// COLUMNS        DATA TYPE           FIELD               DEFINITION
// -----------------------------------------------------------------
//  1 -  6        Record name         "JRNL "
// 13 - 16        LString(4)          "REFN"
// 20 - 23        LString(4)          "ASTM"
// 25 - 30        LString(6)          astm          ASTM devised coden.
// 33 - 34        LString(2)          country       Country of publication code as defined
//                                                  in the OCLC/MARC cataloging format
//                                                  (optional).
// 36 - 39        LString(4)          "ISBN"        International Standard Book Number or
//                                    "ISSN" or     International Standard Serial Number.
//                                    "ESSN"
// 41 - 65        LString             isbn          ISSN or ISBN number (final digit may 
//                                                  be a letter and may contain one or 
//                                                  more dashes).
	public Jrnl() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Jrnl) {
			Jrnl r = (Jrnl) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
