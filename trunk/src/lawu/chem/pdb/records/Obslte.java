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
public class Obslte {
//	private Continuation     co ntinuation  Allows c;
//	private Date             re pDate       Date tha;
//	private IDcode           id Code        ID code;
//	private IDcode           rI dCode       ID code;
//	private IDcode           rI dCode       ID code;
//	private IDcode           rI dCode       ID code;
//	private IDcode           rI dCode       ID code;
//	private IDcode           rI dCode       ID code;
//	private IDcode           rI dCode       ID code;
//	private IDcode           rI dCode       ID code;
//	private IDcode           rI dCode       ID code;

	private final static Pattern pattern = Pattern.compile("OBSLTE  (..) (.{9}) (.{4}) {6}(.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) {10}"); //$NON-NLS-1$
	private final static String format = "OBSLTE  %2s %9s %4s      %4s %4s %4s %4s %4s %4s %4s %4s          "; //$NON-NLS-1$

	public Obslte(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		// ntinuation  Allows c = new Continuation     co(m.group(1));
		// pDate       Date tha = new Date             re(m.group(2));
		// Code        ID code = new IDcode           id(m.group(3));
		// dCode       ID code = new IDcode           rI(m.group(4));
		// dCode       ID code = new IDcode           rI(m.group(5));
		// dCode       ID code = new IDcode           rI(m.group(6));
		// dCode       ID code = new IDcode           rI(m.group(7));
		// dCode       ID code = new IDcode           rI(m.group(8));
		// dCode       ID code = new IDcode           rI(m.group(9));
		// dCode       ID code = new IDcode           rI(m.group(10));
		// dCode       ID code = new IDcode           rI(m.group(11));
	}

	/**
	 * oncatenation of multiple records
	 */
//	public Continuation     co ntinuation  Allows c() {
//		return ntinuation  Allows c;
//	}

	/**
	 * t this entry was replaced.
	 */
//	public Date             re pDate       Date tha() {
//		return pDate       Date tha;
//	}

	/**
	 * of this entry.
	 */
//	public IDcode           id Code        ID code() {
//		return Code        ID code;
//	}

	/**
	 * of entry that replaced this one.
	 */
//	public IDcode           rI dCode       ID code() {
//		return dCode       ID code;
//	}

	/**
	 * of entry that replaced this one.
	 */
//	public IDcode           rI dCode       ID code() {
//		return dCode       ID code;
//	}

	/**
	 * of entry that replaced this one.
	 */
//	public IDcode           rI dCode       ID code() {
//		return dCode       ID code;
//	}

	/**
	 * of entry that replaced this one.
	 */
//	public IDcode           rI dCode       ID code() {
//		return dCode       ID code;
//	}

	/**
	 * of entry that replaced this one.
	 */
//	public IDcode           rI dCode       ID code() {
//		return dCode       ID code;
//	}

	/**
	 * of entry that replaced this one.
	 */
//	public IDcode           rI dCode       ID code() {
//		return dCode       ID code;
//	}

	/**
	 * of entry that replaced this one.
	 */
//	public IDcode           rI dCode       ID code() {
//		return dCode       ID code;
//	}

	/**
	 * of entry that replaced this one.
	 */
//	public IDcode           rI dCode       ID code() {
//		return dCode       ID code;
//	}

	@Override	
	public String toString() {
		return String.format(format);
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
