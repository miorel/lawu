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
public class Site {
	private lawu.chem.pdb.primitives.Integer seqNum;
	private LString siteID;
	private lawu.chem.pdb.primitives.Integer numRes;
	private ResidueName resName1;
	private lawu.chem.pdb.primitives.Character chainID1;
	private lawu.chem.pdb.primitives.Integer seq1;
	private AChar iCode1;
	private ResidueName resName2;
	private lawu.chem.pdb.primitives.Character chainID2;
	private lawu.chem.pdb.primitives.Integer seq2;
	private AChar iCode2;
	private ResidueName resName3;
	private lawu.chem.pdb.primitives.Character chainID3;
	private lawu.chem.pdb.primitives.Integer seq3;
	private AChar iCode3;
	private ResidueName resName4;
	private lawu.chem.pdb.primitives.Character chainID4;
	private lawu.chem.pdb.primitives.Integer seq4;
	private AChar iCode4;

	private final static Pattern pattern = Pattern.compile("SITE   (...) (...) (..) (...) (.)(.{4})(.) (...) (.)(.{4})(.) (...) (.)(.{4})(.) (...) (.)(.{4})(.) {19}"); //$NON-NLS-1$
	private final static String format = "SITE   %3s %3s %2s %3s %1s%4s%1s %3s %1s%4s%1s %3s %1s%4s%1s %3s %1s%4s%1s                   "; //$NON-NLS-1$

	public Site(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		this.seqNum = new lawu.chem.pdb.primitives.Integer(m.group(1));
		this.siteID = new LString(m.group(2), 3);
		this.numRes = new lawu.chem.pdb.primitives.Integer(m.group(3));
		this.resName1 = new ResidueName(m.group(4));
		this.chainID1 = new lawu.chem.pdb.primitives.Character(m.group(5));
		this.seq1 = new lawu.chem.pdb.primitives.Integer(m.group(6));
		this.iCode1 = new AChar(m.group(7));
		this.resName2 = new ResidueName(m.group(8));
		this.chainID2 = new lawu.chem.pdb.primitives.Character(m.group(9));
		this.seq2 = new lawu.chem.pdb.primitives.Integer(m.group(10));
		this.iCode2 = new AChar(m.group(11));
		this.resName3 = new ResidueName(m.group(12));
		this.chainID3 = new lawu.chem.pdb.primitives.Character(m.group(13));
		this.seq3 = new lawu.chem.pdb.primitives.Integer(m.group(14));
		this.iCode3 = new AChar(m.group(15));
		this.resName4 = new ResidueName(m.group(16));
		this.chainID4 = new lawu.chem.pdb.primitives.Character(m.group(17));
		this.seq4 = new lawu.chem.pdb.primitives.Integer(m.group(18));
		this.iCode4 = new AChar(m.group(19));
	}

	/**
	 *  Sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum() {
//		return seqNum;
//	}

	/**
	 *  Site name.
	 */
//	public LString(3) siteID() {
//		return siteID;
//	}

	/**
	 *  Number of residues comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer numRes() {
//		return numRes;
//	}

	/**
	 *  Residue name for first residue comprising site.
	 */
//	public ResidueName resName1() {
//		return resName1;
//	}

	/**
	 *  Chain identifier for first residue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Character chainID1() {
//		return chainID1;
//	}

	/**
	 *  Residue sequence number for first residue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer seq1() {
//		return seq1;
//	}

	/**
	 *  Insertion code for first residue comprising site.
	 */
//	public AChar iCode1() {
//		return iCode1;
//	}

	/**
	 *  Residue name for second residue comprising site.
	 */
//	public ResidueName resName2() {
//		return resName2;
//	}

	/**
	 *  Chain identifier for second residue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Character chainID2() {
//		return chainID2;
//	}

	/**
	 *  Residue sequence number for second residue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer seq2() {
//		return seq2;
//	}

	/**
	 *  Insertion code for second residue comprising site.
	 */
//	public AChar iCode2() {
//		return iCode2;
//	}

	/**
	 *  Residue name for third residue comprising site.
	 */
//	public ResidueName resName3() {
//		return resName3;
//	}

	/**
	 *  Chain identifier for third residue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Character chainID3() {
//		return chainID3;
//	}

	/**
	 *  Residue sequence number for third residue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer seq3() {
//		return seq3;
//	}

	/**
	 *  Insertion code for third residue comprising site.
	 */
//	public AChar iCode3() {
//		return iCode3;
//	}

	/**
	 *  Residue name for fourth residue comprising site.
	 */
//	public ResidueName resName4() {
//		return resName4;
//	}

	/**
	 *  Chain identifier for fourth residue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Character chainID4() {
//		return chainID4;
//	}

	/**
	 *  Residue sequence number for fourth residue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer seq4() {
//		return seq4;
//	}

	/**
	 *  Insertion code for fourth residue comprising site.
	 */
//	public AChar iCode4() {
//		return iCode4;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Site) {
			Site r = (Site) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
