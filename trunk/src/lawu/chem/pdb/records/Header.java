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

public class Header {
//	private String(40) classification;
//	private Date depDate;
//	private IDcode idCode;

	private final static Pattern pattern = Pattern.compile("\\AHEADER\\Z"); //$NON-NLS-1$
	private final static String format = "HEADER"; //$NON-NLS-1$

	public Header(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Classifies the molecule(s)
	 */
//	public String(40) classification() {
//		return classification;
//	}

	/**
	 * Deposition date. This is the date the coordinates were received by the PDB
	 */
//	public Date depDate() {
//		return depDate;
//	}

	/**
	 * This identifier is unique within the PDB
	 */
//	public IDcode idCode() {
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
