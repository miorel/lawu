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

public class Header {
// COLUMNS      DATA TYPE      FIELD             DEFINITION
// ---------------------------------------------------------------------------
//  1 -  6      Record name    "HEADER"
// 11 - 50      String(40)     classification    Classifies the molecule(s)
// 51 - 59      Date           depDate           Deposition date. 
//                                               This is the date the coordinates were 
//                                               received by the PDB
// 63 - 66      IDcode         idCode            This identifier is unique within the PDB
	public Header() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Header) {
			Header r = (Header) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
