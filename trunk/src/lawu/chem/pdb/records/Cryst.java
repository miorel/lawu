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
public class Cryst {
	private int n;
	private Real a;
	private Real b;
	private Real c;
	private Real alpha;
	private Real beta;
	private Real gamma;
	private LString sGroup;
	private lawu.chem.pdb.primitives.Integer z;

	private final static Pattern pattern = Pattern.compile("CRYST(\\d)(.{9})(.{9})(.{9})(.{7})(.{7})(.{7}) (.{11})(.{4}) {10}"); //$NON-NLS-1$
	private final static String format = "CRYST%d%9s%9s%9s%7s%7s%7s %11s%4s          "; //$NON-NLS-1$

	public Cryst(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		n = Integer.parseInt(m.group(1));
		a = new Real(m.group(2), 9, 3);
		b = new Real(m.group(3), 9, 3);
		c = new Real(m.group(4), 9, 3);
		alpha = new Real(m.group(5), 7, 2);
		beta = new Real(m.group(6), 7, 2);
		gamma = new Real(m.group(7), 7, 2);
		sGroup = new LString(m.group(8));
		z = new lawu.chem.pdb.primitives.Integer(m.group(9));
	}

	/**
	 *  a (Angstroms).
	 */
//	public Real(9.3) a() {
//		return a;
//	}

	/**
	 *  b (Angstroms).
	 */
//	public Real(9.3) b() {
//		return b;
//	}

	/**
	 *  c (Angstroms).
	 */
//	public Real(9.3) c() {
//		return c;
//	}

	/**
	 *  alpha (degrees).
	 */
//	public Real(7.2) alpha() {
//		return alpha;
//	}

	/**
	 *  beta (degrees).
	 */
//	public Real(7.2) beta() {
//		return beta;
//	}

	/**
	 *  gamma (degrees).
	 */
//	public Real(7.2) gamma() {
//		return gamma;
//	}

	/**
	 *  Space group.
	 */
//	public LString sGroup() {
//		return sGroup;
//	}

	/**
	 *  Z value.
	 */
//	public lawu.chem.pdb.primitives.Integer z() {
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
