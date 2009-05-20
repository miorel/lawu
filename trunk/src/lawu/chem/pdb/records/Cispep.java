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

public class Cispep {
//	private Integer serNum;
//	private LString(3) pep1;
//	private Character chainID1;
//	private Integer seqNum1;
//	private AChar icode1;
//	private LString(3) pep2;
//	private Character chainID2;
//	private Integer seqNum2;
//	private AChar icode2;
//	private Integer modNum;
//	private Real(6.2) measure;

	private final static Pattern pattern = Pattern.compile("\\ACISPEP\\Z"); //$NON-NLS-1$
	private final static String format = "CISPEP"; //$NON-NLS-1$

	public Cispep(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Record serial number.
	 */
//	public Integer serNum() {
//		return serNum;
//	}

	/**
	 * Residue name.
	 */
//	public LString(3) pep1() {
//		return pep1;
//	}

	/**
	 * Chain identifier.
	 */
//	public Character chainID1() {
//		return chainID1;
//	}

	/**
	 * Residue sequence number.
	 */
//	public Integer seqNum1() {
//		return seqNum1;
//	}

	/**
	 * Insertion code.
	 */
//	public AChar icode1() {
//		return icode1;
//	}

	/**
	 * Residue name.
	 */
//	public LString(3) pep2() {
//		return pep2;
//	}

	/**
	 * Chain identifier.
	 */
//	public Character chainID2() {
//		return chainID2;
//	}

	/**
	 * Residue sequence number.
	 */
//	public Integer seqNum2() {
//		return seqNum2;
//	}

	/**
	 * Insertion code.
	 */
//	public AChar icode2() {
//		return icode2;
//	}

	/**
	 * Identifies the specific model.
	 */
//	public Integer modNum() {
//		return modNum;
//	}

	/**
	 * Measure of the angle in degrees.
	 */
//	public Real(6.2) measure() {
//		return measure;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Cispep) {
			Cispep r = (Cispep) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
