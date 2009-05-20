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

public class Link {
//	private Atom name1;
//	private Character altLoc1;
//	private Residue name resName1;
//	private Character chainID1;
//	private Integer resSeq1;
//	private AChar iCode1;
//	private Atom name2;
//	private Character altLoc2;
//	private Residue name resName2;
//	private Character chainID2;
//	private Integer resSeq2;
//	private AChar iCode2;
//	private SymOP sym1;
//	private SymOP sym2;

	private final static Pattern pattern = Pattern.compile("\\ALINK  \\Z"); //$NON-NLS-1$
	private final static String format = "LINK  "; //$NON-NLS-1$

	public Link(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Atom name.
	 */
//	public Atom name1() {
//		return name1;
//	}

	/**
	 * Alternate location indicator.
	 */
//	public Character altLoc1() {
//		return altLoc1;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName1() {
//		return resName1;
//	}

	/**
	 * Chain identifier.
	 */
//	public Character chainID1() {
//		return chainID1;
//	}

	/**
	 * Residue sequence number.
	 */
//	public Integer resSeq1() {
//		return resSeq1;
//	}

	/**
	 * Insertion code.
	 */
//	public AChar iCode1() {
//		return iCode1;
//	}

	/**
	 * Atom name.
	 */
//	public Atom name2() {
//		return name2;
//	}

	/**
	 * Alternate location indicator.
	 */
//	public Character altLoc2() {
//		return altLoc2;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName2() {
//		return resName2;
//	}

	/**
	 * Chain identifier.
	 */
//	public Character chainID2() {
//		return chainID2;
//	}

	/**
	 * Residue sequence number.
	 */
//	public Integer resSeq2() {
//		return resSeq2;
//	}

	/**
	 * Insertion code.
	 */
//	public AChar iCode2() {
//		return iCode2;
//	}

	/**
	 * Symmetry operator for 1st atom.
	 */
//	public SymOP sym1() {
//		return sym1;
//	}

	/**
	 * Symmetry operator for 2nd atom.
	 */
//	public SymOP sym2() {
//		return sym2;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Link) {
			Link r = (Link) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
