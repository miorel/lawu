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

public class Hetnam {
//	private Continuation continuation;
//	private LString(3) hetID;
//	private String text;

	private final static Pattern pattern = Pattern.compile("\\AHETNAM\\Z"); //$NON-NLS-1$
	private final static String format = "HETNAM"; //$NON-NLS-1$

	public Hetnam(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Allows concatenation of multiple records.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * Het identifier, right-justified.
	 */
//	public LString(3) hetID() {
//		return hetID;
//	}

	/**
	 * Chemical name.
	 */
//	public String text() {
//		return text;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Hetnam) {
			Hetnam r = (Hetnam) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
