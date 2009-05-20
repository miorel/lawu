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

public class Sprsde {
//	private Continuation continuation;
//	private Date sprsdeDate;
//	private IDcode idCode;
//	private IDcode sIdCode;
//	private IDcode sIdCode;
//	private IDcode sIdCode;
//	private IDcode sIdCode;
//	private IDcode sIdCode;
//	private IDcode sIdCode;
//	private IDcode sIdCode;
//	private IDcode sIdCode;

	private final static Pattern pattern = Pattern.compile("\\ASPRSDE\\Z"); //$NON-NLS-1$
	private final static String format = "SPRSDE"; //$NON-NLS-1$

	public Sprsde(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Allows for multiple ID codes.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * Date this entry superseded the listed entries. This field is not copied on continuations.
	 */
//	public Date sprsdeDate() {
//		return sprsdeDate;
//	}

	/**
	 * ID code of this entry. This field is not copied on continuations.
	 */
//	public IDcode idCode() {
//		return idCode;
//	}

	/**
	 * ID code of a superseded entry.
	 */
//	public IDcode sIdCode() {
//		return sIdCode;
//	}

	/**
	 * ID code of a superseded entry.
	 */
//	public IDcode sIdCode() {
//		return sIdCode;
//	}

	/**
	 * ID code of a superseded entry.
	 */
//	public IDcode sIdCode() {
//		return sIdCode;
//	}

	/**
	 * ID code of a superseded entry.
	 */
//	public IDcode sIdCode() {
//		return sIdCode;
//	}

	/**
	 * ID code of a superseded entry.
	 */
//	public IDcode sIdCode() {
//		return sIdCode;
//	}

	/**
	 * ID code of a superseded entry.
	 */
//	public IDcode sIdCode() {
//		return sIdCode;
//	}

	/**
	 * ID code of a superseded entry.
	 */
//	public IDcode sIdCode() {
//		return sIdCode;
//	}

	/**
	 * ID code of a superseded entry.
	 */
//	public IDcode sIdCode() {
//		return sIdCode;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Sprsde) {
			Sprsde r = (Sprsde) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
