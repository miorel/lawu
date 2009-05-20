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

public class Modres {
//	private IDcode idCode     ID;
//	private Residue name resName    Res;
//	private Character chainID    Cha;
//	private Integer seqNum     Seq;
//	private AChar iCode      Ins;
//	private Residue name stdRes     Sta;
//	private String comment    Des;

	private final static Pattern pattern = Pattern.compile("\\AMODRES\\Z"); //$NON-NLS-1$
	private final static String format = "MODRES"; //$NON-NLS-1$

	public Modres(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * code of this entry.
	 */
//	public IDcode idCode     ID() {
//		return idCode     ID;
//	}

	/**
	 * idue name used in this entry.
	 */
//	public Residue name resName    Res() {
//		return resName    Res;
//	}

	/**
	 * in identifier.
	 */
//	public Character chainID    Cha() {
//		return chainID    Cha;
//	}

	/**
	 * uence number.
	 */
//	public Integer seqNum     Seq() {
//		return seqNum     Seq;
//	}

	/**
	 * ertion code.
	 */
//	public AChar iCode      Ins() {
//		return iCode      Ins;
//	}

	/**
	 * ndard residue name.
	 */
//	public Residue name stdRes     Sta() {
//		return stdRes     Sta;
//	}

	/**
	 * cription of the residue ification
	 */
//	public String comment    Des() {
//		return comment    Des;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Modres) {
			Modres r = (Modres) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
