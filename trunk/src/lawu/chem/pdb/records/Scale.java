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

public class Scale {
// COLUMNS     DATA TYPE        FIELD        DEFINITION
// ----------------------------------------------------
//  1 -  6     Record name      "SCALEn"     n=1, 2, or 3
// 11 - 20     Real(10.6)       s[n][1]      Sn1
// 21 - 30     Real(10.6)       s[n][2]      Sn2
// 31 - 40     Real(10.6)       s[n][3]      Sn3
// 46 - 55     Real(10.5)       u[n]         Un
	public Scale() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Scale) {
			Scale r = (Scale) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
