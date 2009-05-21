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
public class Ssbond {
//	private lawu.chem.pdb.primitives.Integer serNum       S;
//	private LString(3) "CYS"        R;
//	private lawu.chem.pdb.primitives.Character chainID1     C;
//	private lawu.chem.pdb.primitives.Integer seqNum1      R;
//	private AChar icode1       I;
//	private LString(3) "CYS"        R;
//	private lawu.chem.pdb.primitives.Character chainID2     C;
//	private lawu.chem.pdb.primitives.Integer seqNum2      R;
//	private AChar icode2       I;
//	private SymOP sym1         S;
//	private SymOP sym2         S;

	private final static Pattern pattern = Pattern.compile("SSBOND (...) (...) (.) (.{4})(.)   (...) (.) (.{4})(.) {23}(.{6}) (.{6}) {8}"); //$NON-NLS-1$
	private final static String format = "SSBOND %3s %3s %1s %4s%1s   %3s %1s %4s%1s                       %6s %6s        "; //$NON-NLS-1$

	public Ssbond(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		serNum       S = new lawu.chem.pdb.primitives.Integer(m.group(1));
		// "CYS"        R = new LString(3)(m.group(2));
		chainID1     C = new lawu.chem.pdb.primitives.Character(m.group(3));
		seqNum1      R = new lawu.chem.pdb.primitives.Integer(m.group(4));
		icode1       I = new AChar(m.group(5));
		// "CYS"        R = new LString(3)(m.group(6));
		chainID2     C = new lawu.chem.pdb.primitives.Character(m.group(7));
		seqNum2      R = new lawu.chem.pdb.primitives.Integer(m.group(8));
		icode2       I = new AChar(m.group(9));
		sym1         S = new SymOP(m.group(10));
		sym2         S = new SymOP(m.group(11));
	}

	/**
	 * erial number.
	 */
//	public lawu.chem.pdb.primitives.Integer serNum       S() {
//		return serNum       S;
//	}

	/**
	 * esidue name.
	 */
//	public LString(3) "CYS"        R() {
//		return "CYS"        R;
//	}

	/**
	 * hain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID1     C() {
//		return chainID1     C;
//	}

	/**
	 * esidue sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum1      R() {
//		return seqNum1      R;
//	}

	/**
	 * nsertion code.
	 */
//	public AChar icode1       I() {
//		return icode1       I;
//	}

	/**
	 * esidue name.
	 */
//	public LString(3) "CYS"        R() {
//		return "CYS"        R;
//	}

	/**
	 * hain identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID2     C() {
//		return chainID2     C;
//	}

	/**
	 * esidue sequence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum2      R() {
//		return seqNum2      R;
//	}

	/**
	 * nsertion code.
	 */
//	public AChar icode2       I() {
//		return icode2       I;
//	}

	/**
	 * ymmetry oper for 1st resid
	 */
//	public SymOP sym1         S() {
//		return sym1         S;
//	}

	/**
	 * ymmetry oper for 2nd resid
	 */
//	public SymOP sym2         S() {
//		return sym2         S;
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
