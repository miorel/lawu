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

public class Compnd {
//	private Continuation continuation;
//	private Specification compound;

	private final static Pattern pattern = Pattern.compile("\\ACOMPND\\Z"); //$NON-NLS-1$
	private final static String format = "COMPND"; //$NON-NLS-1$

	public Compnd(String record) {
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
	 * Description of the molecular components.
	 */
//	public Specification compound() {
//		return compound;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Compnd) {
			Compnd r = (Compnd) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
