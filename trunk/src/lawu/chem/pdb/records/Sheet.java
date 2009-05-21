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
public class Sheet {
//	private lawu.chem.pdb.primitives.Integer strand       Str;
//	private LString(3) sheetID      She;
//	private lawu.chem.pdb.primitives.Integer numStrands   Num;
//	private Residue name initResName  Res;
//	private lawu.chem.pdb.primitives.Character initChainID  Cha;
//	private lawu.chem.pdb.primitives.Integer initSeqNum   Seq;
//	private AChar initICode    Ins;
//	private Residue name endResName   Res;
//	private lawu.chem.pdb.primitives.Character endChainID   Cha;
//	private lawu.chem.pdb.primitives.Integer endSeqNum    Seq;
//	private AChar endICode     Ins;
//	private lawu.chem.pdb.primitives.Integer sense        Sen;
//	private Atom curAtom      Reg;
//	private Residue name curResName   Reg;
//	private lawu.chem.pdb.primitives.Character curChainId   Reg;
//	private lawu.chem.pdb.primitives.Integer curResSeq    Reg;
//	private AChar curICode     Reg;
//	private Atom prevAtom     Reg;
//	private Residue name prevResName  Reg;
//	private lawu.chem.pdb.primitives.Character prevChainId  Reg;
//	private lawu.chem.pdb.primitives.Integer prevResSeq   Reg;
//	private AChar prevICode    Reg;

	private final static Pattern pattern = Pattern.compile("SHEET  (...) (...)(..) (...) (.)(.{4})(.) (...) (.)(.{4})(.)(..) (.{4})(...) (.)(.{4})(.) (.{4})(...) (.)(.{4})(.) {10}"); //$NON-NLS-1$
	private final static String format = "SHEET  %3s %3s%2s %3s %1s%4s%1s %3s %1s%4s%1s%2s %4s%3s %1s%4s%1s %4s%3s %1s%4s%1s          "; //$NON-NLS-1$

	public Sheet(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		strand       Str = new lawu.chem.pdb.primitives.Integer(m.group(1));
		// sheetID      She = new LString(3)(m.group(2));
		numStrands   Num = new lawu.chem.pdb.primitives.Integer(m.group(3));
		// initResName  Res = new Residue name(m.group(4));
		initChainID  Cha = new lawu.chem.pdb.primitives.Character(m.group(5));
		initSeqNum   Seq = new lawu.chem.pdb.primitives.Integer(m.group(6));
		initICode    Ins = new AChar(m.group(7));
		// endResName   Res = new Residue name(m.group(8));
		endChainID   Cha = new lawu.chem.pdb.primitives.Character(m.group(9));
		endSeqNum    Seq = new lawu.chem.pdb.primitives.Integer(m.group(10));
		endICode     Ins = new AChar(m.group(11));
		sense        Sen = new lawu.chem.pdb.primitives.Integer(m.group(12));
		// curAtom      Reg = new Atom(m.group(13));
		// curResName   Reg = new Residue name(m.group(14));
		curChainId   Reg = new lawu.chem.pdb.primitives.Character(m.group(15));
		curResSeq    Reg = new lawu.chem.pdb.primitives.Integer(m.group(16));
		curICode     Reg = new AChar(m.group(17));
		// prevAtom     Reg = new Atom(m.group(18));
		// prevResName  Reg = new Residue name(m.group(19));
		prevChainId  Reg = new lawu.chem.pdb.primitives.Character(m.group(20));
		prevResSeq   Reg = new lawu.chem.pdb.primitives.Integer(m.group(21));
		prevICode    Reg = new AChar(m.group(22));
	}

	/**
	 * and number which starts at 1 each strand within a sheet increases by one.
	 */
//	public lawu.chem.pdb.primitives.Integer strand       Str() {
//		return strand       Str;
//	}

	/**
	 * et identifier.
	 */
//	public LString(3) sheetID      She() {
//		return sheetID      She;
//	}

	/**
	 * ber of strands in sheet.
	 */
//	public lawu.chem.pdb.primitives.Integer numStrands   Num() {
//		return numStrands   Num;
//	}

	/**
	 * idue name of initial residue.
	 */
//	public Residue name initResName  Res() {
//		return initResName  Res;
//	}

	/**
	 * in identifier of initial idue in strand.
	 */
//	public lawu.chem.pdb.primitives.Character initChainID  Cha() {
//		return initChainID  Cha;
//	}

	/**
	 * uence number of initial idue in strand.
	 */
//	public lawu.chem.pdb.primitives.Integer initSeqNum   Seq() {
//		return initSeqNum   Seq;
//	}

	/**
	 * ertion code of initial residue strand.
	 */
//	public AChar initICode    Ins() {
//		return initICode    Ins;
//	}

	/**
	 * idue name of terminal residue.
	 */
//	public Residue name endResName   Res() {
//		return endResName   Res;
//	}

	/**
	 * in identifier of terminal idue.
	 */
//	public lawu.chem.pdb.primitives.Character endChainID   Cha() {
//		return endChainID   Cha;
//	}

	/**
	 * uence number of terminal idue.
	 */
//	public lawu.chem.pdb.primitives.Integer endSeqNum    Seq() {
//		return endSeqNum    Seq;
//	}

	/**
	 * ertion code of terminal idue.
	 */
//	public AChar endICode     Ins() {
//		return endICode     Ins;
//	}

	/**
	 * se of strand with respect to vious strand in the sheet. 0 first strand, 1 if parallel, if anti-parallel.
	 */
//	public lawu.chem.pdb.primitives.Integer sense        Sen() {
//		return sense        Sen;
//	}

	/**
	 * istration. Atom name in rent strand.
	 */
//	public Atom curAtom      Reg() {
//		return curAtom      Reg;
//	}

	/**
	 * istration. Residue name in rent strand.
	 */
//	public Residue name curResName   Reg() {
//		return curResName   Reg;
//	}

	/**
	 * istration. Chain identifier in rent strand.
	 */
//	public lawu.chem.pdb.primitives.Character curChainId   Reg() {
//		return curChainId   Reg;
//	}

	/**
	 * istration. Residue sequence ber in current strand.
	 */
//	public lawu.chem.pdb.primitives.Integer curResSeq    Reg() {
//		return curResSeq    Reg;
//	}

	/**
	 * istration. Insertion code in rent strand.
	 */
//	public AChar curICode     Reg() {
//		return curICode     Reg;
//	}

	/**
	 * istration. Atom name in vious strand.
	 */
//	public Atom prevAtom     Reg() {
//		return prevAtom     Reg;
//	}

	/**
	 * istration. Residue name in vious strand.
	 */
//	public Residue name prevResName  Reg() {
//		return prevResName  Reg;
//	}

	/**
	 * istration. Chain identifier in vious strand.
	 */
//	public lawu.chem.pdb.primitives.Character prevChainId  Reg() {
//		return prevChainId  Reg;
//	}

	/**
	 * istration. Residue sequence ber in previous strand.
	 */
//	public lawu.chem.pdb.primitives.Integer prevResSeq   Reg() {
//		return prevResSeq   Reg;
//	}

	/**
	 * istration. Insertion code in previous strand.
	 */
//	public AChar prevICode    Reg() {
//		return prevICode    Reg;
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
