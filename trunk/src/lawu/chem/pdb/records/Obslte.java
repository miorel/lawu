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

	private final static Pattern pattern = Pattern.compile("\\AOBSLTE\\Z"); //$NON-NLS-1$
	private final static String format = "OBSLTE"; //$NON-NLS-1$

	public Obslte(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
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
