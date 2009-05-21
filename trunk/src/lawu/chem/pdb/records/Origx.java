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
public class Origx {
//	private int n;
//	private Real(10.6) o[n][1];
//	private Real(10.6) o[n][2];
//	private Real(10.6) o[n][3];
//	private Real(10.5) t[n];

	private final static Pattern pattern = Pattern.compile("ORIGX(\\d) {4}(.{10})(.{10})(.{10}) {5}(.{10}) {25}"); //$NON-NLS-1$
	private final static String format = "ORIGX%d    %10s%10s%10s     %10s                         "; //$NON-NLS-1$

	public Origx(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		n = Integer.parseInt(m.group(1));
		o[n][1] = new Real(m.group(2), 10, 6);
		o[n][2] = new Real(m.group(3), 10, 6);
		o[n][3] = new Real(m.group(4), 10, 6);
		t[n] = new Real(m.group(5), 10, 5);
	}

	/**
	 * On1
	 */
//	public Real(10.6) o[n][1]() {
//		return o[n][1];
//	}

	/**
	 * On2
	 */
//	public Real(10.6) o[n][2]() {
//		return o[n][2];
//	}

	/**
	 * On3
	 */
//	public Real(10.6) o[n][3]() {
//		return o[n][3];
//	}

	/**
	 * Tn
	 */
//	public Real(10.5) t[n]() {
//		return t[n];
//	}

	@Override	
	public String toString() {
		return String.format(format);
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
