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

public class Remark {
// COLUMNS        DATA TYPE       FIELD          DEFINITION                         
// -------------------------------------------------------------------------------
//  1 -  6        Record name     "REMARK"                                          
// 10             LString(1)      "1"                                               
// 13 - 16        LString(4)      "AUTH"         Appears on all continuation records
// 17 - 18        Continuation    continuation   Allows a long list of authors.     
// 20 - 70        List            authorList     List of the authors.               
// 
// COLUMNS        DATA TYPE       FIELD          DEFINITION                         
// -------------------------------------------------------------------------------
//  1 -  6        Record name     "REMARK"                                          
// 10             LString(1)      "1"                                               
// 13 - 16        LString(4)      "TITL"         Appears on all continuation records
// 17 - 18        Continuation    continuation   Permits long titles.               
// 20 - 70        LString         title          Title of the article. 
// 
// COLUMNS        DATA TYPE       FIELD          DEFINITION                         
// -------------------------------------------------------------------------------
//  1 -  6        Record name     "REMARK"                                          
// 10             LString(1)      "1"                                               
// 13 - 16        LString(4)      "TITL"         Appears on all continuation records
// 17 - 18        Continuation    continuation   Permits long titles.               
// 20 - 70        LString         title          Title of the article.
	public Remark() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Remark) {
			Remark r = (Remark) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
