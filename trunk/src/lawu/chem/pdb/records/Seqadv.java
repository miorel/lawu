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

public class Seqadv {
//	private IDcode idCode    I;
//	private Residue name resName   N;
//	private Character chainID   P;
//	private Integer seqNum    P;
//	private AChar iCode     P;
//	private LString database;
//	private LString dbIdCode  S;
//	private Residue name dbRes     S;
//	private Integer dbSeq     S;
//	private LString conflict  C;

	private final static Pattern pattern = Pattern.compile("\\ASEQADV\\Z"); //$NON-NLS-1$
	private final static String format = "SEQADV"; //$NON-NLS-1$

	public Seqadv(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * D code of this entry.
	 */
//	public IDcode idCode    I() {
//		return idCode    I;
//	}

	/**
	 * ame of the PDB residue in conflict.
	 */
//	public Residue name resName   N() {
//		return resName   N;
//	}

	/**
	 * DB chain identifier.
	 */
//	public Character chainID   P() {
//		return chainID   P;
//	}

	/**
	 * DB sequence number.
	 */
//	public Integer seqNum    P() {
//		return seqNum    P;
//	}

	/**
	 * DB insertion code.
	 */
//	public AChar iCode     P() {
//		return iCode     P;
//	}

	/**
	 * equence database accession number.
	 */
//	public LString dbIdCode  S() {
//		return dbIdCode  S;
//	}

	/**
	 * equence database residue name.
	 */
//	public Residue name dbRes     S() {
//		return dbRes     S;
//	}

	/**
	 * equence database sequence number.
	 */
//	public Integer dbSeq     S() {
//		return dbSeq     S;
//	}

	/**
	 * onflict comment.
	 */
//	public LString conflict  C() {
//		return conflict  C;
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
