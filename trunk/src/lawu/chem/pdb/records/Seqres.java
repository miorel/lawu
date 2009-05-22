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
public class Seqres {
	private lawu.chem.pdb.primitives.Integer serNum;
	private lawu.chem.pdb.primitives.Character chainID;
	private lawu.chem.pdb.primitives.Integer numRes;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;
	private ResidueName resName;

	private final static Pattern pattern = Pattern.compile("SEQRES  (..) (.) (.{4})  (...) (...) (...) (...) (...) (...) (...) (...) (...) (...) (...) (...) (...) {10}"); //$NON-NLS-1$
	private final static String format = "SEQRES  %2s %1s %4s  %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s          "; //$NON-NLS-1$

	public Seqres(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		serNum = new lawu.chem.pdb.primitives.Integer(m.group(1));
		chainID = new lawu.chem.pdb.primitives.Character(m.group(2));
		numRes = new lawu.chem.pdb.primitives.Integer(m.group(3));
		// resName = new ResidueName(m.group(4));
		// resName = new ResidueName(m.group(5));
		// resName = new ResidueName(m.group(6));
		// resName = new ResidueName(m.group(7));
		// resName = new ResidueName(m.group(8));
		// resName = new ResidueName(m.group(9));
		// resName = new ResidueName(m.group(10));
		// resName = new ResidueName(m.group(11));
		// resName = new ResidueName(m.group(12));
		// resName = new ResidueName(m.group(13));
		// resName = new ResidueName(m.group(14));
		// resName = new ResidueName(m.group(15));
		// resName = new ResidueName(m.group(16));
	}

	/**
	 *  Serial number of the SEQRES record for the current chain. Starts at 1 and increments by one each line. Reset to 1 for each chain.
	 */
//	public lawu.chem.pdb.primitives.Integer serNum() {
//		return serNum;
//	}

	/**
	 *  Chain identifier. This may be any single legal character, including a blank which is used if there is only one chain.
	 */
//	public lawu.chem.pdb.primitives.Character chainID() {
//		return chainID;
//	}

	/**
	 *  Number of residues in the chain. This value is repeated on every record.
	 */
//	public lawu.chem.pdb.primitives.Integer numRes() {
//		return numRes;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Residue name.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Seqres) {
			Seqres r = (Seqres) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
