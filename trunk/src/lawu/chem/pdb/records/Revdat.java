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
public class Revdat {
	private lawu.chem.pdb.primitives.Integer modNum;
	private Continuation continuation;
	private Date modDate;
	private lawu.chem.pdb.primitives.String modId;
	private lawu.chem.pdb.primitives.Integer modType;
	private LString record;
	private LString record;
	private LString record;
	private LString record;

	private final static Pattern pattern = Pattern.compile("REVDAT (...)(..) (.{9}) (.{5})   (.) {7}(.{6}) (.{6}) (.{6}) (.{6}) {14}"); //$NON-NLS-1$
	private final static String format = "REVDAT %3s%2s %9s %5s   %1s       %6s %6s %6s %6s              "; //$NON-NLS-1$

	public Revdat(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		modNum = new lawu.chem.pdb.primitives.Integer(m.group(1));
		continuation = new Continuation(m.group(2));
		modDate = new Date(m.group(3));
		// modId = new lawu.chem.pdb.primitives.String(5)(m.group(4));
		modType = new lawu.chem.pdb.primitives.Integer(m.group(5));
		record = new LString(m.group(6), 6);
		record = new LString(m.group(7), 6);
		record = new LString(m.group(8), 6);
		record = new LString(m.group(9), 6);
	}

	/**
	 *  Modification number.
	 */
//	public lawu.chem.pdb.primitives.Integer modNum() {
//		return modNum;
//	}

	/**
	 *  Allows concatenation of multiple records
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 *  Date of modification (or release for new entries). This is not repeated on continuation lines.
	 */
//	public Date modDate() {
//		return modDate;
//	}

	/**
	 *  Identifies this particular modification. It links to the archive used internally by PDB. This is not repeated on continuation lines
	 */
//	public lawu.chem.pdb.primitives.String(5) modId() {
//		return modId;
//	}

	/**
	 *  An integer identifying the type of modification. In case of revisions with more than one possible modType, the highest value applicable will be assigned
	 */
//	public lawu.chem.pdb.primitives.Integer modType() {
//		return modType;
//	}

	/**
	 *  Name of the modified record.
	 */
//	public LString(6) record() {
//		return record;
//	}

	/**
	 *  Name of the modified record.
	 */
//	public LString(6) record() {
//		return record;
//	}

	/**
	 *  Name of the modified record.
	 */
//	public LString(6) record() {
//		return record;
//	}

	/**
	 *  Name of the modified record.
	 */
//	public LString(6) record() {
//		return record;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Revdat) {
			Revdat r = (Revdat) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
