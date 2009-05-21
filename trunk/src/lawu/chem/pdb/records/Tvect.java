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
public class Tvect {
//	private lawu.chem.pdb.primitives.Integer serial;
//	private Real(10.5) t[1];
//	private Real(10.5) t[2];
//	private Real(10.5) t[3];
//	private lawu.chem.pdb.primitives.String text;

	private final static Pattern pattern = Pattern.compile("TVECT  (...)(.{10})(.{10})(.{10})(.{30}) {10}"); //$NON-NLS-1$
	private final static String format = "TVECT  %3s%10s%10s%10s%30s          "; //$NON-NLS-1$

	public Tvect(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		serial = new lawu.chem.pdb.primitives.Integer(m.group(1));
		t[1] = new Real(m.group(2), 10, 5);
		t[2] = new Real(m.group(3), 10, 5);
		t[3] = new Real(m.group(4), 10, 5);
		text = new lawu.chem.pdb.primitives.String(m.group(5));
	}

	/**
	 * Serial number.
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 * Components of translation vector.
	 */
//	public Real(10.5) t[1]() {
//		return t[1];
//	}

	/**
	 * Components of translation vector.
	 */
//	public Real(10.5) t[2]() {
//		return t[2];
//	}

	/**
	 * Components of translation vector.
	 */
//	public Real(10.5) t[3]() {
//		return t[3];
//	}

	/**
	 * Comment.
	 */
//	public lawu.chem.pdb.primitives.String text() {
//		return text;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Tvect) {
			Tvect r = (Tvect) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
