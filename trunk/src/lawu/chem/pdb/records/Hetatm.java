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
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;

/**
 * @author Miorel-Lucian Palii
 */
public class Hetatm {
	private lawu.chem.pdb.primitives.Integer serial;
	private Atom name;
	private lawu.chem.pdb.primitives.Character altLoc;
	private Residue name resName;
	private lawu.chem.pdb.primitives.Character chainID;
	private lawu.chem.pdb.primitives.Integer resSeq;
	private AChar iCode;
	private Real x;
	private Real y;
	private Real z;
	private Real occupancy;
	private Real tempFactor;
	private LString element;
	private LString charge;

	private final static Pattern pattern = Pattern.compile("HETATM(.{5}) (.{4})(.)(...) (.)(.{4})(.)   (.{8})(.{8})(.{8})(.{6})(.{6}) {10}(..)(..)"); //$NON-NLS-1$
	private final static String format = "HETATM%5s %4s%1s%3s %1s%4s%1s   %8s%8s%8s%6s%6s          %2s%2s"; //$NON-NLS-1$

	public Hetatm(String record) {
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
		x = new Real(m.group(8), 8, 3);
		y = new Real(m.group(9), 8, 3);
		z = new Real(m.group(10), 8, 3);
		occupancy = new Real(m.group(11), 6, 2);
		tempFactor = new Real(m.group(12), 6, 2);
		element = new LString(m.group(13), 2);
		charge = new LString(m.group(14), 2);
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
	 * Code for insertion of residues.
	 */
//	public AChar iCode() {
//		return iCode;
//	}

	/**
	 * Orthogonal coordinates for X.
	 */
//	public Real(8.3) x() {
//		return x;
//	}

	/**
	 * Orthogonal coordinates for Y.
	 */
//	public Real(8.3) y() {
//		return y;
//	}

	/**
	 * Orthogonal coordinates for Z.
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
	 * Element symbol; right-justified.
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
		if(o instanceof Hetatm) {
			Hetatm r = (Hetatm) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
