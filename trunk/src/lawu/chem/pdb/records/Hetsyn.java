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
public class Hetsyn {
	private Continuation continuation;
	private LString hetID;
	private SList hetSynonyms;

	private final static Pattern pattern = Pattern.compile("HETSYN  (..) (...) (.{55}) {10}"); //$NON-NLS-1$
	private final static String format = "HETSYN  %2s %3s %55s          "; //$NON-NLS-1$

	public Hetsyn(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
		continuation = new Continuation(m.group(1));
		hetID = new LString(m.group(2), 3);
		hetSynonyms = new SList(m.group(3));
	}

	/**
	 *  Allows concatenation of multiple records.
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 *  Het identifier, right-justified.
	 */
//	public LString(3) hetID() {
//		return hetID;
//	}

	/**
	 *  List of synonyms.
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
