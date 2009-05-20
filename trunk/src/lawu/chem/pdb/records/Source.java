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

public class Source {
// COLUMNS   DATA TYPE         FIELD          DEFINITION                        
// -------------------------------------------------------------------------------
//  1 -  6   Record name       "SOURCE"                                         
//  9 - 10   Continuation      continuation   Allows concatenation of multiple records.                         
// 11 - 70   Specification     srcName        Identifies the source of the macromolecule in 
//            list                            a token: value format.                        
	public Source() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Source) {
			Source r = (Source) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
