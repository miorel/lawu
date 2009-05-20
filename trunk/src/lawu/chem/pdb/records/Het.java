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

public class Het {
//	private LString(3) hetID;
//	private Character ChainID;
//	private Integer seqNum;
//	private AChar iCode;
//	private Integer numHetAtoms;
//	private String text;

	private final static Pattern pattern = Pattern.compile("\\AHET   \\Z"); //$NON-NLS-1$
	private final static String format = "HET   "; //$NON-NLS-1$

	public Het(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Het identifier, right-justified.
	 */
//	public LString(3) hetID() {
//		return hetID;
//	}

	/**
	 * Chain identifier.
	 */
//	public Character ChainID() {
//		return ChainID;
//	}

	/**
	 * Sequence number.
	 */
//	public Integer seqNum() {
//		return seqNum;
//	}

	/**
	 * Insertion code.
	 */
//	public AChar iCode() {
//		return iCode;
//	}

	/**
	 * Number of HETATM records for the group present in the entry.
	 */
//	public Integer numHetAtoms() {
//		return numHetAtoms;
//	}

	/**
	 * Text describing Het group.
	 */
//	public String text() {
//		return text;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Het) {
			Het r = (Het) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
