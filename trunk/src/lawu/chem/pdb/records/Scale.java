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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lawu.chem.pdb.primitives.AChar;
import lawu.chem.pdb.primitives.AtomName;
import lawu.chem.pdb.primitives.Continuation;
import lawu.chem.pdb.primitives.Date;
import lawu.chem.pdb.primitives.IdCode;
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;
import lawu.chem.pdb.primitives.ResidueName;
import lawu.chem.pdb.primitives.SymOp;

/**
 * @author Miorel-Lucian Palii
 */
public class Scale {
	private int n;
	private Real sn1;
	private Real sn2;
	private Real sn3;
	private Real un;

	private final static Pattern pattern = Pattern.compile("SCALE(\\d) {4}(.{10})(.{10})(.{10}) {5}(.{10}) {25}"); //$NON-NLS-1$
	private final static String format = "SCALE%d    %10s%10s%10s     %10s                         "; //$NON-NLS-1$

	public Scale(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		n = Integer.parseInt(m.group(1));
		sn1 = new Real(m.group(2), 10, 6);
		sn2 = new Real(m.group(3), 10, 6);
		sn3 = new Real(m.group(4), 10, 6);
		un = new Real(m.group(5), 10, 5);
	}

	/**
	 *  Sn1
	 */
//	public Real(10.6) sn1() {
//		return sn1;
//	}

	/**
	 *  Sn2
	 */
//	public Real(10.6) sn2() {
//		return sn2;
//	}

	/**
	 *  Sn3
	 */
//	public Real(10.6) sn3() {
//		return sn3;
//	}

	/**
	 *  Un
	 */
//	public Real(10.5) un() {
//		return un;
//	}

	@Override	
	public String toString() {
		return String.format(format);
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
