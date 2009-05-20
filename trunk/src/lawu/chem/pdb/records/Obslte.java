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

public class Obslte {
// COLUMNS    DATA TYPE          FIELD               DEFINITION
// -----------------------------------------------------------------------------
//  1 -  6    Record name      "OBSLTE"
//  9 - 10    Continuation     continuation  Allows concatenation of multiple records
// 12 - 20    Date             repDate       Date that this entry was replaced.
// 22 - 25    IDcode           idCode        ID code of this entry.
// 32 - 35    IDcode           rIdCode       ID code of entry that replaced this one.
// 37 - 40    IDcode           rIdCode       ID code of entry that replaced this one.
// 42 - 45    IDcode           rIdCode       ID code of entry that replaced this one.
// 47 - 50    IDcode           rIdCode       ID code of entry that replaced this one.
// 52 - 55    IDcode           rIdCode       ID code of entry that replaced this one.
// 57 - 60    IDcode           rIdCode       ID code of entry that replaced this one.
// 62 - 65    IDcode           rIdCode       ID code of entry that replaced this one.
// 67 - 70    IDcode           rIdCode       ID code of entry that replaced this one.
	public Obslte() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Obslte) {
			Obslte r = (Obslte) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
