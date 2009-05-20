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

public class Hetsyn {
//	private Continuation continuation;
//	private LString(3) hetID;
//	private SList hetSynonyms;

	private final static Pattern pattern = Pattern.compile("\\AHETSYN\\Z"); //$NON-NLS-1$
	private final static String format = "HETSYN"; //$NON-NLS-1$

	public Hetsyn(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Allows concatenation of multiple records.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * Het identifier, right-justified.
	 */
//	public LString(3) hetID() {
//		return hetID;
//	}

	/**
	 * List of synonyms.
	 */
//	public SList hetSynonyms() {
//		return hetSynonyms;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Hetsyn) {
			Hetsyn r = (Hetsyn) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
