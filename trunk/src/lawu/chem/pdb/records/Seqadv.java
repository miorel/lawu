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
public class Seqadv {
	private IdCode idCode;
	private ResidueName resName;
	private lawu.chem.pdb.primitives.Character chainID;
	private lawu.chem.pdb.primitives.Integer seqNum;
	private AChar iCode;
	private LString database;
	private LString dbIdCode;
	private ResidueName dbRes;
	private lawu.chem.pdb.primitives.Integer dbSeq;
	private LString conflict;

	private final static Pattern pattern = Pattern.compile("SEQADV (.{4}) (...) (.) (.{4})(.) (.{4}) (.{9}) (...) (.{5}) (.{21}) {10}"); //$NON-NLS-1$
	private final static String format = "SEQADV %4s %3s %1s %4s%1s %4s %9s %3s %5s %21s          "; //$NON-NLS-1$

	public Seqadv(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		idCode = new IdCode(m.group(1));
		// resName = new ResidueName(m.group(2));
		chainID = new lawu.chem.pdb.primitives.Character(m.group(3));
		seqNum = new lawu.chem.pdb.primitives.Integer(m.group(4));
		iCode = new AChar(m.group(5));
		database = new LString(m.group(6));
		dbIdCode = new LString(m.group(7));
		// dbRes = new ResidueName(m.group(8));
		dbSeq = new lawu.chem.pdb.primitives.Integer(m.group(9));
		conflict = new LString(m.group(10));
	}

	/**
	 *  ID code of this entry.
	 */
//	public IdCode idCode() {
//		return idCode;
//	}

	/**
	 *  Name of the PDB residue in conflict.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  PDB chain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID() {
//		return chainID;
//	}

	/**
	 *  PDB sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum() {
//		return seqNum;
//	}

	/**
	 *  PDB insertion code.
	 */
//	public AChar iCode() {
//		return iCode;
//	}

	/**
	 *  Sequence database accession number.
	 */
//	public LString dbIdCode() {
//		return dbIdCode;
//	}

	/**
	 *  Sequence database residue name.
	 */
//	public ResidueName dbRes() {
//		return dbRes;
//	}

	/**
	 *  Sequence database sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer dbSeq() {
//		return dbSeq;
//	}

	/**
	 *  Conflict comment.
	 */
//	public LString conflict() {
//		return conflict;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Seqadv) {
			Seqadv r = (Seqadv) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
