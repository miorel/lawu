/*
 * Copyright (C) 2010 Miorel-Lucian Palii
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
package com.googlecode.lawu.util;

import static com.googlecode.lawu.util.Iterators.adapt;
import static com.googlecode.lawu.util.Iterators.iterator;
import static com.googlecode.lawu.util.Iterators.map;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.googlecode.lawu.dp.Iterator;

/**
 * A collection of string-related utility methods.
 * 
 * @author Miorel-Lucian Palii
 */
public class Strings {
	/**
	 * Maps character sequences to their corresponding literal pattern strings.
	 */
	public final static Mapper<CharSequence, String> PATTERN_QUOTE = new Mapper<CharSequence, String>() {
		@Override
		public String map(CharSequence charSeq) {
			return Pattern.quote(charSeq.toString());
		}
	}; 
	
	private final static Pattern NON_WHITESPACE_PATTERN = Pattern.compile("(\\S)(\\S*)");
	
	private final static Map<String, String> XML_ESCAPE_MAP;
	private final static Pattern XML_ESCAPE_PATTERN;
	static {
		XML_ESCAPE_MAP = new HashMap<String, String>();
		XML_ESCAPE_MAP.put("<", "&lt;");
		XML_ESCAPE_MAP.put(">", "&gt;");
		XML_ESCAPE_MAP.put("'", "&apos;");
		XML_ESCAPE_MAP.put("\"", "&quot;");
		XML_ESCAPE_MAP.put("&", "&amp;");
		XML_ESCAPE_PATTERN = Pattern.compile(getRegex(adapt(XML_ESCAPE_MAP.keySet().iterator())));
	}
	
	/**
	 * There is no need to instantiate this class.
	 */
	private Strings() {
	}
	
	/**
	 * Prepares a regular expression string that will match any of the literal
	 * sequences given by the iterator.
	 * 
	 * @param charSeqs the character sequences to match
	 * @return a regular expression matching all the given character sequences
	 */
	public static String getRegex(Iterator<? extends CharSequence> charSeqs) {
		return String.format("(?:%s)", join("|", map(PATTERN_QUOTE, adapt(charSeqs))));	
	}

	/**
	 * Prepares a regular expression string that will match any of the literal
	 * sequences given.
	 * 
	 * @param charSeqs the character sequences to match
	 * @return a regular expression matching all the given character sequences
	 */
	public static String getRegex(CharSequence... charSeqs) {
		return getRegex(iterator(charSeqs));
	}
	
	/**
	 * <p>
	 * Changes the given text to lower case. That is, any upper case character
	 * in the text (e.g. a letter) will be replaced with its lower case
	 * counterpart.
	 * </p>
	 * <p>
	 * This method is primarily here for orthogonality, as the
	 * <code>String</code> class (likely the most commonly-used
	 * <code>CharSequence</code>) already has a <code>toLowerCase()</code>
	 * method.
	 * </p>
	 * 
	 * @param charSeq the text to change
	 * @return a lower case copy of the text
	 */
	public static String toLowerCase(CharSequence charSeq) {
		return charSeq.toString().toLowerCase();
	}

	/**
	 * <p>
	 * Changes the given text to upper case. That is, any lower case character
	 * in the text (e.g. a letter) will be replaced with its upper case
	 * counterpart.
	 * </p>
	 * <p>
	 * This method is primarily here for orthogonality, as the
	 * <code>String</code> class (likely the most commonly-used
	 * <code>CharSequence</code>) already has a <code>toUpperCase()</code>
	 * method.
	 * </p>
	 * 
	 * @param charSeq the text to change
	 * @return an upper case copy of the text
	 */
	public static String toUpperCase(CharSequence charSeq) {
		return charSeq.toString().toUpperCase();
	}
	
	/**
	 * <p>
	 * Changes the given text to title case. That is, the text will be changed
	 * to lower case, except for the first character of each word, which will
	 * be changed to upper case.
	 * </p>
	 * <p>
	 * Here, a word is not necessarily alphanumeric, but may be any sequence of
	 * non-whitespace characters.
	 * </p>
	 * 
	 * @param charSeq the text to change
	 * @return a title case copy of the text
	 */
	public static String toTitleCase(CharSequence charSeq) {
		return toTitleCase(charSeq, Integer.MAX_VALUE);
	}
	
	/**
	 * Changes the given text to title case, capitalizing words up to the
	 * specified limit. That is, this method behaves just like the
	 * single-argument version, except that any words beyond the limit will
	 * not be capitalized. They will still be changed to lower case, however.
	 * 
	 * @param charSeq the text to change
	 * @param limit the maximum number of words to capitalize
	 * @return a title case copy of the text
	 */
	public static String toTitleCase(CharSequence charSeq, int limit) {
		if(limit < 0)
			throw new IllegalArgumentException("the limit may not be negative");
		StringBuffer sb = new StringBuffer();
		Matcher m = NON_WHITESPACE_PATTERN.matcher(toLowerCase(charSeq));
		while(m.find() && --limit >= 0)
			m.appendReplacement(sb, m.group(1).toUpperCase() + m.group(2));
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * Returns a string containing the given character repeated a specified
	 * number of times. 
	 * 
	 * @param character the character to "multiply"
	 * @param count the number of times to repeat the characters
	 * @return <code>character</code> repeated <code>count</code> times
	 */
	public static String multiply(char character, int count) {
		return multiply(Character.toString(character), count);
	}
	
	/**
	 * Returns a string containing the given text repeated a specified number of
	 * times. 
	 * 
	 * @param charSeq the text to "multiply"
	 * @param count the number of times to repeat the text
	 * @return <code>charSeq</code> repeated <code>count</code> times
	 */
	public static String multiply(CharSequence charSeq, int count) {
		if(count < 0)
			throw new IllegalArgumentException("can't repeat a negative number of times");
		StringBuilder sb = new StringBuilder(charSeq.length() * count);
		while(count-- > 0)
			sb.append(charSeq);
		return sb.toString();
	}
	
	/**
	 * Reverses the order of the characters in the given text.
	 * 
	 * @param charSeq the text to reverse
	 * @return a copy of the text with the order of the characters reversed
	 */
	public static String reverse(CharSequence charSeq) {
		return new StringBuilder(charSeq).reverse().toString();
	}
	
	/**
	 * Joins a group of character sequences into a single string, using the
	 * given separator.
	 * 
	 * @param separator the separator between adjacent joined sequences
	 * @param charSeqs the sequences to join
	 * @return a single string containing all the sequences, joined by the
	 *         separator 
	 */
	public static String join(CharSequence separator, Iterator<? extends CharSequence> charSeqs) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for(charSeqs.reset(); !charSeqs.isDone(); charSeqs.advance()) {
			if(!first)
				sb.append(separator);
			else
				first = false;
			sb.append(charSeqs.current());
		}
		return sb.toString();
	}

	/**
	 * Joins a group of character sequences into a single string, using the
	 * given separator.
	 * 
	 * @param separator the separator between adjacent joined sequences
	 * @param charSeqs the sequences to join
	 * @return a single string containing all the sequences, joined by the
	 *         separator 
	 */
	public static String join(char separator, Iterator<? extends CharSequence> charSeqs) {
		return join(Character.toString(separator), charSeqs);
	}

	/**
	 * Joins a group of character sequences into a single string, using the
	 * given separator.
	 * 
	 * @param separator the separator between adjacent joined sequences
	 * @param charSeqs the sequences to join
	 * @return a single string containing all the sequences, joined by the
	 *         separator 
	 */
	public static String join(CharSequence separator, CharSequence... charSeqs) {
		return join(separator, iterator(charSeqs));
	}

	/**
	 * Joins a group of character sequences into a single string, using the
	 * given separator.
	 * 
	 * @param separator the separator between adjacent joined sequences
	 * @param charSeqs the sequences to join
	 * @return a single string containing all the sequences, joined by the
	 *         separator 
	 */
	public static String join(char separator, CharSequence... charSeqs) {
		return join(Character.toString(separator), charSeqs);
	}
	
	/**
	 * Checks if the given text is a single line. A piece of text is a single
	 * line if it contains no line separator characters. Note that by this
	 * definition, a piece of text containing a single line separator and at the
	 * last position will be flagged as multi-line. If this is undesired, trim
	 * the text before passing it to this method. 
	 * 
	 * @param charSeq the text to check
	 * @return whether the text contains any line separator characters 
	 */
	public static boolean isSingleLine(CharSequence charSeq) {
		boolean ret = true;
		for(Character c: iterator(charSeq))
			if(Character.getType(c.charValue()) == Character.LINE_SEPARATOR) {
				ret = false;
				break;
			}
		return ret;
	}
	
	/**
	 * Escapes any strings in the given text that have a special meaning in XML.
	 * For example, the quote character (&quot;) is replaced with
	 * <code>&amp;quot;</code>, and the ampersand (&amp;) is replaced with
	 * <code>&amp;amp;</code>.  
	 * 
	 * @param charSeq the text to escape
	 * @return a copy of the text with any special strings escaped 
	 */
	public static String escapeXml(CharSequence charSeq) {
		StringBuffer sb = new StringBuffer();
		Matcher m = XML_ESCAPE_PATTERN.matcher(charSeq);
		while(m.find())
			m.appendReplacement(sb, XML_ESCAPE_MAP.get(m.group()));
		m.appendTail(sb);
		return sb.toString();
	}
}