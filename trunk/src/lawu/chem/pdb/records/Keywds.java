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

public class Keywds {
//	private Continuation continuation;
//	private List keywds;

	private final static Pattern pattern = Pattern.compile("\\AKEYWDS\\Z"); //$NON-NLS-1$
	private final static String format = "KEYWDS"; //$NON-NLS-1$

	public Keywds(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Allows concatenation of records if necessary
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * Comma-separated list of keywords relevant to the entry.
	 */
//	public List keywds() {
//		return keywds;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Keywds) {
			Keywds r = (Keywds) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
