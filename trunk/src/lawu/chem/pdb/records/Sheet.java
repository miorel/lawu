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
public class Sheet {
	private lawu.chem.pdb.primitives.Integer strand;
	private LString sheetID;
	private lawu.chem.pdb.primitives.Integer numStrands;
	private ResidueName initResName;
	private lawu.chem.pdb.primitives.Character initChainID;
	private lawu.chem.pdb.primitives.Integer initSeqNum;
	private AChar initICode;
	private ResidueName endResName;
	private lawu.chem.pdb.primitives.Character endChainID;
	private lawu.chem.pdb.primitives.Integer endSeqNum;
	private AChar endICode;
	private lawu.chem.pdb.primitives.Integer sense;
	private AtomName curAtom;
	private ResidueName curResName;
	private lawu.chem.pdb.primitives.Character curChainId;
	private lawu.chem.pdb.primitives.Integer curResSeq;
	private AChar curICode;
	private AtomName prevAtom;
	private ResidueName prevResName;
	private lawu.chem.pdb.primitives.Character prevChainId;
	private lawu.chem.pdb.primitives.Integer prevResSeq;
	private AChar prevICode;

	private final static Pattern pattern = Pattern.compile("SHEET  (...) (...)(..) (...) (.)(.{4})(.) (...) (.)(.{4})(.)(..) (.{4})(...) (.)(.{4})(.) (.{4})(...) (.)(.{4})(.) {10}"); //$NON-NLS-1$
	private final static String format = "SHEET  %3s %3s%2s %3s %1s%4s%1s %3s %1s%4s%1s%2s %4s%3s %1s%4s%1s %4s%3s %1s%4s%1s          "; //$NON-NLS-1$

	public Sheet(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		strand = new lawu.chem.pdb.primitives.Integer(m.group(1));
		sheetID = new LString(m.group(2), 3);
		numStrands = new lawu.chem.pdb.primitives.Integer(m.group(3));
		// initResName = new ResidueName(m.group(4));
		initChainID = new lawu.chem.pdb.primitives.Character(m.group(5));
		initSeqNum = new lawu.chem.pdb.primitives.Integer(m.group(6));
		initICode = new AChar(m.group(7));
		// endResName = new ResidueName(m.group(8));
		endChainID = new lawu.chem.pdb.primitives.Character(m.group(9));
		endSeqNum = new lawu.chem.pdb.primitives.Integer(m.group(10));
		endICode = new AChar(m.group(11));
		sense = new lawu.chem.pdb.primitives.Integer(m.group(12));
		curAtom = new AtomName(m.group(13));
		// curResName = new ResidueName(m.group(14));
		curChainId = new lawu.chem.pdb.primitives.Character(m.group(15));
		curResSeq = new lawu.chem.pdb.primitives.Integer(m.group(16));
		curICode = new AChar(m.group(17));
		prevAtom = new AtomName(m.group(18));
		// prevResName = new ResidueName(m.group(19));
		prevChainId = new lawu.chem.pdb.primitives.Character(m.group(20));
		prevResSeq = new lawu.chem.pdb.primitives.Integer(m.group(21));
		prevICode = new AChar(m.group(22));
	}

	/**
	 *  Strand number which starts at 1 for each strand within a sheet and increases by one.
	 */
//	public lawu.chem.pdb.primitives.Integer strand() {
//		return strand;
//	}

	/**
	 *  Sheet identifier.
	 */
//	public LString(3) sheetID() {
//		return sheetID;
//	}

	/**
	 *  Number of strands in sheet.
	 */
//	public lawu.chem.pdb.primitives.Integer numStrands() {
//		return numStrands;
//	}

	/**
	 *  Residue name of initial residue.
	 */
//	public ResidueName initResName() {
//		return initResName;
//	}

	/**
	 *  Chain identifier of initial residue in strand.
	 */
//	public lawu.chem.pdb.primitives.Character initChainID() {
//		return initChainID;
//	}

	/**
	 *  Sequence number of initial residue in strand.
	 */
//	public lawu.chem.pdb.primitives.Integer initSeqNum() {
//		return initSeqNum;
//	}

	/**
	 *  Insertion code of initial residue in strand.
	 */
//	public AChar initICode() {
//		return initICode;
//	}

	/**
	 *  Residue name of terminal residue.
	 */
//	public ResidueName endResName() {
//		return endResName;
//	}

	/**
	 *  Chain identifier of terminal residue.
	 */
//	public lawu.chem.pdb.primitives.Character endChainID() {
//		return endChainID;
//	}

	/**
	 *  Sequence number of terminal residue.
	 */
//	public lawu.chem.pdb.primitives.Integer endSeqNum() {
//		return endSeqNum;
//	}

	/**
	 *  Insertion code of terminal residue.
	 */
//	public AChar endICode() {
//		return endICode;
//	}

	/**
	 *  Sense of strand with respect to previous strand in the sheet. 0 if first strand, 1 if parallel, -1 if anti-parallel.
	 */
//	public lawu.chem.pdb.primitives.Integer sense() {
//		return sense;
//	}

	/**
	 *  Registration. Atom name in current strand.
	 */
//	public AtomName curAtom() {
//		return curAtom;
//	}

	/**
	 *  Registration. Residue name in current strand.
	 */
//	public ResidueName curResName() {
//		return curResName;
//	}

	/**
	 *  Registration. Chain identifier in current strand.
	 */
//	public lawu.chem.pdb.primitives.Character curChainId() {
//		return curChainId;
//	}

	/**
	 *  Registration. Residue sequence number in current strand.
	 */
//	public lawu.chem.pdb.primitives.Integer curResSeq() {
//		return curResSeq;
//	}

	/**
	 *  Registration. Insertion code in current strand.
	 */
//	public AChar curICode() {
//		return curICode;
//	}

	/**
	 *  Registration. Atom name in previous strand.
	 */
//	public AtomName prevAtom() {
//		return prevAtom;
//	}

	/**
	 *  Registration. Residue name in previous strand.
	 */
//	public ResidueName prevResName() {
//		return prevResName;
//	}

	/**
	 *  Registration. Chain identifier in previous strand.
	 */
//	public lawu.chem.pdb.primitives.Character prevChainId() {
//		return prevChainId;
//	}

	/**
	 *  Registration. Residue sequence number in previous strand.
	 */
//	public lawu.chem.pdb.primitives.Integer prevResSeq() {
//		return prevResSeq;
//	}

	/**
	 *  Registration. Insertion code in previous strand.
	 */
//	public AChar prevICode() {
//		return prevICode;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Sheet) {
			Sheet r = (Sheet) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
