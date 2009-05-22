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
public class Header {
	private lawu.chem.pdb.primitives.String classification;
	private Date depDate;
	private IdCode idCode;

	private final static Pattern pattern = Pattern.compile("HEADER {4}(.{40})(.{9})   (.{4}) {14}"); //$NON-NLS-1$
	private final static String format = "HEADER    %40s%9s   %4s              "; //$NON-NLS-1$

	public Header(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		classification = new lawu.chem.pdb.primitives.String(40)(m.group(1));
		depDate = new Date(m.group(2));
		idCode = new IdCode(m.group(3));
	}

	/**
	 *  Classifies the molecule(s)
	 */
//	public lawu.chem.pdb.primitives.String(40) classification() {
//		return classification;
//	}

	/**
	 *  Deposition date. This is the date the coordinates were received by the PDB
	 */
//	public Date depDate() {
//		return depDate;
//	}

	/**
	 *  This identifier is unique within the PDB
	 */
//	public IdCode idCode() {
//		return idCode;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Header) {
			Header r = (Header) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
