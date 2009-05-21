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
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;

/**
 * @author Miorel-Lucian Palii
 */
public class Dbref {
	private IDcode idCode;
	private lawu.chem.pdb.primitives.Character chainID;
	private lawu.chem.pdb.primitives.Integer seqBegin;
	private AChar insertBegin;
	private lawu.chem.pdb.primitives.Integer seqEnd;
	private AChar insertEnd;
	private LString database;
	private LString dbAccession;
	private String d bIdCode;
	private nteger d bseqBegin;
	private Char i dbnsBeg;
	private nteger d bseqEnd;
	private Char d binsEnd;

	private final static Pattern pattern = Pattern.compile("DBREF  (.{4}) (.) (.{4})(.) (.{4})(.) (.{6}) (.{8}) (.{12}) (.{5})(.) (.{5})(.) {12}"); //$NON-NLS-1$
	private final static String format = "DBREF  %4s %1s %4s%1s %4s%1s %6s %8s %12s %5s%1s %5s%1s            "; //$NON-NLS-1$

	public Dbref(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		idCode = new IdCode(m.group(1));
		chainID = new lawu.chem.pdb.primitives.Character(m.group(2));
		seqBegin = new lawu.chem.pdb.primitives.Integer(m.group(3));
		insertBegin = new AChar(m.group(4));
		seqEnd = new lawu.chem.pdb.primitives.Integer(m.group(5));
		insertEnd = new AChar(m.group(6));
		database = new LString(m.group(7));
		dbAccession = new LString(m.group(8));
		// bIdCode = new String d(m.group(9));
		// bseqBegin = new nteger d(m.group(10));
		// dbnsBeg = new Char i(m.group(11));
		// bseqEnd = new nteger d(m.group(12));
		// binsEnd = new Char d(m.group(13));
	}

	/**
	 * ID code of this entry.
	 */
//	public IDcode idCode() {
//		return idCode;
//	}

	/**
	 * Chain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID() {
//		return chainID;
//	}

	/**
	 * Initial sequence number of the PDB sequence segment.
	 */
//	public lawu.chem.pdb.primitives.Integer seqBegin() {
//		return seqBegin;
//	}

	/**
	 * Initial insertion code of the PDB sequence segment.
	 */
//	public AChar insertBegin() {
//		return insertBegin;
//	}

	/**
	 * Ending sequence number of the PDB sequence segment.
	 */
//	public lawu.chem.pdb.primitives.Integer seqEnd() {
//		return seqEnd;
//	}

	/**
	 * Ending insertion code of the PDB sequence segment.
	 */
//	public AChar insertEnd() {
//		return insertEnd;
//	}

	/**
	 * Sequence database name.
	 */
//	public LString database() {
//		return database;
//	}

	/**
	 * Sequence database accession code.
	 */
//	public LString dbAccession() {
//		return dbAccession;
//	}

	/**
	 * Sequence database identification code.
	 */
//	public String d bIdCode() {
//		return bIdCode;
//	}

	/**
	 * Initial sequence number of the database seqment.
	 */
//	public nteger d bseqBegin() {
//		return bseqBegin;
//	}

	/**
	 * Insertion code of initial residue of the segment, if PDB is the reference.
	 */
//	public Char i dbnsBeg() {
//		return dbnsBeg;
//	}

	/**
	 * Ending sequence number of the database segment.
	 */
//	public nteger d bseqEnd() {
//		return bseqEnd;
//	}

	/**
	 * Insertion code of the ending residue of the segment, if PDB is the reference.
	 */
//	public Char d binsEnd() {
//		return binsEnd;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Dbref) {
			Dbref r = (Dbref) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
