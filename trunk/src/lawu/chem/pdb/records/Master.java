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

public class Master {
//	private Integer numRemark;
//	private Integ er        "0";
//	private Integer numHet;
//	private Integer numHelix;
//	private Integer numSheet;
//	private Integer numTurn;
//	private Integer numSite;
//	private Integer numXform;
//	private Integer numCoord;
//	private Integer numTer;
//	private Integer numConect;
//	private Integer numSeq;

	private final static Pattern pattern = Pattern.compile("\\AMASTER\\Z"); //$NON-NLS-1$
	private final static String format = "MASTER"; //$NON-NLS-1$

	public Master(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Number of REMARK records
	 */
//	public Integer numRemark() {
//		return numRemark;
//	}

	/**
	 * Number of HET records
	 */
//	public Integer numHet() {
//		return numHet;
//	}

	/**
	 * Number of HELIX records
	 */
//	public Integer numHelix() {
//		return numHelix;
//	}

	/**
	 * Number of SHEET records
	 */
//	public Integer numSheet() {
//		return numSheet;
//	}

	/**
	 * Number of TURN records
	 */
//	public Integer numTurn() {
//		return numTurn;
//	}

	/**
	 * Number of SITE records
	 */
//	public Integer numSite() {
//		return numSite;
//	}

	/**
	 * Number of coordinate transformation records (ORIGX+SCALE+MTRIX)
	 */
//	public Integer numXform() {
//		return numXform;
//	}

	/**
	 * Number of atomic coordinate records (ATOM+HETATM)
	 */
//	public Integer numCoord() {
//		return numCoord;
//	}

	/**
	 * Number of TER records
	 */
//	public Integer numTer() {
//		return numTer;
//	}

	/**
	 * Number of CONECT records
	 */
//	public Integer numConect() {
//		return numConect;
//	}

	/**
	 * Number of SEQRES records
	 */
//	public Integer numSeq() {
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
