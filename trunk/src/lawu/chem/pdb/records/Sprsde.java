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

import java.util.ArrayList;
import java.util.List;
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
public class Sprsde {
	private Continuation continuation;
	private Date sprsdeDate;
	private IdCode idCode;
	private List<IdCode> sIdCodeList = new ArrayList<IdCode>(8);

	private final static Pattern pattern = Pattern.compile("SPRSDE  (..) (.{9}) (.{4}) {6}(.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) {10}"); //$NON-NLS-1$
	private final static String format = "SPRSDE  %2s %9s %4s      %4s %4s %4s %4s %4s %4s %4s %4s          "; //$NON-NLS-1$

	public Sprsde(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		continuation = new Continuation(m.group(1));
		sprsdeDate = new Date(m.group(2));
		idCode = new IdCode(m.group(3));
		sIdCodeList.add(new IdCode(m.group(4)));
		sIdCodeList.add(new IdCode(m.group(5)));
		sIdCodeList.add(new IdCode(m.group(6)));
		sIdCodeList.add(new IdCode(m.group(7)));
		sIdCodeList.add(new IdCode(m.group(8)));
		sIdCodeList.add(new IdCode(m.group(9)));
		sIdCodeList.add(new IdCode(m.group(10)));
		sIdCodeList.add(new IdCode(m.group(11)));
	}

	/**
	 *  Allows for multiple ID codes.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 *  Date this entry superseded the listed entries. This field is not copied on continuations.
	 */
//	public Date sprsdeDate() {
//		return sprsdeDate;
//	}

	/**
	 *  ID code of this entry. This field is not copied on continuations.
	 */
//	public IdCode idCode() {
//		return idCode;
//	}

	/**
	 *  ID code of a superseded entry.
	 */
//	public IdCode sIdCode() {
//		return sIdCode;
//	}

	/**
	 *  ID code of a superseded entry.
	 */
//	public IdCode sIdCode() {
//		return sIdCode;
//	}

	/**
	 *  ID code of a superseded entry.
	 */
//	public IdCode sIdCode() {
//		return sIdCode;
//	}

	/**
	 *  ID code of a superseded entry.
	 */
//	public IdCode sIdCode() {
//		return sIdCode;
//	}

	/**
	 *  ID code of a superseded entry.
	 */
//	public IdCode sIdCode() {
//		return sIdCode;
//	}

	/**
	 *  ID code of a superseded entry.
	 */
//	public IdCode sIdCode() {
//		return sIdCode;
//	}

	/**
	 *  ID code of a superseded entry.
	 */
//	public IdCode sIdCode() {
//		return sIdCode;
//	}

	/**
	 *  ID code of a superseded entry.
	 */
//	public IdCode sIdCode() {
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
