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
import lawu.chem.pdb.primitives.IdCode;
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;
import lawu.chem.pdb.primitives.ResidueName;
import lawu.chem.pdb.primitives.SymOp;

/**
 * @author Miorel-Lucian Palii
 */
public class Turn {
	private lawu.chem.pdb.primitives.Integer seq;
	private LString turnId;
	private ResidueName initResName;
	private lawu.chem.pdb.primitives.Character initChainId;
	private lawu.chem.pdb.primitives.Integer initSeqNum;
	private AChar initICode;
	private ResidueName endResName;
	private lawu.chem.pdb.primitives.Character endChainId;
	private lawu.chem.pdb.primitives.Integer endSeqNum;
	private AChar endICode;
	private lawu.chem.pdb.primitives.String comment;

	private final static Pattern pattern = Pattern.compile("TURN   (...) (...) (...) (.)(.{4})(.) (...) (.)(.{4})(.) {4}(.{30}) {10}"); //$NON-NLS-1$
	private final static String format = "TURN   %3s %3s %3s %1s%4s%1s %3s %1s%4s%1s    %30s          "; //$NON-NLS-1$

	public Turn(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		seq = new lawu.chem.pdb.primitives.Integer(m.group(1));
		turnId = new LString(m.group(2), 3);
		// initResName = new ResidueName(m.group(3));
		initChainId = new lawu.chem.pdb.primitives.Character(m.group(4));
		initSeqNum = new lawu.chem.pdb.primitives.Integer(m.group(5));
		initICode = new AChar(m.group(6));
		// endResName = new ResidueName(m.group(7));
		endChainId = new lawu.chem.pdb.primitives.Character(m.group(8));
		endSeqNum = new lawu.chem.pdb.primitives.Integer(m.group(9));
		endICode = new AChar(m.group(10));
		comment = new lawu.chem.pdb.primitives.String(m.group(11));
	}

	/**
	 *  Turn number; starts with 1 and increments by one.
	 */
//	public lawu.chem.pdb.primitives.Integer seq() {
//		return seq;
//	}

	/**
	 *  Turn identifier
	 */
//	public LString(3) turnId() {
//		return turnId;
//	}

	/**
	 *  Residue name of initial residue in turn.
	 */
//	public ResidueName initResName() {
//		return initResName;
//	}

	/**
	 *  Chain identifier for the chain containing this turn.
	 */
//	public lawu.chem.pdb.primitives.Character initChainId() {
//		return initChainId;
//	}

	/**
	 *  Sequence number of initial residue in turn.
	 */
//	public lawu.chem.pdb.primitives.Integer initSeqNum() {
//		return initSeqNum;
//	}

	/**
	 *  Insertion code of initial residue in turn.
	 */
//	public AChar initICode() {
//		return initICode;
//	}

	/**
	 *  Residue name of terminal residue of turn.
	 */
//	public ResidueName endResName() {
//		return endResName;
//	}

	/**
	 *  Chain identifier for the chain containing this turn.
	 */
//	public lawu.chem.pdb.primitives.Character endChainId() {
//		return endChainId;
//	}

	/**
	 *  Sequence number of terminal residue of turn.
	 */
//	public lawu.chem.pdb.primitives.Integer endSeqNum() {
//		return endSeqNum;
//	}

	/**
	 *  Insertion code of terminal residue of turn.
	 */
//	public AChar endICode() {
//		return endICode;
//	}

	/**
	 *  Associated comment.
	 */
//	public lawu.chem.pdb.primitives.String comment() {
//		return comment;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Turn) {
			Turn r = (Turn) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
