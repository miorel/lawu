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

public class Turn {
//	private Integer seq;
//	private LString(3) turnId;
//	private Residue name initResName;
//	private Character initChainId;
//	private Integer initSeqNum;
//	private AChar initICode;
//	private Residue name endResName;
//	private Character endChainId;
//	private Integer endSeqNum;
//	private AChar endICode;
//	private String comment;

	private final static Pattern pattern = Pattern.compile("\\ATURN  \\Z"); //$NON-NLS-1$
	private final static String format = "TURN  "; //$NON-NLS-1$

	public Turn(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Turn number; starts with 1 and increments by one.
	 */
//	public Integer seq() {
//		return seq;
//	}

	/**
	 * Turn identifier
	 */
//	public LString(3) turnId() {
//		return turnId;
//	}

	/**
	 * Residue name of initial residue in turn.
	 */
//	public Residue name initResName() {
//		return initResName;
//	}

	/**
	 * Chain identifier for the chain containing this turn.
	 */
//	public Character initChainId() {
//		return initChainId;
//	}

	/**
	 * Sequence number of initial residue in turn.
	 */
//	public Integer initSeqNum() {
//		return initSeqNum;
//	}

	/**
	 * Insertion code of initial residue in turn.
	 */
//	public AChar initICode() {
//		return initICode;
//	}

	/**
	 * Residue name of terminal residue of turn.
	 */
//	public Residue name endResName() {
//		return endResName;
//	}

	/**
	 * Chain identifier for the chain containing this turn.
	 */
//	public Character endChainId() {
//		return endChainId;
//	}

	/**
	 * Sequence number of terminal residue of turn.
	 */
//	public Integer endSeqNum() {
//		return endSeqNum;
//	}

	/**
	 * Insertion code of terminal residue of turn.
	 */
//	public AChar endICode() {
//		return endICode;
//	}

	/**
	 * Associated comment.
	 */
//	public String comment() {
//		return comment;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Turn) {
			Turn r = (Turn) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
