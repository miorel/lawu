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

public class Keywds {
// COLUMNS        DATA TYPE       FIELD          DEFINITION                         
// ---------------------------------------------------------------------------------
//  1 -  6        Record name     "KEYWDS"                                          
//  9 - 10        Continuation    continuation   Allows concatenation of records if necessary
// 11 - 70        List            keywds         Comma-separated list of keywords   
//                                               relevant to the entry.            
	public Keywds() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Keywds) {
			Keywds r = (Keywds) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
