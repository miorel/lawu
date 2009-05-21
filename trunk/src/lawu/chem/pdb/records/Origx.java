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
public class Origx {
	private int n;
	private Real on1;
	private Real on2;
	private Real on3;
	private Real tn;

	private final static Pattern pattern = Pattern.compile("ORIGX(\\d) {4}(.{10})(.{10})(.{10}) {5}(.{10}) {25}"); //$NON-NLS-1$
	private final static String format = "ORIGX%d    %10s%10s%10s     %10s                         "; //$NON-NLS-1$

	public Origx(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		n = Integer.parseInt(m.group(1));
		on1 = new Real(m.group(2), 10, 6);
		on2 = new Real(m.group(3), 10, 6);
		on3 = new Real(m.group(4), 10, 6);
		tn = new Real(m.group(5), 10, 5);
	}

	/**
	 * On1
	 */
//	public Real(10.6) on1() {
//		return on1;
//	}

	/**
	 * On2
	 */
//	public Real(10.6) on2() {
//		return on2;
//	}

	/**
	 * On3
	 */
//	public Real(10.6) on3() {
//		return on3;
//	}

	/**
	 * Tn
	 */
//	public Real(10.5) tn() {
//		return tn;
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
