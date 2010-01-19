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
public class Cispep {
	private lawu.chem.pdb.primitives.Integer serNum;
	private LString pep1;
	private lawu.chem.pdb.primitives.Character chainID1;
	private lawu.chem.pdb.primitives.Integer seqNum1;
	private AChar icode1;
	private LString pep2;
	private lawu.chem.pdb.primitives.Character chainID2;
	private lawu.chem.pdb.primitives.Integer seqNum2;
	private AChar icode2;
	private lawu.chem.pdb.primitives.Integer modNum;
	private Real measure;

	private final static Pattern pattern = Pattern.compile("CISPEP (...) (...) (.) (.{4})(.)   (...) (.) (.{4})(.) {7}(...) {7}(.{6}) {21}"); //$NON-NLS-1$
	private final static String format = "CISPEP %3s %3s %1s %4s%1s   %3s %1s %4s%1s       %3s       %6s                     "; //$NON-NLS-1$

	public Cispep(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		this.serNum = new lawu.chem.pdb.primitives.Integer(m.group(1));
		this.pep1 = new LString(m.group(2), 3);
		this.chainID1 = new lawu.chem.pdb.primitives.Character(m.group(3));
		this.seqNum1 = new lawu.chem.pdb.primitives.Integer(m.group(4));
		this.icode1 = new AChar(m.group(5));
		this.pep2 = new LString(m.group(6), 3);
		this.chainID2 = new lawu.chem.pdb.primitives.Character(m.group(7));
		this.seqNum2 = new lawu.chem.pdb.primitives.Integer(m.group(8));
		this.icode2 = new AChar(m.group(9));
		this.modNum = new lawu.chem.pdb.primitives.Integer(m.group(10));
		this.measure = new Real(m.group(11), 6, 2);
	}

	/**
	 *  Record serial number.
	 */
//	public lawu.chem.pdb.primitives.Integer serNum() {
//		return serNum;
//	}

	/**
	 *  Residue name.
	 */
//	public LString(3) pep1() {
//		return pep1;
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
//	public LString(3) pep2() {
//		return pep2;
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
	 *  Identifies the specific model.
	 */
//	public lawu.chem.pdb.primitives.Integer modNum() {
//		return modNum;
//	}

	/**
	 *  Measure of the angle in degrees.
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
