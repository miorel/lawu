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
import lawu.chem.pdb.primitives.Date;
import lawu.chem.pdb.primitives.IdCode;
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;
import lawu.chem.pdb.primitives.ResidueName;
import lawu.chem.pdb.primitives.SymOp;

/**
 * @author Miorel-Lucian Palii
 */
public class Het {
	private LString hetID;
	private lawu.chem.pdb.primitives.Character ChainID;
	private lawu.chem.pdb.primitives.Integer seqNum;
	private AChar iCode;
	private lawu.chem.pdb.primitives.Integer numHetAtoms;
	private lawu.chem.pdb.primitives.String text;

	private final static Pattern pattern = Pattern.compile("HET {4}(...)  (.)(.{4})(.)  (.{5}) {5}(.{40}) {10}"); //$NON-NLS-1$
	private final static String format = "HET    %3s  %1s%4s%1s  %5s     %40s          "; //$NON-NLS-1$

	public Het(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		hetID = new LString(m.group(1), 3);
		ChainID = new lawu.chem.pdb.primitives.Character(m.group(2));
		seqNum = new lawu.chem.pdb.primitives.Integer(m.group(3));
		iCode = new AChar(m.group(4));
		numHetAtoms = new lawu.chem.pdb.primitives.Integer(m.group(5));
		text = new lawu.chem.pdb.primitives.String(m.group(6));
	}

	/**
	 *  Het identifier, right-justified.
	 */
//	public LString(3) hetID() {
//		return hetID;
//	}

	/**
	 *  Chain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character ChainID() {
//		return ChainID;
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
	 *  Number of HETATM records for the group present in the entry.
	 */
//	public lawu.chem.pdb.primitives.Integer numHetAtoms() {
//		return numHetAtoms;
//	}

	/**
	 *  Text describing Het group.
	 */
//	public lawu.chem.pdb.primitives.String text() {
//		return text;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Het) {
			Het r = (Het) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
