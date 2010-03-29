package com.googlecode.lawu.lex.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUnicodeEscapeTranslator {
	// this regex would need infinite look-behind to guarantee correctness, so try not to exceed Integer.MAX_VALUE slashes in a row 
	private final static String UNICODE_ESCAPE_REGEX = String.format("(?<=(?<!\\\\)(?:\\\\{2}){0,%d})\\\\u+(\\p{XDigit}{4})", Integer.valueOf(Integer.MAX_VALUE / 2));
	private final static Pattern UNICODE_ESCAPE_PATTERN = Pattern.compile(UNICODE_ESCAPE_REGEX);
	
	private final static JavaUnicodeEscapeTranslator instance = new JavaUnicodeEscapeTranslator();
	
	private JavaUnicodeEscapeTranslator() {
	}
	
	public static JavaUnicodeEscapeTranslator getInstance() {
		return instance;
	}
	
	public StringBuffer decode(CharSequence text) {
		StringBuffer ret = new StringBuffer();
		Matcher m = UNICODE_ESCAPE_PATTERN.matcher(text);
		while(m.find())
			m.appendReplacement(ret, Character.toString((char) Integer.parseInt(m.group(1), 16)));
		m.appendTail(ret);
		return ret;
	}
}
