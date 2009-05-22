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
public class Obslte {
	private Continuation continuation;
	private Date repDate;
	private IdCode idCode;
	private List<IdCode> rIdCodeList = new ArrayList<IdCode>(8);

	private final static Pattern pattern = Pattern.compile("OBSLTE  (..) (.{9}) (.{4}) {6}(.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) (.{4}) {10}"); //$NON-NLS-1$
	private final static String format = "OBSLTE  %2s %9s %4s      %4s %4s %4s %4s %4s %4s %4s %4s          "; //$NON-NLS-1$

	public Obslte(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		continuation = new Continuation(m.group(1));
		repDate = new Date(m.group(2));
		idCode = new IdCode(m.group(3));
		rIdCodeList.add(new IdCode(m.group(4)));
		rIdCodeList.add(new IdCode(m.group(5)));
		rIdCodeList.add(new IdCode(m.group(6)));
		rIdCodeList.add(new IdCode(m.group(7)));
		rIdCodeList.add(new IdCode(m.group(8)));
		rIdCodeList.add(new IdCode(m.group(9)));
		rIdCodeList.add(new IdCode(m.group(10)));
		rIdCodeList.add(new IdCode(m.group(11)));
	}

	/**
	 *  Allows concatenation of multiple records
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 *  Date that this entry was replaced.
	 */
//	public Date repDate() {
//		return repDate;
//	}

	/**
	 *  ID code of this entry.
	 */
//	public IdCode idCode() {
//		return idCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IdCode rIdCode() {
//		return rIdCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IdCode rIdCode() {
//		return rIdCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IdCode rIdCode() {
//		return rIdCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IdCode rIdCode() {
//		return rIdCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IdCode rIdCode() {
//		return rIdCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IdCode rIdCode() {
//		return rIdCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IdCode rIdCode() {
//		return rIdCode;
//	}

	/**
	 *  ID code of entry that replaced this one.
	 */
//	public IdCode rIdCode() {
//		return rIdCode;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Obslte) {
			Obslte r = (Obslte) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
