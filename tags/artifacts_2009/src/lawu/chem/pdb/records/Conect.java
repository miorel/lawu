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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lawu.chem.pdb.primitives.AChar;
import lawu.chem.pdb.primitives.AtomName;
import lawu.chem.pdb.primitives.Continuation;
import lawu.chem.pdb.primitives.Date;
import lawu.chem.pdb.primitives.IdCode;
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;
import lawu.chem.pdb.primitives.ResidueName;
import lawu.chem.pdb.primitives.SymOp;

/**
 * @author Miorel-Lucian Palii
 */
public class Conect {
	private List<lawu.chem.pdb.primitives.Integer> serialList = new ArrayList<lawu.chem.pdb.primitives.Integer>(5);

	private final static Pattern pattern = Pattern.compile("CONECT(.{5})(.{5})(.{5})(.{5})(.{5}) {49}"); //$NON-NLS-1$
	private final static String format = "CONECT%5s%5s%5s%5s%5s                                                 "; //$NON-NLS-1$

	public Conect(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		this.serialList.add(new lawu.chem.pdb.primitives.Integer(m.group(1)));
		this.serialList.add(new lawu.chem.pdb.primitives.Integer(m.group(2)));
		this.serialList.add(new lawu.chem.pdb.primitives.Integer(m.group(3)));
		this.serialList.add(new lawu.chem.pdb.primitives.Integer(m.group(4)));
		this.serialList.add(new lawu.chem.pdb.primitives.Integer(m.group(5)));
	}

	/**
	 *  Atom serial number
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 *  Serial number of bonded atom
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 *  Serial number of bonded atom
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 *  Serial number of bonded atom
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 *  Serial number of bonded atom
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
