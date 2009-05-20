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

public class Site {
//	private Integer seqNum      Seque;
//	private LString(3) siteID      Site;
//	private Integer numRes      Numbe;
//	private Residue name resName1    Resid;
//	private Character chainID1    Chain;
//	private Integer seq1        Resid;
//	private AChar iCode1      Inser;
//	private Residue name resName2    Resid;
//	private Character chainID2    Chain;
//	private Integer seq2        Resid;
//	private AChar iCode2      Inser;
//	private Residue name resName3    Resid;
//	private Character chainID3    Chain;
//	private Integer seq3        Resid;
//	private AChar iCode3      Inser;
//	private Residue name resName4    Resid;
//	private Character chainID4    Chain;
//	private Integer seq4        Resid;
//	private AChar iCode4      Inser;

	private final static Pattern pattern = Pattern.compile("\\ASITE  \\Z"); //$NON-NLS-1$
	private final static String format = "SITE  "; //$NON-NLS-1$

	public Site(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * nce number.
	 */
//	public Integer seqNum      Seque() {
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
//	public Integer numRes      Numbe() {
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
//	public Character chainID1    Chain() {
//		return chainID1    Chain;
//	}

	/**
	 * ue sequence number for first ue comprising site.
	 */
//	public Integer seq1        Resid() {
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
//	public Character chainID2    Chain() {
//		return chainID2    Chain;
//	}

	/**
	 * ue sequence number for second ue comprising site.
	 */
//	public Integer seq2        Resid() {
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
//	public Character chainID3    Chain() {
//		return chainID3    Chain;
//	}

	/**
	 * ue sequence number for third ue comprising site.
	 */
//	public Integer seq3        Resid() {
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
//	public Character chainID4    Chain() {
//		return chainID4    Chain;
//	}

	/**
	 * ue sequence number for fourth ue comprising site.
	 */
//	public Integer seq4        Resid() {
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
