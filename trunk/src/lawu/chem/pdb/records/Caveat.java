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
public class Caveat {
	private Continuation continuation;
	private IdCode idCode;
	private lawu.chem.pdb.primitives.String comment;

	private final static Pattern pattern = Pattern.compile("CAVEAT  (..) (.{4}) {4}(.{51}) {10}"); //$NON-NLS-1$
	private final static String format = "CAVEAT  %2s %4s    %51s          "; //$NON-NLS-1$

	public Caveat(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		continuation = new Continuation(m.group(1));
		idCode = new IdCode(m.group(2));
		comment = new lawu.chem.pdb.primitives.String(m.group(3));
	}

	/**
	 *  Allows concatenation of multiple records.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 *  PDB ID code of this entry.
	 */
//	public IdCode idCode() {
//		return idCode;
//	}

	/**
	 *  Free text giving the reason for the CAVEAT.
	 */
//	public lawu.chem.pdb.primitives.String comment() {
//		return comment;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Caveat) {
			Caveat r = (Caveat) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
