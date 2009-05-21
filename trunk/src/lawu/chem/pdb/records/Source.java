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
public class Source {
	private Continuation continuation;
	private Specification list srcName;

	private final static Pattern pattern = Pattern.compile("SOURCE  (..)(.{60}) {10}"); //$NON-NLS-1$
	private final static String format = "SOURCE  %2s%60s          "; //$NON-NLS-1$

	public Source(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		continuation = new Continuation(m.group(1));
		// srcName = new Specification list(m.group(2));
	}

	/**
	 * Allows concatenation of multiple records.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * Identifies the source of the macromolecule in a token: value format.
	 */
//	public Specification list srcName() {
//		return srcName;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Source) {
			Source r = (Source) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
