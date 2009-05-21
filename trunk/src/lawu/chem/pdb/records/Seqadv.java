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
public class Seqadv {
//	private IDcode idCode    I;
//	private Residue name resName   N;
//	private lawu.chem.pdb.primitives.Character chainID   P;
//	private lawu.chem.pdb.primitives.Integer seqNum    P;
//	private AChar iCode     P;
//	private LString database;
//	private LString dbIdCode  S;
//	private Residue name dbRes     S;
//	private lawu.chem.pdb.primitives.Integer dbSeq     S;
//	private LString conflict  C;

	private final static Pattern pattern = Pattern.compile("SEQADV (.{4}) (...) (.) (.{4})(.) (.{4}) (.{9}) (...) (.{5}) (.{21}) {10}"); //$NON-NLS-1$
	private final static String format = "SEQADV %4s %3s %1s %4s%1s %4s %9s %3s %5s %21s          "; //$NON-NLS-1$

	public Seqadv(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		idCode    I = new IdCode(m.group(1));
		// resName   N = new Residue name(m.group(2));
		chainID   P = new lawu.chem.pdb.primitives.Character(m.group(3));
		seqNum    P = new lawu.chem.pdb.primitives.Integer(m.group(4));
		iCode     P = new AChar(m.group(5));
		// database = new LString(m.group(6));
		// dbIdCode  S = new LString(m.group(7));
		// dbRes     S = new Residue name(m.group(8));
		dbSeq     S = new lawu.chem.pdb.primitives.Integer(m.group(9));
		// conflict  C = new LString(m.group(10));
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
//	public lawu.chem.pdb.primitives.Character chainID   P() {
//		return chainID   P;
//	}

	/**
	 * DB sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum    P() {
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
//	public lawu.chem.pdb.primitives.Integer dbSeq     S() {
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
