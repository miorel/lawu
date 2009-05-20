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

public class Siguij {
//	private Integer serial;
//	private Atom name;
//	private Character altLoc;
//	private Residue name resName;
//	private Character chainID;
//	private Integer resSeq;
//	private AChar iCode;
//	private Integer sig[1][1];
//	private Integer sig[2][2];
//	private Integer sig[3][3];
//	private Integer sig[1][2];
//	private Integer sig[1][3];
//	private Integer sig[2][3];
//	private LString(2) element;
//	private LString(2) charge;

	private final static Pattern pattern = Pattern.compile("\\ASIGUIJ\\Z"); //$NON-NLS-1$
	private final static String format = "SIGUIJ"; //$NON-NLS-1$

	public Siguij(String record) {
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
	 * Insertion code.
	 */
//	public AChar iCode() {
//		return iCode;
//	}

	/**
	 * Sigma U(1,1)
	 */
//	public Integer sig[1][1]() {
//		return sig[1][1];
//	}

	/**
	 * Sigma U(2,2)
	 */
//	public Integer sig[2][2]() {
//		return sig[2][2];
//	}

	/**
	 * Sigma U(3,3)
	 */
//	public Integer sig[3][3]() {
//		return sig[3][3];
//	}

	/**
	 * Sigma U(1,2)
	 */
//	public Integer sig[1][2]() {
//		return sig[1][2];
//	}

	/**
	 * Sigma U(1,3)
	 */
//	public Integer sig[1][3]() {
//		return sig[1][3];
//	}

	/**
	 * Sigma U(2,3)
	 */
//	public Integer sig[2][3]() {
//		return sig[2][3];
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
		if(o instanceof Siguij) {
			Siguij r = (Siguij) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
