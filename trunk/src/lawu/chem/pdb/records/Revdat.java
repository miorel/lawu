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

public class Revdat {
//	private Integer modNum;
//	private Continuation continuation;
//	private Date modDate;
//	private String(5) modId;
//	private Integer modType;
//	private LString(6) record;
//	private LString(6) record;
//	private LString(6) record;
//	private LString(6) record;

	private final static Pattern pattern = Pattern.compile("\\AREVDAT\\Z"); //$NON-NLS-1$
	private final static String format = "REVDAT"; //$NON-NLS-1$

	public Revdat(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Modification number.
	 */
//	public Integer modNum() {
//		return modNum;
//	}

	/**
	 * Allows concatenation of multiple records
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * Date of modification (or release for new entries). This is not repeated on continuation lines.
	 */
//	public Date modDate() {
//		return modDate;
//	}

	/**
	 * Identifies this particular modification. It links to the archive used internally by PDB. This is not repeated on continuation lines
	 */
//	public String(5) modId() {
//		return modId;
//	}

	/**
	 * An integer identifying the type of modification. In case of revisions with more than one possible modType, the highest value applicable will be assigned
	 */
//	public Integer modType() {
//		return modType;
//	}

	/**
	 * Name of the modified record.
	 */
//	public LString(6) record() {
//		return record;
//	}

	/**
	 * Name of the modified record.
	 */
//	public LString(6) record() {
//		return record;
//	}

	/**
	 * Name of the modified record.
	 */
//	public LString(6) record() {
//		return record;
//	}

	/**
	 * Name of the modified record.
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
