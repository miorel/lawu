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
public class Sigatm {
	private lawu.chem.pdb.primitives.Integer serial;
	private AtomName name;
	private lawu.chem.pdb.primitives.Character altLoc;
	private ResidueName resName;
	private lawu.chem.pdb.primitives.Character chainID;
	private lawu.chem.pdb.primitives.Integer resSeq;
	private AChar iCode;
	private Real sigX;
	private Real sigY;
	private Real sigZ;
	private Real sigOcc;
	private Real sigTemp;
	private LString element;
	private LString charge;

	private final static Pattern pattern = Pattern.compile("SIGATM(.{5}) (.{4})(.)(...) (.)(.{4})(.)   (.{8})(.{8})(.{8})(.{6})(.{6}) {10}(..)(..)"); //$NON-NLS-1$
	private final static String format = "SIGATM%5s %4s%1s%3s %1s%4s%1s   %8s%8s%8s%6s%6s          %2s%2s"; //$NON-NLS-1$

	public Sigatm(String record) {
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
		this.sigX = new Real(m.group(8), 8, 3);
		this.sigY = new Real(m.group(9), 8, 3);
		this.sigZ = new Real(m.group(10), 8, 3);
		this.sigOcc = new Real(m.group(11), 6, 2);
		this.sigTemp = new Real(m.group(12), 6, 2);
		this.element = new LString(m.group(13), 2);
		this.charge = new LString(m.group(14), 2);
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
	 *  Standard deviations of the stored coordinates (Angstroms).
	 */
//	public Real(8.3) sigX() {
//		return sigX;
//	}

	/**
	 *  Standard deviations of the stored coordinates (Angstroms).
	 */
//	public Real(8.3) sigY() {
//		return sigY;
//	}

	/**
	 *  Standard deviations of the stored coordinates (Angstroms).
	 */
//	public Real(8.3) sigZ() {
//		return sigZ;
//	}

	/**
	 *  Standard deviation of occupancy.
	 */
//	public Real(6.2) sigOcc() {
//		return sigOcc;
//	}

	/**
	 *  Standard deviation of temperature factor.
	 */
//	public Real(6.2) sigTemp() {
//		return sigTemp;
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
		if(o instanceof Sigatm) {
			Sigatm r = (Sigatm) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
