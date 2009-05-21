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
public class Master {
	private lawu.chem.pdb.primitives.Integer numRemark;
	private Integ er        "0";
	private lawu.chem.pdb.primitives.Integer numHet;
	private lawu.chem.pdb.primitives.Integer numHelix;
	private lawu.chem.pdb.primitives.Integer numSheet;
	private lawu.chem.pdb.primitives.Integer numTurn;
	private lawu.chem.pdb.primitives.Integer numSite;
	private lawu.chem.pdb.primitives.Integer numXform;
	private lawu.chem.pdb.primitives.Integer numCoord;
	private lawu.chem.pdb.primitives.Integer numTer;
	private lawu.chem.pdb.primitives.Integer numConect;
	private lawu.chem.pdb.primitives.Integer numSeq;

	private final static Pattern pattern = Pattern.compile("MASTER {4}(.{5})(.{5})(.{5})(.{5})(.{5})(.{5})(.{5})(.{5})(.{5})(.{5})(.{5})(.{5}) {10}"); //$NON-NLS-1$
	private final static String format = "MASTER    %5s%5s%5s%5s%5s%5s%5s%5s%5s%5s%5s%5s          "; //$NON-NLS-1$

	public Master(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		numRemark = new lawu.chem.pdb.primitives.Integer(m.group(1));
		// er        "0" = new Integ(m.group(2));
		numHet = new lawu.chem.pdb.primitives.Integer(m.group(3));
		numHelix = new lawu.chem.pdb.primitives.Integer(m.group(4));
		numSheet = new lawu.chem.pdb.primitives.Integer(m.group(5));
		numTurn = new lawu.chem.pdb.primitives.Integer(m.group(6));
		numSite = new lawu.chem.pdb.primitives.Integer(m.group(7));
		numXform = new lawu.chem.pdb.primitives.Integer(m.group(8));
		numCoord = new lawu.chem.pdb.primitives.Integer(m.group(9));
		numTer = new lawu.chem.pdb.primitives.Integer(m.group(10));
		numConect = new lawu.chem.pdb.primitives.Integer(m.group(11));
		numSeq = new lawu.chem.pdb.primitives.Integer(m.group(12));
	}

	/**
	 * Number of REMARK records
	 */
//	public lawu.chem.pdb.primitives.Integer numRemark() {
//		return numRemark;
//	}

	/**
	 * Number of HET records
	 */
//	public lawu.chem.pdb.primitives.Integer numHet() {
//		return numHet;
//	}

	/**
	 * Number of HELIX records
	 */
//	public lawu.chem.pdb.primitives.Integer numHelix() {
//		return numHelix;
//	}

	/**
	 * Number of SHEET records
	 */
//	public lawu.chem.pdb.primitives.Integer numSheet() {
//		return numSheet;
//	}

	/**
	 * Number of TURN records
	 */
//	public lawu.chem.pdb.primitives.Integer numTurn() {
//		return numTurn;
//	}

	/**
	 * Number of SITE records
	 */
//	public lawu.chem.pdb.primitives.Integer numSite() {
//		return numSite;
//	}

	/**
	 * Number of coordinate transformation records (ORIGX+SCALE+MTRIX)
	 */
//	public lawu.chem.pdb.primitives.Integer numXform() {
//		return numXform;
//	}

	/**
	 * Number of atomic coordinate records (ATOM+HETATM)
	 */
//	public lawu.chem.pdb.primitives.Integer numCoord() {
//		return numCoord;
//	}

	/**
	 * Number of TER records
	 */
//	public lawu.chem.pdb.primitives.Integer numTer() {
//		return numTer;
//	}

	/**
	 * Number of CONECT records
	 */
//	public lawu.chem.pdb.primitives.Integer numConect() {
//		return numConect;
//	}

	/**
	 * Number of SEQRES records
	 */
//	public lawu.chem.pdb.primitives.Integer numSeq() {
//		return numSeq;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Master) {
			Master r = (Master) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
