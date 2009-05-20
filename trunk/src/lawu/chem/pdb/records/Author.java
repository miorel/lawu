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

public class Author {
//	private Continuation continuation;
//	private List authorList;

	private final static Pattern pattern = Pattern.compile("\\AAUTHOR\\Z"); //$NON-NLS-1$
	private final static String format = "AUTHOR"; //$NON-NLS-1$

	public Author(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Allows concatenation of multiple records
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * List of the author names, separated by commas.
	 */
//	public List authorList() {
//		return authorList;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Author) {
			Author r = (Author) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
