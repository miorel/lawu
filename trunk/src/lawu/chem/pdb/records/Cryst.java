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

public class Cryst {
//	private int n;
//	private Real(9.3) a;
//	private Real(9.3) b;
//	private Real(9.3) c;
//	private Real(7.2) alpha;
//	private Real(7.2) beta;
//	private Real(7.2) gamma;
//	private LString sGroup;
//	private Integer z;

	private final static Pattern pattern = Pattern.compile("\\ACRYST(\\d)\\Z"); //$NON-NLS-1$
	private final static String format = "CRYST%d"; //$NON-NLS-1$

	public Cryst(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * a (Angstroms).
	 */
//	public Real(9.3) a() {
//		return a;
//	}

	/**
	 * b (Angstroms).
	 */
//	public Real(9.3) b() {
//		return b;
//	}

	/**
	 * c (Angstroms).
	 */
//	public Real(9.3) c() {
//		return c;
//	}

	/**
	 * alpha (degrees).
	 */
//	public Real(7.2) alpha() {
//		return alpha;
//	}

	/**
	 * beta (degrees).
	 */
//	public Real(7.2) beta() {
//		return beta;
//	}

	/**
	 * gamma (degrees).
	 */
//	public Real(7.2) gamma() {
//		return gamma;
//	}

	/**
	 * Space group.
	 */
//	public LString sGroup() {
//		return sGroup;
//	}

	/**
	 * Z value.
	 */
//	public Integer z() {
//		return z;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Cryst) {
			Cryst r = (Cryst) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
