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

public class Remark {
//	private LString(1) "1";
//	private LString(4) "AUTH";
//	private Continuation continuation;
//	private List authorList;

	private final static Pattern pattern = Pattern.compile("\\AREMARK\\Z"); //$NON-NLS-1$
	private final static String format = "REMARK"; //$NON-NLS-1$

	public Remark(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Appears on all continuation records
	 */
//	public LString(4) "AUTH"() {
//		return "AUTH";
//	}

	/**
	 * Allows a long list of authors.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * List of the authors.
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
		if(o instanceof Remark) {
			Remark r = (Remark) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
