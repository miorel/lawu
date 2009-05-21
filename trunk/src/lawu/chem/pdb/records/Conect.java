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
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;

/**
 * @author Miorel-Lucian Palii
 */
public class Conect {
	private lawu.chem.pdb.primitives.Integer serial;
	private lawu.chem.pdb.primitives.Integer serial;
	private lawu.chem.pdb.primitives.Integer serial;
	private lawu.chem.pdb.primitives.Integer serial;
	private lawu.chem.pdb.primitives.Integer serial;

	private final static Pattern pattern = Pattern.compile("CONECT(.{5})(.{5})(.{5})(.{5})(.{5}) {49}"); //$NON-NLS-1$
	private final static String format = "CONECT%5s%5s%5s%5s%5s                                                 "; //$NON-NLS-1$

	public Conect(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		serial = new lawu.chem.pdb.primitives.Integer(m.group(1));
		serial = new lawu.chem.pdb.primitives.Integer(m.group(2));
		serial = new lawu.chem.pdb.primitives.Integer(m.group(3));
		serial = new lawu.chem.pdb.primitives.Integer(m.group(4));
		serial = new lawu.chem.pdb.primitives.Integer(m.group(5));
	}

	/**
	 * Atom serial number
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 * Serial number of bonded atom
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 * Serial number of bonded atom
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 * Serial number of bonded atom
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 * Serial number of bonded atom
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Conect) {
			Conect r = (Conect) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
