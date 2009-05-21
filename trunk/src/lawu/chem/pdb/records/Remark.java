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
public class Remark {
//	private LString(1) "1";
//	private LString(4) "AUTH";
//	private Continuation continuation;
//	private List authorList;

	private final static Pattern pattern = Pattern.compile("REMARK   (.)  (.{4})(..) (.{51}) {10}"); //$NON-NLS-1$
	private final static String format = "REMARK   %1s  %4s%2s %51s          "; //$NON-NLS-1$

	public Remark(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		// "1" = new LString(1)(m.group(1));
		// "AUTH" = new LString(4)(m.group(2));
		continuation = new Continuation(m.group(3));
		// authorList = new List(m.group(4));
	}

	/**
	 * Appears on all continuation records
	 */
//	public LString(4) "AUTH"() {
//		return "AUTH";
//	}

	/**
	 * Allows a long list of authors.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * List of the authors.
	 */
//	public List authorList() {
//		return authorList;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Remark) {
			Remark r = (Remark) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}