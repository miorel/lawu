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
public class Anisou {
	private lawu.chem.pdb.primitives.Integer serial;
	private AtomName name;
	private lawu.chem.pdb.primitives.Character altLoc;
	private ResidueName resName;
	private lawu.chem.pdb.primitives.Character chainID;
	private lawu.chem.pdb.primitives.Integer resSeq;
	private AChar iCode;
	private lawu.chem.pdb.primitives.Integer u00;
	private lawu.chem.pdb.primitives.Integer u11;
	private lawu.chem.pdb.primitives.Integer u22;
	private lawu.chem.pdb.primitives.Integer u01;
	private lawu.chem.pdb.primitives.Integer u02;
	private lawu.chem.pdb.primitives.Integer u12;
	private LString element;
	private LString charge;

	private final static Pattern pattern = Pattern.compile("ANISOU(.{5}) (.{4})(.)(...) (.)(.{4})(.) (.{7})(.{7})(.{7})(.{7})(.{7})(.{7}) {6}(..)(..)"); //$NON-NLS-1$
	private final static String format = "ANISOU%5s %4s%1s%3s %1s%4s%1s %7s%7s%7s%7s%7s%7s      %2s%2s"; //$NON-NLS-1$

	public Anisou(String record) {
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
		this.u00 = new lawu.chem.pdb.primitives.Integer(m.group(8));
		this.u11 = new lawu.chem.pdb.primitives.Integer(m.group(9));
		this.u22 = new lawu.chem.pdb.primitives.Integer(m.group(10));
		this.u01 = new lawu.chem.pdb.primitives.Integer(m.group(11));
		this.u02 = new lawu.chem.pdb.primitives.Integer(m.group(12));
		this.u12 = new lawu.chem.pdb.primitives.Integer(m.group(13));
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
	 *  Alternate location indicator
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
	 *  U(1,1)
	 */
//	public lawu.chem.pdb.primitives.Integer u00() {
//		return u00;
//	}

	/**
	 *  U(2,2)
	 */
//	public lawu.chem.pdb.primitives.Integer u11() {
//		return u11;
//	}

	/**
	 *  U(3,3)
	 */
//	public lawu.chem.pdb.primitives.Integer u22() {
//		return u22;
//	}

	/**
	 *  U(1,2)
	 */
//	public lawu.chem.pdb.primitives.Integer u01() {
//		return u01;
//	}

	/**
	 *  U(1,3)
	 */
//	public lawu.chem.pdb.primitives.Integer u02() {
//		return u02;
//	}

	/**
	 *  U(2,3)
	 */
//	public lawu.chem.pdb.primitives.Integer u12() {
//		return u12;
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
		if(o instanceof Anisou) {
			Anisou r = (Anisou) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
