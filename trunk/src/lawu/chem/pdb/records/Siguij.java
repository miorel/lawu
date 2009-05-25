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
public class Siguij {
	private lawu.chem.pdb.primitives.Integer serial;
	private AtomName name;
	private lawu.chem.pdb.primitives.Character altLoc;
	private ResidueName resName;
	private lawu.chem.pdb.primitives.Character chainID;
	private lawu.chem.pdb.primitives.Integer resSeq;
	private AChar iCode;
	private lawu.chem.pdb.primitives.Integer sig11;
	private lawu.chem.pdb.primitives.Integer sig22;
	private lawu.chem.pdb.primitives.Integer sig33;
	private lawu.chem.pdb.primitives.Integer sig12;
	private lawu.chem.pdb.primitives.Integer sig13;
	private lawu.chem.pdb.primitives.Integer sig23;
	private LString element;
	private LString charge;

	private final static Pattern pattern = Pattern.compile("SIGUIJ(.{5}) (.{4})(.)(...) (.)(.{4})(.) (.{7})(.{7})(.{7})(.{7})(.{7})(.{7}) {6}(..)(..)"); //$NON-NLS-1$
	private final static String format = "SIGUIJ%5s %4s%1s%3s %1s%4s%1s %7s%7s%7s%7s%7s%7s      %2s%2s"; //$NON-NLS-1$

	public Siguij(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		this.serial = new lawu.chem.pdb.primitives.Integer(m.group(1));
		this.name = new AtomName(m.group(2));
		this.altLoc = new lawu.chem.pdb.primitives.Character(m.group(3));
		this.resName = new ResidueName(m.group(4));
		this.chainID = new lawu.chem.pdb.primitives.Character(m.group(5));
		this.resSeq = new lawu.chem.pdb.primitives.Integer(m.group(6));
		this.iCode = new AChar(m.group(7));
		this.sig11 = new lawu.chem.pdb.primitives.Integer(m.group(8));
		this.sig22 = new lawu.chem.pdb.primitives.Integer(m.group(9));
		this.sig33 = new lawu.chem.pdb.primitives.Integer(m.group(10));
		this.sig12 = new lawu.chem.pdb.primitives.Integer(m.group(11));
		this.sig13 = new lawu.chem.pdb.primitives.Integer(m.group(12));
		this.sig23 = new lawu.chem.pdb.primitives.Integer(m.group(13));
		this.element = new LString(m.group(14), 2);
		this.charge = new LString(m.group(15), 2);
	}

	/**
	 *  Atom serial number.
	 */
//	public lawu.chem.pdb.primitives.Integer serial() {
//		return serial;
//	}

	/**
	 *  Atom name.
	 */
//	public AtomName name() {
//		return name;
//	}

	/**
	 *  Alternate location indicator.
	 */
//	public lawu.chem.pdb.primitives.Character altLoc() {
//		return altLoc;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Chain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID() {
//		return chainID;
//	}

	/**
	 *  Residue sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer resSeq() {
//		return resSeq;
//	}

	/**
	 *  Insertion code.
	 */
//	public AChar iCode() {
//		return iCode;
//	}

	/**
	 *  Sigma U(1,1)
	 */
//	public lawu.chem.pdb.primitives.Integer sig11() {
//		return sig11;
//	}

	/**
	 *  Sigma U(2,2)
	 */
//	public lawu.chem.pdb.primitives.Integer sig22() {
//		return sig22;
//	}

	/**
	 *  Sigma U(3,3)
	 */
//	public lawu.chem.pdb.primitives.Integer sig33() {
//		return sig33;
//	}

	/**
	 *  Sigma U(1,2)
	 */
//	public lawu.chem.pdb.primitives.Integer sig12() {
//		return sig12;
//	}

	/**
	 *  Sigma U(1,3)
	 */
//	public lawu.chem.pdb.primitives.Integer sig13() {
//		return sig13;
//	}

	/**
	 *  Sigma U(2,3)
	 */
//	public lawu.chem.pdb.primitives.Integer sig23() {
//		return sig23;
//	}

	/**
	 *  Element symbol, right-justified.
	 */
//	public LString(2) element() {
//		return element;
//	}

	/**
	 *  Charge on the atom.
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
