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
public class Ssbond {
	private lawu.chem.pdb.primitives.Integer serNum;
	private List<LString> "CYS"List = new ArrayList<LString>(2);
	private lawu.chem.pdb.primitives.Character chainID1;
	private lawu.chem.pdb.primitives.Integer seqNum1;
	private AChar icode1;
	private lawu.chem.pdb.primitives.Character chainID2;
	private lawu.chem.pdb.primitives.Integer seqNum2;
	private AChar icode2;
	private SymOp sym1;
	private SymOp sym2;

	private final static Pattern pattern = Pattern.compile("SSBOND (...) (...) (.) (.{4})(.)   (...) (.) (.{4})(.) {23}(.{6}) (.{6}) {8}"); //$NON-NLS-1$
	private final static String format = "SSBOND %3s %3s %1s %4s%1s   %3s %1s %4s%1s                       %6s %6s        "; //$NON-NLS-1$

	public Ssbond(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		serNum = new lawu.chem.pdb.primitives.Integer(m.group(1));
		"CYS"List.add(new LString(m.group(2), 3));
		chainID1 = new lawu.chem.pdb.primitives.Character(m.group(3));
		seqNum1 = new lawu.chem.pdb.primitives.Integer(m.group(4));
		icode1 = new AChar(m.group(5));
		"CYS"List.add(new LString(m.group(6), 3));
		chainID2 = new lawu.chem.pdb.primitives.Character(m.group(7));
		seqNum2 = new lawu.chem.pdb.primitives.Integer(m.group(8));
		icode2 = new AChar(m.group(9));
		sym1 = new SymOp(m.group(10));
		sym2 = new SymOp(m.group(11));
	}

	/**
	 *  Serial number.
	 */
//	public lawu.chem.pdb.primitives.Integer serNum() {
//		return serNum;
//	}

	/**
	 *  Residue name.
	 */
//	public LString(3) "CYS"() {
//		return "CYS";
//	}

	/**
	 *  Chain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID1() {
//		return chainID1;
//	}

	/**
	 *  Residue sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum1() {
//		return seqNum1;
//	}

	/**
	 *  Insertion code.
	 */
//	public AChar icode1() {
//		return icode1;
//	}

	/**
	 *  Residue name.
	 */
//	public LString(3) "CYS"() {
//		return "CYS";
//	}

	/**
	 *  Chain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID2() {
//		return chainID2;
//	}

	/**
	 *  Residue sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum2() {
//		return seqNum2;
//	}

	/**
	 *  Insertion code.
	 */
//	public AChar icode2() {
//		return icode2;
//	}

	/**
	 *  Symmetry oper for 1st resid
	 */
//	public SymOp sym1() {
//		return sym1;
//	}

	/**
	 *  Symmetry oper for 2nd resid
	 */
//	public SymOp sym2() {
//		return sym2;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Ssbond) {
			Ssbond r = (Ssbond) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
