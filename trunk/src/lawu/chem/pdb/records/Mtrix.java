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
public class Mtrix {
//	private int n;
//	private lawu.chem.pdb.primitives.Integer serial;
//	private Real(10.6) m[n][1];
//	private Real(10.6) m[n][2];
//	private Real(10.6) m[n][3];
//	private Real(10.5) v[n];
//	private lawu.chem.pdb.primitives.Integer iGiven         1;

	private final static Pattern pattern = Pattern.compile("MTRIX(\\d) (...)(.{10})(.{10})(.{10}) {5}(.{10}) {4}(.) {20}"); //$NON-NLS-1$
	private final static String format = "MTRIX%d %3s%10s%10s%10s     %10s    %1s                    "; //$NON-NLS-1$

	public Mtrix(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		n = Integer.parseInt(m.group(1));
		serial = new lawu.chem.pdb.primitives.Integer(m.group(2));
		m[n][1] = new Real(m.group(3), 10, 6);
		m[n][2] = new Real(m.group(4), 10, 6);
		m[n][3] = new Real(m.group(5), 10, 6);
		v[n] = new Real(m.group(6), 10, 5);
		iGiven         1 = new lawu.chem.pdb.primitives.Integer(m.group(7));
	}

	/**
	 * Serial number.
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 * Mn1
	 */
//	public Real(10.6) m[n][1]() {
//		return m[n][1];
//	}

	/**
	 * Mn2
	 */
//	public Real(10.6) m[n][2]() {
//		return m[n][2];
//	}

	/**
	 * Mn3
	 */
//	public Real(10.6) m[n][3]() {
//		return m[n][3];
//	}

	/**
	 * Vn
	 */
//	public Real(10.5) v[n]() {
//		return v[n];
//	}

	/**
	 *  if coordinates for the epresentations which are pproximately related by the ransformations of the molecule are ontained in the entry. Otherwise, lank.
	 */
//	public lawu.chem.pdb.primitives.Integer iGiven         1() {
//		return iGiven         1;
//	}

	@Override	
	public String toString() {
		return String.format(format);
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
