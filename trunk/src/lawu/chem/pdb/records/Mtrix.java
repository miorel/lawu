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

public class Mtrix {
//	private int n;
//	private Integer serial;
//	private Real(10.6) m[n][1];
//	private Real(10.6) m[n][2];
//	private Real(10.6) m[n][3];
//	private Real(10.5) v[n];
//	private Integer iGiven         1;

	private final static Pattern pattern = Pattern.compile("\\AMTRIX(\\d)\\Z"); //$NON-NLS-1$
	private final static String format = "MTRIX%d"; //$NON-NLS-1$

	public Mtrix(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Serial number.
	 */
//	public Integer serial() {
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
//	public Integer iGiven         1() {
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
