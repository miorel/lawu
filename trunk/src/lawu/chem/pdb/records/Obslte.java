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
import lawu.chem.pdb.primitives.AtomName;
import lawu.chem.pdb.primitives.Continuation;
import lawu.chem.pdb.primitives.IdCode;
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;
import lawu.chem.pdb.primitives.ResidueName;
import lawu.chem.pdb.primitives.SymOp;

/**
 * @author Miorel-Lucian Palii
 */
public class Obslte {
	private Continuation     co ntinuation;
	private Date             re pDate;
	private IDcode           id Code;
	private IDcode           rI dCode;
	private IDcode           rI dCode;
	private IDcode           rI dCode;
	private IDcode           rI dCode;
	private IDcode           rI dCode;
	private IDcode           rI dCode;
	private IDcode           rI dCode;
	private IDcode           rI dCode;

	private final static Pattern pattern = Pattern.compile("OBSLTE  (..) (.{9}) (.{4}) {6}(.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) {10}"); //$NON-NLS-1$
	private final static String format = "OBSLTE  %2s %9s %4s      %4s %4s %4s %4s %4s %4s %4s %4s          "; //$NON-NLS-1$

	public Obslte(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		// ntinuation = new Continuation     co(m.group(1));
		// pDate = new Date             re(m.group(2));
		// Code = new IDcode           id(m.group(3));
		// dCode = new IDcode           rI(m.group(4));
		// dCode = new IDcode           rI(m.group(5));
		// dCode = new IDcode           rI(m.group(6));
		// dCode = new IDcode           rI(m.group(7));
		// dCode = new IDcode           rI(m.group(8));
		// dCode = new IDcode           rI(m.group(9));
		// dCode = new IDcode           rI(m.group(10));
		// dCode = new IDcode           rI(m.group(11));
	}

	/**
	 *  Allows concatenation of multiple records
	 */
//	public Continuation     co ntinuation() {
//		return ntinuation;
//	}

	/**
	 *  Date that this entry was replaced.
	 */
//	public Date             re pDate() {
//		return pDate;
//	}

	/**
	 *  ID code of this entry.
	 */
//	public IDcode           id Code() {
//		return Code;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IDcode           rI dCode() {
//		return dCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IDcode           rI dCode() {
//		return dCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IDcode           rI dCode() {
//		return dCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IDcode           rI dCode() {
//		return dCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IDcode           rI dCode() {
//		return dCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IDcode           rI dCode() {
//		return dCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IDcode           rI dCode() {
//		return dCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IDcode           rI dCode() {
//		return dCode;
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
