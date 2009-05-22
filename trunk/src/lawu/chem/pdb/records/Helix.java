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
public class Helix {
	private lawu.chem.pdb.primitives.Integer serNum;
	private LString helixID;
	private ResidueName initResName;
	private lawu.chem.pdb.primitives.Character initChainID;
	private lawu.chem.pdb.primitives.Integer initSeqNum;
	private AChar initICode;
	private ResidueName endResName;
	private lawu.chem.pdb.primitives.Character endChainID;
	private lawu.chem.pdb.primitives.Integer endSeqNum;
	private AChar endICode;
	private lawu.chem.pdb.primitives.Integer helixClass;
	private lawu.chem.pdb.primitives.String comment;
	private lawu.chem.pdb.primitives.Integer length;

	private final static Pattern pattern = Pattern.compile("HELIX  (...) (...) (...) (.) (.{4})(.) (...) (.) (.{4})(.)(..)(.{30}) (.{5}) {4}"); //$NON-NLS-1$
	private final static String format = "HELIX  %3s %3s %3s %1s %4s%1s %3s %1s %4s%1s%2s%30s %5s    "; //$NON-NLS-1$

	public Helix(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		serNum = new lawu.chem.pdb.primitives.Integer(m.group(1));
		helixID = new LString(m.group(2), 3);
		// initResName = new ResidueName(m.group(3));
		initChainID = new lawu.chem.pdb.primitives.Character(m.group(4));
		initSeqNum = new lawu.chem.pdb.primitives.Integer(m.group(5));
		initICode = new AChar(m.group(6));
		// endResName = new ResidueName(m.group(7));
		endChainID = new lawu.chem.pdb.primitives.Character(m.group(8));
		endSeqNum = new lawu.chem.pdb.primitives.Integer(m.group(9));
		endICode = new AChar(m.group(10));
		helixClass = new lawu.chem.pdb.primitives.Integer(m.group(11));
		comment = new lawu.chem.pdb.primitives.String(m.group(12));
		length = new lawu.chem.pdb.primitives.Integer(m.group(13));
	}

	/**
	 *  Serial number of the helix. This starts at 1 and increases incrementally.
	 */
//	public lawu.chem.pdb.primitives.Integer serNum() {
//		return serNum;
//	}

	/**
	 *  Helix identifier. In addition to a serial number, each helix is given an alphanumeric character helix identifier.
	 */
//	public LString(3) helixID() {
//		return helixID;
//	}

	/**
	 *  Name of the initial residue.
	 */
//	public ResidueName initResName() {
//		return initResName;
//	}

	/**
	 *  Chain identifier for the chain containing this helix.
	 */
//	public lawu.chem.pdb.primitives.Character initChainID() {
//		return initChainID;
//	}

	/**
	 *  Sequence number of the initial residue.
	 */
//	public lawu.chem.pdb.primitives.Integer initSeqNum() {
//		return initSeqNum;
//	}

	/**
	 *  Insertion code of the initial residue.
	 */
//	public AChar initICode() {
//		return initICode;
//	}

	/**
	 *  Name of the terminal residue of the helix.
	 */
//	public ResidueName endResName() {
//		return endResName;
//	}

	/**
	 *  Chain identifier for the chain containing this helix.
	 */
//	public lawu.chem.pdb.primitives.Character endChainID() {
//		return endChainID;
//	}

	/**
	 *  Sequence number of the terminal residue.
	 */
//	public lawu.chem.pdb.primitives.Integer endSeqNum() {
//		return endSeqNum;
//	}

	/**
	 *  Insertion code of the terminal residue.
	 */
//	public AChar endICode() {
//		return endICode;
//	}

	/**
	 *  Helix class (see below).
	 */
//	public lawu.chem.pdb.primitives.Integer helixClass() {
//		return helixClass;
//	}

	/**
	 *  Comment about this helix.
	 */
//	public lawu.chem.pdb.primitives.String comment() {
//		return comment;
//	}

	/**
	 *  Length of this helix.
	 */
//	public lawu.chem.pdb.primitives.Integer length() {
//		return length;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Helix) {
			Helix r = (Helix) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
