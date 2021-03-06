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
public class Mtrix {
	private int n;
	private lawu.chem.pdb.primitives.Integer serial;
	private Real mn1;
	private Real mn2;
	private Real mn3;
	private Real vn;
	private lawu.chem.pdb.primitives.Integer iGiven;

	private final static Pattern pattern = Pattern.compile("MTRIX(\\d) (...)(.{10})(.{10})(.{10}) {5}(.{10}) {4}(.) {20}"); //$NON-NLS-1$
	private final static String format = "MTRIX%d %3s%10s%10s%10s     %10s    %1s                    "; //$NON-NLS-1$

	public Mtrix(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		this.n = Integer.parseInt(m.group(1));
		this.serial = new lawu.chem.pdb.primitives.Integer(m.group(2));
		this.mn1 = new Real(m.group(3), 10, 6);
		this.mn2 = new Real(m.group(4), 10, 6);
		this.mn3 = new Real(m.group(5), 10, 6);
		this.vn = new Real(m.group(6), 10, 5);
		this.iGiven = new lawu.chem.pdb.primitives.Integer(m.group(7));
	}

	/**
	 *  Serial number.
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 *  Mn1
	 */
//	public Real(10.6) mn1() {
//		return mn1;
//	}

	/**
	 *  Mn2
	 */
//	public Real(10.6) mn2() {
//		return mn2;
//	}

	/**
	 *  Mn3
	 */
//	public Real(10.6) mn3() {
//		return mn3;
//	}

	/**
	 *  Vn
	 */
//	public Real(10.5) vn() {
//		return vn;
//	}

	/**
	 *  1 if coordinates for the representations which are approximately related by the transformations of the molecule are contained in the entry. Otherwise, blank.
	 */
//	public lawu.chem.pdb.primitives.Integer iGiven() {
//		return iGiven;
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
