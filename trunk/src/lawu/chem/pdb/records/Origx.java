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

public class Origx {
// COLUMNS    DATA TYPE        FIELD       DEFINITION
// ---------------------------------------------------
//  1 -  6    Record name      "ORIGXn"    n=1, 2, or 3
// 11 - 20    Real(10.6)       o[n][1]     On1
// 21 - 30    Real(10.6)       o[n][2]     On2
// 31 - 40    Real(10.6)       o[n][3]     On3
// 46 - 55    Real(10.5)       t[n]        Tn
	public Origx() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Origx) {
			Origx r = (Origx) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
