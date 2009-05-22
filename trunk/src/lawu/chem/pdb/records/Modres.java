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
public class Modres {
	private IdCode idCode;
	private ResidueName resName;
	private lawu.chem.pdb.primitives.Character chainID;
	private lawu.chem.pdb.primitives.Integer seqNum;
	private AChar iCode;
	private ResidueName stdRes;
	private lawu.chem.pdb.primitives.String comment;

	private final static Pattern pattern = Pattern.compile("MODRES (.{4}) (...) (.) (.{4})(.) (...)  (.{41}) {10}"); //$NON-NLS-1$
	private final static String format = "MODRES %4s %3s %1s %4s%1s %3s  %41s          "; //$NON-NLS-1$

	public Modres(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		idCode = new IdCode(m.group(1));
		// resName = new ResidueName(m.group(2));
		chainID = new lawu.chem.pdb.primitives.Character(m.group(3));
		seqNum = new lawu.chem.pdb.primitives.Integer(m.group(4));
		iCode = new AChar(m.group(5));
		// stdRes = new ResidueName(m.group(6));
		comment = new lawu.chem.pdb.primitives.String(m.group(7));
	}

	/**
	 *  ID code of this entry.
	 */
//	public IdCode idCode() {
//		return idCode;
//	}

	/**
	 *  Residue name used in this entry.
	 */
//	public ResidueName resName() {
//		return resName;
//	}

	/**
	 *  Chain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID() {
//		return chainID;
//	}

	/**
	 *  Sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum() {
//		return seqNum;
//	}

	/**
	 *  Insertion code.
	 */
//	public AChar iCode() {
//		return iCode;
//	}

	/**
	 *  Standard residue name.
	 */
//	public ResidueName stdRes() {
//		return stdRes;
//	}

	/**
	 *  Description of the residue modification
	 */
//	public lawu.chem.pdb.primitives.String comment() {
//		return comment;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Modres) {
			Modres r = (Modres) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
