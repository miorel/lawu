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

public class Formul {
//	private Integer compNum;
//	private LString(3) hetID;
//	private Integer continuation;
//	private Character asterisk;
//	private String text;

	private final static Pattern pattern = Pattern.compile("\\AFORMUL\\Z"); //$NON-NLS-1$
	private final static String format = "FORMUL"; //$NON-NLS-1$

	public Formul(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Component number.
	 */
//	public Integer compNum() {
//		return compNum;
//	}

	/**
	 * Het identifier.
	 */
//	public LString(3) hetID() {
//		return hetID;
//	}

	/**
	 * Continuation number.
	 */
//	public Integer continuation() {
//		return continuation;
//	}

	/**
	 * "*" for water.
	 */
//	public Character asterisk() {
//		return asterisk;
//	}

	/**
	 * Chemical formula.
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
		if(o instanceof Formul) {
			Formul r = (Formul) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
