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
public class Caveat {
//	private Continuation continuation      Al;
//	private IDcode idCode            PD;
//	private lawu.chem.pdb.primitives.String comment           Fr;

	private final static Pattern pattern = Pattern.compile("CAVEAT  (..) (.{4}) {4}(.{51}) {10}"); //$NON-NLS-1$
	private final static String format = "CAVEAT  %2s %4s    %51s          "; //$NON-NLS-1$

	public Caveat(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		continuation      Al = new Continuation(m.group(1));
		idCode            PD = new IdCode(m.group(2));
		comment           Fr = new lawu.chem.pdb.primitives.String(m.group(3));
	}

	/**
	 * lows concatenation of multiple records.
	 */
//	public Continuation continuation      Al() {
//		return continuation      Al;
//	}

	/**
	 * B ID code of this entry.
	 */
//	public IDcode idCode            PD() {
//		return idCode            PD;
//	}

	/**
	 * ee text giving the reason for the CAVEAT.
	 */
//	public lawu.chem.pdb.primitives.String comment           Fr() {
//		return comment           Fr;
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
