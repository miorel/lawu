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

public class Revdat {
// COLUMNS    DATA TYPE      FIELD         DEFINITION                             
// --------------------------------------------------------
//  1 -  6    Record name    "REVDAT"                                             
//  8 - 10    Integer        modNum        Modification number.                   
// 11 - 12    Continuation   continuation  Allows concatenation of multiple records
// 14 - 22    Date           modDate       Date of modification (or release for   
//                                         new entries).  This is not repeated    
//                                         on continuation lines.                 
// 24 - 28    String(5)      modId         Identifies this particular             
//                                         modification.  It links to the         
//                                         archive used internally by PDB.        
//                                         This is not repeated on continuation lines
// 32         Integer        modType       An integer identifying the type of     
//                                         modification.  In case of revisions    
//                                         with more than one possible modType,   
//                                         the highest value applicable will be assigned
// 40 - 45    LString(6)     record        Name of the modified record.           
// 47 - 52    LString(6)     record        Name of the modified record.           
// 54 - 59    LString(6)     record        Name of the modified record.           
// 61 - 66    LString(6)     record        Name of the modified record.
	public Revdat() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Revdat) {
			Revdat r = (Revdat) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
