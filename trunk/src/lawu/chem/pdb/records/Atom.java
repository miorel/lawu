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

public class Atom {
//	private Integer serial;
//	private Atom name;
//	private Character altLoc;
//	private Residue name resName;
//	private Character chainID;
//	private Integer resSeq;
//	private AChar iCode;
//	private Real(8.3) x;
//	private Real(8.3) y;
//	private Real(8.3) z;
//	private Real(6.2) occupancy;
//	private Real(6.2) tempFactor;
//	private LString(2) element;
//	private LString(2) charge;

	private final static Pattern pattern = Pattern.compile("\\AATOM  \\Z"); //$NON-NLS-1$
	private final static String format = "ATOM  "; //$NON-NLS-1$

	public Atom(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Atom serial number.
	 */
//	public Integer serial() {
//		return serial;
//	}

	/**
	 * Atom name.
	 */
//	public Atom name() {
//		return name;
//	}

	/**
	 * Alternate location indicator.
	 */
//	public Character altLoc() {
//		return altLoc;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Chain identifier.
	 */
//	public Character chainID() {
//		return chainID;
//	}

	/**
	 * Residue sequence number.
	 */
//	public Integer resSeq() {
//		return resSeq;
//	}

	/**
	 * Code for insertion of residues.
	 */
//	public AChar iCode() {
//		return iCode;
//	}

	/**
	 * Orthogonal coordinates for X in Angstroms
	 */
//	public Real(8.3) x() {
//		return x;
//	}

	/**
	 * Orthogonal coordinates for Y in Angstroms
	 */
//	public Real(8.3) y() {
//		return y;
//	}

	/**
	 * Orthogonal coordinates for Z in Angstroms
	 */
//	public Real(8.3) z() {
//		return z;
//	}

	/**
	 * Occupancy.
	 */
//	public Real(6.2) occupancy() {
//		return occupancy;
//	}

	/**
	 * Temperature factor.
	 */
//	public Real(6.2) tempFactor() {
//		return tempFactor;
//	}

	/**
	 * Element symbol, right-justified.
	 */
//	public LString(2) element() {
//		return element;
//	}

	/**
	 * Charge on the atom.
	 */
//	public LString(2) charge() {
//		return charge;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Atom) {
			Atom r = (Atom) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
