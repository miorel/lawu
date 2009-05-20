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

public class Tvect {
//	private Integer serial;
//	private Real(10.5) t[1];
//	private Real(10.5) t[2];
//	private Real(10.5) t[3];
//	private String text;

	private final static Pattern pattern = Pattern.compile("\\ATVECT \\Z"); //$NON-NLS-1$
	private final static String format = "TVECT "; //$NON-NLS-1$

	public Tvect(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Serial number.
	 */
//	public Integer serial() {
//		return serial;
//	}

	/**
	 * Components of translation vector.
	 */
//	public Real(10.5) t[1]() {
//		return t[1];
//	}

	/**
	 * Components of translation vector.
	 */
//	public Real(10.5) t[2]() {
//		return t[2];
//	}

	/**
	 * Components of translation vector.
	 */
//	public Real(10.5) t[3]() {
//		return t[3];
//	}

	/**
	 * Comment.
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
		if(o instanceof Tvect) {
			Tvect r = (Tvect) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
