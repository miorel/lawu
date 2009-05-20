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

public class Seqres {
//	private Integer serNum;
//	private Character chainID;
//	private Integer numRes;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;
//	private Residue name resName;

	private final static Pattern pattern = Pattern.compile("\\ASEQRES\\Z"); //$NON-NLS-1$
	private final static String format = "SEQRES"; //$NON-NLS-1$

	public Seqres(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Serial number of the SEQRES record for the current chain. Starts at 1 and increments by one each line. Reset to 1 for each chain.
	 */
//	public Integer serNum() {
//		return serNum;
//	}

	/**
	 * Chain identifier. This may be any single legal character, including a blank which is used if there is only one chain.
	 */
//	public Character chainID() {
//		return chainID;
//	}

	/**
	 * Number of residues in the chain. This value is repeated on every record.
	 */
//	public Integer numRes() {
//		return numRes;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	/**
	 * Residue name.
	 */
//	public Residue name resName() {
//		return resName;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Seqres) {
			Seqres r = (Seqres) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
