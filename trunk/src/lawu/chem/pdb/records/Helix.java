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

public class Helix {
//	private Integer serNum;
//	private LString(3) helixID;
//	private Residue name initResName;
//	private Character initChainID;
//	private Integer initSeqNum;
//	private AChar initICode;
//	private Residue name endResName;
//	private Character endChainID;
//	private Integer endSeqNum;
//	private AChar endICode;
//	private Integer helixClass;
//	private String comment;
//	private Integer length;

	private final static Pattern pattern = Pattern.compile("\\AHELIX \\Z"); //$NON-NLS-1$
	private final static String format = "HELIX "; //$NON-NLS-1$

	public Helix(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Serial number of the helix. This starts at 1 and increases incrementally.
	 */
//	public Integer serNum() {
//		return serNum;
//	}

	/**
	 * Helix identifier. In addition to a serial number, each helix is given an alphanumeric character helix identifier.
	 */
//	public LString(3) helixID() {
//		return helixID;
//	}

	/**
	 * Name of the initial residue.
	 */
//	public Residue name initResName() {
//		return initResName;
//	}

	/**
	 * Chain identifier for the chain containing this helix.
	 */
//	public Character initChainID() {
//		return initChainID;
//	}

	/**
	 * Sequence number of the initial residue.
	 */
//	public Integer initSeqNum() {
//		return initSeqNum;
//	}

	/**
	 * Insertion code of the initial residue.
	 */
//	public AChar initICode() {
//		return initICode;
//	}

	/**
	 * Name of the terminal residue of the helix.
	 */
//	public Residue name endResName() {
//		return endResName;
//	}

	/**
	 * Chain identifier for the chain containing this helix.
	 */
//	public Character endChainID() {
//		return endChainID;
//	}

	/**
	 * Sequence number of the terminal residue.
	 */
//	public Integer endSeqNum() {
//		return endSeqNum;
//	}

	/**
	 * Insertion code of the terminal residue.
	 */
//	public AChar endICode() {
//		return endICode;
//	}

	/**
	 * Helix class (see below).
	 */
//	public Integer helixClass() {
//		return helixClass;
//	}

	/**
	 * Comment about this helix.
	 */
//	public String comment() {
//		return comment;
//	}

	/**
	 * Length of this helix.
	 */
//	public Integer length() {
//		return length;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Helix) {
			Helix r = (Helix) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
