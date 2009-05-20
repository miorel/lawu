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

public class Sheet {
//	private Integer strand       Str;
//	private LString(3) sheetID      She;
//	private Integer numStrands   Num;
//	private Residue name initResName  Res;
//	private Character initChainID  Cha;
//	private Integer initSeqNum   Seq;
//	private AChar initICode    Ins;
//	private Residue name endResName   Res;
//	private Character endChainID   Cha;
//	private Integer endSeqNum    Seq;
//	private AChar endICode     Ins;
//	private Integer sense        Sen;
//	private Atom curAtom      Reg;
//	private Residue name curResName   Reg;
//	private Character curChainId   Reg;
//	private Integer curResSeq    Reg;
//	private AChar curICode     Reg;
//	private Atom prevAtom     Reg;
//	private Residue name prevResName  Reg;
//	private Character prevChainId  Reg;
//	private Integer prevResSeq   Reg;
//	private AChar prevICode    Reg;

	private final static Pattern pattern = Pattern.compile("\\ASHEET \\Z"); //$NON-NLS-1$
	private final static String format = "SHEET "; //$NON-NLS-1$

	public Sheet(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * and number which starts at 1 each strand within a sheet increases by one.
	 */
//	public Integer strand       Str() {
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
//	public Integer numStrands   Num() {
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
//	public Character initChainID  Cha() {
//		return initChainID  Cha;
//	}

	/**
	 * uence number of initial idue in strand.
	 */
//	public Integer initSeqNum   Seq() {
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
//	public Character endChainID   Cha() {
//		return endChainID   Cha;
//	}

	/**
	 * uence number of terminal idue.
	 */
//	public Integer endSeqNum    Seq() {
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
//	public Integer sense        Sen() {
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
//	public Character curChainId   Reg() {
//		return curChainId   Reg;
//	}

	/**
	 * istration. Residue sequence ber in current strand.
	 */
//	public Integer curResSeq    Reg() {
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
//	public Character prevChainId  Reg() {
//		return prevChainId  Reg;
//	}

	/**
	 * istration. Residue sequence ber in previous strand.
	 */
//	public Integer prevResSeq   Reg() {
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
