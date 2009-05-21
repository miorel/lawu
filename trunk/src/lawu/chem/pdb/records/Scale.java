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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lawu.chem.pdb.primitives.AChar;
import lawu.chem.pdb.primitives.Continuation;
import lawu.chem.pdb.primitives.IdCode;
import lawu.chem.pdb.primitives.Real;

/**
 * @author Miorel-Lucian Palii
 */
public class Scale {
//	private int n;
//	private Real(10.6) s[n][1];
//	private Real(10.6) s[n][2];
//	private Real(10.6) s[n][3];
//	private Real(10.5) u[n];

	private final static Pattern pattern = Pattern.compile("SCALE(\\d) {4}(.{10})(.{10})(.{10}) {5}(.{10}) {25}"); //$NON-NLS-1$
	private final static String format = "SCALE%d    %10s%10s%10s     %10s                         "; //$NON-NLS-1$

	public Scale(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		n = Integer.parseInt(m.group(1));
		s[n][1] = new Real(m.group(2), 10, 6);
		s[n][2] = new Real(m.group(3), 10, 6);
		s[n][3] = new Real(m.group(4), 10, 6);
		u[n] = new Real(m.group(5), 10, 5);
	}

	/**
	 * Sn1
	 */
//	public Real(10.6) s[n][1]() {
//		return s[n][1];
//	}

	/**
	 * Sn2
	 */
//	public Real(10.6) s[n][2]() {
//		return s[n][2];
//	}

	/**
	 * Sn3
	 */
//	public Real(10.6) s[n][3]() {
//		return s[n][3];
//	}

	/**
	 * Un
	 */
//	public Real(10.5) u[n]() {
//		return u[n];
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
