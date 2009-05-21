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
public class Modres {
//	private IDcode idCode     ID;
//	private Residue name resName    Res;
//	private lawu.chem.pdb.primitives.Character chainID    Cha;
//	private lawu.chem.pdb.primitives.Integer seqNum     Seq;
//	private AChar iCode      Ins;
//	private Residue name stdRes     Sta;
//	private lawu.chem.pdb.primitives.String comment    Des;

	private final static Pattern pattern = Pattern.compile("MODRES (.{4}) (...) (.) (.{4})(.) (...)  (.{41}) {10}"); //$NON-NLS-1$
	private final static String format = "MODRES %4s %3s %1s %4s%1s %3s  %41s          "; //$NON-NLS-1$

	public Modres(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		idCode     ID = new IdCode(m.group(1));
		// resName    Res = new Residue name(m.group(2));
		chainID    Cha = new lawu.chem.pdb.primitives.Character(m.group(3));
		seqNum     Seq = new lawu.chem.pdb.primitives.Integer(m.group(4));
		iCode      Ins = new AChar(m.group(5));
		// stdRes     Sta = new Residue name(m.group(6));
		comment    Des = new lawu.chem.pdb.primitives.String(m.group(7));
	}

	/**
	 * code of this entry.
	 */
//	public IDcode idCode     ID() {
//		return idCode     ID;
//	}

	/**
	 * idue name used in this entry.
	 */
//	public Residue name resName    Res() {
//		return resName    Res;
//	}

	/**
	 * in identifier.
	 */
//	public lawu.chem.pdb.primitives.Character chainID    Cha() {
//		return chainID    Cha;
//	}

	/**
	 * uence number.
	 */
//	public lawu.chem.pdb.primitives.Integer seqNum     Seq() {
//		return seqNum     Seq;
//	}

	/**
	 * ertion code.
	 */
//	public AChar iCode      Ins() {
//		return iCode      Ins;
//	}

	/**
	 * ndard residue name.
	 */
//	public Residue name stdRes     Sta() {
//		return stdRes     Sta;
//	}

	/**
	 * cription of the residue ification
	 */
//	public lawu.chem.pdb.primitives.String comment    Des() {
//		return comment    Des;
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
