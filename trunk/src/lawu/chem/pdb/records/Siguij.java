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

import lawu.chem.pdb.primitives.AChar;
import lawu.chem.pdb.primitives.Continuation;
import lawu.chem.pdb.primitives.IdCode;
import lawu.chem.pdb.primitives.Real;

/**
 * @author Miorel-Lucian Palii
 */
public class Siguij {
//	private lawu.chem.pdb.primitives.Integer serial;
//	private Atom name;
//	private lawu.chem.pdb.primitives.Character altLoc;
//	private Residue name resName;
//	private lawu.chem.pdb.primitives.Character chainID;
//	private lawu.chem.pdb.primitives.Integer resSeq;
//	private AChar iCode;
//	private lawu.chem.pdb.primitives.Integer sig[1][1];
//	private lawu.chem.pdb.primitives.Integer sig[2][2];
//	private lawu.chem.pdb.primitives.Integer sig[3][3];
//	private lawu.chem.pdb.primitives.Integer sig[1][2];
//	private lawu.chem.pdb.primitives.Integer sig[1][3];
//	private lawu.chem.pdb.primitives.Integer sig[2][3];
//	private LString(2) element;
//	private LString(2) charge;

	private final static Pattern pattern = Pattern.compile("SIGUIJ(.{5}) (.{4})(.)(...) (.)(.{4})(.) (.{7})(.{7})(.{7})(.{7})(.{7})(.{7}) {6}(..)(..)"); //$NON-NLS-1$
	private final static String format = "SIGUIJ%5s %4s%1s%3s %1s%4s%1s %7s%7s%7s%7s%7s%7s      %2s%2s"; //$NON-NLS-1$

	public Siguij(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		serial = new lawu.chem.pdb.primitives.Integer(m.group(1));
		// name = new Atom(m.group(2));
		altLoc = new lawu.chem.pdb.primitives.Character(m.group(3));
		// resName = new Residue name(m.group(4));
		chainID = new lawu.chem.pdb.primitives.Character(m.group(5));
		resSeq = new lawu.chem.pdb.primitives.Integer(m.group(6));
		iCode = new AChar(m.group(7));
		sig[1][1] = new lawu.chem.pdb.primitives.Integer(m.group(8));
		sig[2][2] = new lawu.chem.pdb.primitives.Integer(m.group(9));
		sig[3][3] = new lawu.chem.pdb.primitives.Integer(m.group(10));
		sig[1][2] = new lawu.chem.pdb.primitives.Integer(m.group(11));
		sig[1][3] = new lawu.chem.pdb.primitives.Integer(m.group(12));
		sig[2][3] = new lawu.chem.pdb.primitives.Integer(m.group(13));
		// element = new LString(2)(m.group(14));
		// charge = new LString(2)(m.group(15));
	}

	/**
	 * Atom serial number.
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
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
//	public lawu.chem.pdb.primitives.Character altLoc() {
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
//	public lawu.chem.pdb.primitives.Character chainID() {
//		return chainID;
//	}

	/**
	 * Residue sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer resSeq() {
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
//	public lawu.chem.pdb.primitives.Integer sig[1][1]() {
//		return sig[1][1];
//	}

	/**
	 * Sigma U(2,2)
	 */
//	public lawu.chem.pdb.primitives.Integer sig[2][2]() {
//		return sig[2][2];
//	}

	/**
	 * Sigma U(3,3)
	 */
//	public lawu.chem.pdb.primitives.Integer sig[3][3]() {
//		return sig[3][3];
//	}

	/**
	 * Sigma U(1,2)
	 */
//	public lawu.chem.pdb.primitives.Integer sig[1][2]() {
//		return sig[1][2];
//	}

	/**
	 * Sigma U(1,3)
	 */
//	public lawu.chem.pdb.primitives.Integer sig[1][3]() {
//		return sig[1][3];
//	}

	/**
	 * Sigma U(2,3)
	 */
//	public lawu.chem.pdb.primitives.Integer sig[2][3]() {
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