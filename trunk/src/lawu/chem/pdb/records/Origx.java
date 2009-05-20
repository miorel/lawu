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

public class Origx {
//	private int n;
//	private Real(10.6) o[n][1];
//	private Real(10.6) o[n][2];
//	private Real(10.6) o[n][3];
//	private Real(10.5) t[n];

	private final static Pattern pattern = Pattern.compile("\\AORIGX(\\d)\\Z"); //$NON-NLS-1$
	private final static String format = "ORIGX%d"; //$NON-NLS-1$

	public Origx(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
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
