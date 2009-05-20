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

public class Expdta {
//	private Continuation continuation;
//	private SList technique;

	private final static Pattern pattern = Pattern.compile("\\AEXPDTA\\Z"); //$NON-NLS-1$
	private final static String format = "EXPDTA"; //$NON-NLS-1$

	public Expdta(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
	}

	/**
	 * Allows concatenation of multiple records
	 */
//	public Continuation continuation() {
//		return continuation;
//	}

	/**
	 * The experimental technique(s) with optional comment describing the sample or experiment.
	 */
//	public SList technique() {
//		return technique;
//	}

	@Override	
	public String toString() {
		return String.format(format);
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Expdta) {
			Expdta r = (Expdta) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
