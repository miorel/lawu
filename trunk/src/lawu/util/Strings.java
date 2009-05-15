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
package lawu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Miorel-Lucian Palii
 */
public class Strings {
	private Strings() {
	}
	
	public static String toTitleCase(String string) {
		StringBuffer sb = new StringBuffer();
		Pattern pat = Pattern.compile("(\\w?)(\\w*\\b)"); //$NON-NLS-1$
		Matcher m = pat.matcher(string);
		while(m.find())
			m.appendReplacement(sb, m.group(1).toUpperCase() + m.group(2).toLowerCase());
		m.appendTail(sb);
		return sb.toString();
	}
}
