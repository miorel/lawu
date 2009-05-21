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
public class Formul {
	private lawu.chem.pdb.primitives.Integer compNum;
	private LString hetID;
	private lawu.chem.pdb.primitives.Integer continuation;
	private lawu.chem.pdb.primitives.Character asterisk;
	private lawu.chem.pdb.primitives.String text;

	private final static Pattern pattern = Pattern.compile("FORMUL  (..)  (...) (..)(.)(.{51}) {10}"); //$NON-NLS-1$
	private final static String format = "FORMUL  %2s  %3s %2s%1s%51s          "; //$NON-NLS-1$

	public Formul(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		compNum = new lawu.chem.pdb.primitives.Integer(m.group(1));
		hetID = new LString(m.group(2), 3);
		continuation = new lawu.chem.pdb.primitives.Integer(m.group(3));
		asterisk = new lawu.chem.pdb.primitives.Character(m.group(4));
		text = new lawu.chem.pdb.primitives.String(m.group(5));
	}

	/**
	 * Component number.
	 */
//	public lawu.chem.pdb.primitives.Integer compNum() {
//		return compNum;
//	}

	/**
	 * Het identifier.
	 */
//	public LString(3) hetID() {
//		return hetID;
//	}

	/**
	 * Continuation number.
	 */
//	public lawu.chem.pdb.primitives.Integer continuation() {
//		return continuation;
//	}

	/**
	 * "*" for water.
	 */
//	public lawu.chem.pdb.primitives.Character asterisk() {
//		return asterisk;
//	}

	/**
	 * Chemical formula.
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
		if(o instanceof Formul) {
			Formul r = (Formul) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
