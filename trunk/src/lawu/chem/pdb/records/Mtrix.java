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

public class Mtrix {
// COLUMNS       DATA TYPE          FIELD           DEFINITION
// --------------------------------------------------------------
//  1 - 6        Record name        "MTRIXn"        n=1, 2, or 3
//  8 - 10       Integer            serial          Serial number.
// 11 - 20       Real(10.6)         m[n][1]         Mn1
// 21 - 30       Real(10.6)         m[n][2]         Mn2
// 31 - 40       Real(10.6)         m[n][3]         Mn3
// 46 - 55       Real(10.5)         v[n]            Vn
// 60            Integer            iGiven         1 if coordinates for the
//                                                 representations which are
//                                                 approximately related by the
//                                                 transformations of the molecule are
//                                                 contained in the entry.  Otherwise,
//                                                 blank.
	public Mtrix() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Mtrix) {
			Mtrix r = (Mtrix) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
