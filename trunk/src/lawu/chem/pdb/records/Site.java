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
public class Site {
//	private lawu.chem.pdb.primitives.Integer seqNum      Seque;
//	private LString(3) siteID      Site;
//	private lawu.chem.pdb.primitives.Integer numRes      Numbe;
//	private Residue name resName1    Resid;
//	private lawu.chem.pdb.primitives.Character chainID1    Chain;
//	private lawu.chem.pdb.primitives.Integer seq1        Resid;
//	private AChar iCode1      Inser;
//	private Residue name resName2    Resid;
//	private lawu.chem.pdb.primitives.Character chainID2    Chain;
//	private lawu.chem.pdb.primitives.Integer seq2        Resid;
//	private AChar iCode2      Inser;
//	private Residue name resName3    Resid;
//	private lawu.chem.pdb.primitives.Character chainID3    Chain;
//	private lawu.chem.pdb.primitives.Integer seq3        Resid;
//	private AChar iCode3      Inser;
//	private Residue name resName4    Resid;
//	private lawu.chem.pdb.primitives.Character chainID4    Chain;
//	private lawu.chem.pdb.primitives.Integer seq4        Resid;
//	private AChar iCode4      Inser;

	private final static Pattern pattern = Pattern.compile("SITE   (...) (...) (..) (...) (.)(.{4})(.) (...) (.)(.{4})(.) (...) (.)(.{4})(.) (...) (.)(.{4})(.) {19}"); //$NON-NLS-1$
	private final static String format = "SITE   %3s %3s %2s %3s %1s%4s%1s %3s %1s%4s%1s %3s %1s%4s%1s %3s %1s%4s%1s                   "; //$NON-NLS-1$

	public Site(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		seqNum      Seque = new lawu.chem.pdb.primitives.Integer(m.group(1));
		// siteID      Site = new LString(3)(m.group(2));
		numRes      Numbe = new lawu.chem.pdb.primitives.Integer(m.group(3));
		// resName1    Resid = new Residue name(m.group(4));
		chainID1    Chain = new lawu.chem.pdb.primitives.Character(m.group(5));
		seq1        Resid = new lawu.chem.pdb.primitives.Integer(m.group(6));
		iCode1      Inser = new AChar(m.group(7));
		// resName2    Resid = new Residue name(m.group(8));
		chainID2    Chain = new lawu.chem.pdb.primitives.Character(m.group(9));
		seq2        Resid = new lawu.chem.pdb.primitives.Integer(m.group(10));
		iCode2      Inser = new AChar(m.group(11));
		// resName3    Resid = new Residue name(m.group(12));
		chainID3    Chain = new lawu.chem.pdb.primitives.Character(m.group(13));
		seq3        Resid = new lawu.chem.pdb.primitives.Integer(m.group(14));
		iCode3      Inser = new AChar(m.group(15));
		// resName4    Resid = new Residue name(m.group(16));
		chainID4    Chain = new lawu.chem.pdb.primitives.Character(m.group(17));
		seq4        Resid = new lawu.chem.pdb.primitives.Integer(m.group(18));
		iCode4      Inser = new AChar(m.group(19));
	}

	/**
	 * nce number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum      Seque() {
//		return seqNum      Seque;
//	}

	/**
	 * name.
	 */
//	public LString(3) siteID      Site() {
//		return siteID      Site;
//	}

	/**
	 * r of residues comprising
	 */
//	public lawu.chem.pdb.primitives.Integer numRes      Numbe() {
//		return numRes      Numbe;
//	}

	/**
	 * ue name for first residue ising site.
	 */
//	public Residue name resName1    Resid() {
//		return resName1    Resid;
//	}

	/**
	 *  identifier for first residue ising site.
	 */
//	public lawu.chem.pdb.primitives.Character chainID1    Chain() {
//		return chainID1    Chain;
//	}

	/**
	 * ue sequence number for first ue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer seq1        Resid() {
//		return seq1        Resid;
//	}

	/**
	 * tion code for first residue ising site.
	 */
//	public AChar iCode1      Inser() {
//		return iCode1      Inser;
//	}

	/**
	 * ue name for second residue ising site.
	 */
//	public Residue name resName2    Resid() {
//		return resName2    Resid;
//	}

	/**
	 *  identifier for second ue ising site.
	 */
//	public lawu.chem.pdb.primitives.Character chainID2    Chain() {
//		return chainID2    Chain;
//	}

	/**
	 * ue sequence number for second ue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer seq2        Resid() {
//		return seq2        Resid;
//	}

	/**
	 * tion code for second residue ising site.
	 */
//	public AChar iCode2      Inser() {
//		return iCode2      Inser;
//	}

	/**
	 * ue name for third residue ising site.
	 */
//	public Residue name resName3    Resid() {
//		return resName3    Resid;
//	}

	/**
	 *  identifier for third residue ising site.
	 */
//	public lawu.chem.pdb.primitives.Character chainID3    Chain() {
//		return chainID3    Chain;
//	}

	/**
	 * ue sequence number for third ue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer seq3        Resid() {
//		return seq3        Resid;
//	}

	/**
	 * tion code for third residue ising site.
	 */
//	public AChar iCode3      Inser() {
//		return iCode3      Inser;
//	}

	/**
	 * ue name for fourth residue ising site.
	 */
//	public Residue name resName4    Resid() {
//		return resName4    Resid;
//	}

	/**
	 *  identifier for fourth ue ising site.
	 */
//	public lawu.chem.pdb.primitives.Character chainID4    Chain() {
//		return chainID4    Chain;
//	}

	/**
	 * ue sequence number for fourth ue comprising site.
	 */
//	public lawu.chem.pdb.primitives.Integer seq4        Resid() {
//		return seq4        Resid;
//	}

	/**
	 * tion code for fourth residue ising site.
	 */
//	public AChar iCode4      Inser() {
//		return iCode4      Inser;
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
