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

public class Ssbond {
//	private Integer serNum       S;
//	private LString(3) "CYS"        R;
//	private Character chainID1     C;
//	private Integer seqNum1      R;
//	private AChar icode1       I;
//	private LString(3) "CYS"        R;
//	private Character chainID2     C;
//	private Integer seqNum2      R;
//	private AChar icode2       I;
//	private SymOP sym1         S;
//	private SymOP sym2         S;

	private final static Pattern pattern = Pattern.compile("\\ASSBOND\\Z"); //$NON-NLS-1$
	private final static String format = "SSBOND"; //$NON-NLS-1$

	public Ssbond(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * erial number.
	 */
//	public Integer serNum       S() {
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
//	public Character chainID1     C() {
//		return chainID1     C;
//	}

	/**
	 * esidue sequence number.
	 */
//	public Integer seqNum1      R() {
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
//	public Character chainID2     C() {
//		return chainID2     C;
//	}

	/**
	 * esidue sequence number.
	 */
//	public Integer seqNum2      R() {
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
