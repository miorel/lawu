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

public class Sprsde {
// COLUMNS       DATA TYPE      FIELD         DEFINITION                             
// ----------------------------------------------------------------------------------
//  1 -  6       Record name    "SPRSDE"                                             
//  9 - 10       Continuation   continuation  Allows for multiple ID codes.          
// 12 - 20       Date           sprsdeDate    Date this entry superseded the         
//                                            listed entries. This field is not      
//                                            copied on continuations.               
// 22 - 25       IDcode         idCode        ID code of this entry.  This field     
//                                            is not copied on continuations.        
// 32 - 35       IDcode         sIdCode       ID code of a superseded entry.         
// 37 - 40       IDcode         sIdCode       ID code of a superseded entry.         
// 42 - 45       IDcode         sIdCode       ID code of a superseded entry.         
// 47 - 50       IDcode         sIdCode       ID code of a superseded entry.         
// 52 - 55       IDcode         sIdCode       ID code of a superseded entry.         
// 57 - 60       IDcode         sIdCode       ID code of a superseded entry.         
// 62 - 65       IDcode         sIdCode       ID code of a superseded entry.         
// 67 - 70       IDcode         sIdCode       ID code of a superseded entry.         
	public Sprsde() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Sprsde) {
			Sprsde r = (Sprsde) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
