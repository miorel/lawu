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

import static lawu.util.iterator.Iterators.iterator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lawu.dp.Iterator;

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
	
	public static String multiply(char character, int count) {
		return multiply(Character.toString(character), count);
	}
	
	public static String multiply(String string, int count) {
		if(string == null)
			throw new RuntimeException("");
		if(count < 0)
			throw new RuntimeException("");
		StringBuilder sb = new StringBuilder(string.length() * count);
		for(int i = 0; i != count; ++i)
			sb.append(string);
		return sb.toString();
	}
	
	public static String join(String separator, Iterator<String> strings) {
		StringBuilder sb = new StringBuilder();
		strings.reset();
		if(!strings.isDone()) {
			sb.append(strings.current());
			strings.advance();
		}
		while(!strings.isDone()) {
			sb.append(separator);
			sb.append(strings.current());
			strings.advance();
		}
		return sb.toString();
	}
	
	public static String join(String separator, String... strings) {
		return join(separator, iterator(strings));
	}	
}
