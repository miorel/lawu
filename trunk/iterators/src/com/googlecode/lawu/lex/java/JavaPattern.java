package com.googlecode.lawu.lex.java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.googlecode.lawu.lex.TokenPattern;
import com.googlecode.lawu.util.Iterators;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public enum JavaPattern implements TokenPattern {
	SUBSTITUTE_CHARACTER(Pattern.quote("\u001a") + "\\z", false),
	LINE_TERMINATOR("(?:\\n|\\r\\n?)", false),
	WHITESPACE("[ \t\f]+", false),
	COMMENT_BLOCK_BEGIN("/*"),
	COMMENT_BLOCK_END("*/"),
	COMMENT_BLOCK_CONTENTS(false) {
		@Override
		protected String getExcludeRegex() {
			return COMMENT_BLOCK_END.getPattern().pattern().replaceFirst("\\A\\\\A", "");
		}
	},
    COMMENT_EOL_BEGIN("//"),
	COMMENT_EOL_CONTENTS(false) {
		@Override
		protected String getExcludeRegex() {
			return LINE_TERMINATOR.getPattern().pattern().replaceFirst("\\A\\\\A", "");
		}
	},
	KEYWORD_ABSTRACT("abstract"),
	KEYWORD_ASSERT("assert"),
	KEYWORD_BOOLEAN("boolean"),
	KEYWORD_BREAK("break"),
	KEYWORD_BYTE("byte"),
	KEYWORD_CASE("case"),
	KEYWORD_CATCH("catch"),
	KEYWORD_CHAR("char"),
	KEYWORD_CLASS("class"),
	KEYWORD_CONST("const"),
	KEYWORD_CONTINUE("continue"),
	KEYWORD_DEFAULT("default"),
	KEYWORD_DO("do"),
	KEYWORD_DOUBLE("double"),
	KEYWORD_ELSE("else"),
	KEYWORD_ENUM("enum"),
	KEYWORD_EXTENDS("extends"),
	KEYWORD_FINAL("final"),
	KEYWORD_FINALLY("finally"),
	KEYWORD_FLOAT("float"),
	KEYWORD_FOR("for"),
	KEYWORD_GOTO("goto"),
	KEYWORD_IF("if"),
	KEYWORD_IMPLEMENTS("implements"),
	KEYWORD_IMPORT("import"),
	KEYWORD_INSTANCEOF("instanceof"),
	KEYWORD_INT("int"),
	KEYWORD_INTERFACE("interface"),
	KEYWORD_LONG("long"),
	KEYWORD_NATIVE("native"),
	KEYWORD_NEW("new"),
	KEYWORD_PACKAGE("package"),
	KEYWORD_PRIVATE("private"),
	KEYWORD_PROTECTED("protected"),
	KEYWORD_PUBLIC("public"),
	KEYWORD_RETURN("return"),
	KEYWORD_SHORT("short"),
	KEYWORD_STATIC("static"),
	KEYWORD_STRICTFP("strictfp"),
	KEYWORD_SUPER("super"),
	KEYWORD_SWITCH("switch"),
	KEYWORD_SYNCHRONIZED("synchronized"),
	KEYWORD_THIS("this"),
	KEYWORD_THROW("throw"),
	KEYWORD_THROWS("throws"),
	KEYWORD_TRANSIENT("transient"),
	KEYWORD_TRY("try"),
	KEYWORD_VOID("void"),
	KEYWORD_VOLATILE("volatile"),
	KEYWORD_WHILE("while"),
	OPERATOR_BITWISE_COMPLEMENT("~"),
	OPERATOR_CONDITIONAL_OR("||"),
	OPERATOR_BITWISE_OR_INCLUSIVE_EQUALS("|="),
	OPERATOR_BITWISE_OR_INCLUSIVE("|"),
	OPERATOR_BITWISE_OR_EXCLUSIVE_EQUALS("^="),
	OPERATOR_BITWISE_OR_EXCLUSIVE("^"),
	OPERATOR_QUESTION_MARK("?"),
	OPERATOR_SHIFT_RIGHT_UNSIGNED_EQUALS(">>>="),
	OPERATOR_SHIFT_RIGHT_UNSIGNED(">>>"),
	OPERATOR_SHIFT_RIGHT_SIGNED_EQUALS(">>="),
	OPERATOR_SHIFT_RIGHT_SIGNED(">>"),
	OPERATOR_GREATER_THAN_OR_EQUAL_TO(">="),
	OPERATOR_GREATER_THAN(">"),
	OPERATOR_EQUAL_TO("=="),
	OPERATOR_ASSIGNMENT("="),
	OPERATOR_LESS_THAN_OR_EQUAL_TO("<="),
	OPERATOR_SHIFT_LEFT_SIGNED_EQUALS("<<="),
	OPERATOR_SHIFT_LEFT_SIGNED("<<"),
	OPERATOR_LESS_THAN("<"),
	OPERATOR_COLON(":"),
	OPERATOR_SLASH_EQUALS("/="),
	OPERATOR_SLASH("/"),
	OPERATOR_MINUS_EQUALS("-="),
	OPERATOR_DECREMENT("--"),
	OPERATOR_MINUS("-"),
	OPERATOR_PLUS_EQUALS("+="),
	OPERATOR_INCREMENT("++"),
	OPERATOR_PLUS("+"),
	OPERATOR_ASTERISK_EQUALS("*="),
	OPERATOR_ASTERISK("*"),
	OPERATOR_BITWISE_AND_EQUALS("&="),
	OPERATOR_CONDITIONAL_AND("&&"),
	OPERATOR_BITWISE_AND("&"),
	OPERATOR_MODULO_EQUALS("%="),
	OPERATOR_MODULO("%"),
	OPERATOR_NOT_EQUAL_TO("!="),
	OPERATOR_NOT("!"),
	SEPARATOR_BRACE_LEFT("{"),
	SEPARATOR_BRACE_RIGHT("}"),
	SEPARATOR_BRACKET_LEFT("["),
	SEPARATOR_BRACKET_RIGHT("]"),
	SEPARATOR_COMMA(","),
	SEPARATOR_PARENTHESIS_LEFT("("),
	SEPARATOR_PARENTHESIS_RIGHT(")"),
	SEPARATOR_PERIOD("."),
	SEPARATOR_SEMICOLON(";"),
	LITERAL_BOOLEAN_TRUE("true"),
	LITERAL_BOOLEAN_FALSE("false"),
	LITERAL_NULL("null"),
	LITERAL_CHARACTER_DELIM("'"),
	LITERAL_CHARACTER_CONTENTS("(?:[^" + Pattern.quote("\r\n\'\\") + "]|" + getEscapeSequences() + ")", false),
	LITERAL_STRING_DELIM("\""),
	LITERAL_STRING_CONTENTS("(?:[^" + Pattern.quote("\r\n\"\\") + "]|" + getEscapeSequences() + ")+", false),
	LITERAL_INTEGER("(?:0[0-7]*|[1-9]\\d+|0[xX]\\p{XDigit}+)[lL]?(?!\\p{javaJavaIdentifierPart})", false),
	LITERAL_FLOATING_POINT(true) {
		@Override
		protected String getMatchRegex() {
			String signedInt = "[\\Q+-\\E]?\\d+";
			String dec = "(?:\\d+\\.?\\d*|\\.\\d+)(?:[eE]" + signedInt + ")?";
			String hex = "0[xX](?:\\p{XDigit}+\\.?\\p{XDigit}*|\\.\\p{XDigit}+)[pP]" + signedInt;
			return "(?:(?:" + dec + ")|(?:" + hex + "))[fFdD]?(?!\\p{javaJavaIdentifierPart})";
		}
	},
	IDENTIFIER("\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*", false),
	ANNOTATION_BEGIN("@"),
	;
	
	private final Pattern pattern;
	private final boolean anchor;
	
	private JavaPattern(boolean anchor) {
		this.anchor = anchor; // if anchored, we look for the match regex at the beginning, otherwise we get everything until the exclude regex
		this.pattern = Pattern.compile(anchor ? "\\A" + getMatchRegex() : getExcludeRegex());
	}
	
	private JavaPattern(String literal) {
		this(literal, true);
	}
	
	private JavaPattern(String pattern, boolean quote) {
		this.anchor = true;
		String regex = pattern;
		if(quote) {
			regex = Pattern.quote(regex);
			if(Character.isJavaIdentifierPart(pattern.charAt(pattern.length() - 1)))
				regex += "(?!\\p{javaJavaIdentifierPart})";	
		}
		this.pattern = Pattern.compile("\\A" + regex);
	}
	
	protected Pattern getPattern() {
		return pattern;
	}
	
	protected String getMatchRegex() {
		throw new UnsupportedOperationException();
	}
	
	protected String getExcludeRegex() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int matchLength(CharSequence text) {
		Matcher m = getPattern().matcher(text);
		int ret = 0;
		if(!anchor)
			ret = m.find() ? m.start() : text.length();
		else if(m.find())
			ret = m.end() - m.start();
		return ret;
	}
	
	protected static String getEscapeSequences() {
		// allowed escapes are \b, \t, \n, \f, \r, \", \', \\, and \{0 to 255 in octal}
		return "\\\\(?:[" + Pattern.quote("btnfr\"\'\\") + "]|[0-3]?[0-7]{1,2})";
	}
	
	public static UniversalIterator<JavaPattern> getKeywords() {
		return getValues("KEYWORD");
	}
	
	public static UniversalIterator<JavaPattern> getOperators() {
		return getValues("OPERATOR");
	}

	public static UniversalIterator<JavaPattern> getSeparators() {
		return getValues("SEPARATOR");
	}

	public static UniversalIterator<JavaPattern> getLiterals() {
		return Iterators.iterator(
			LITERAL_BOOLEAN_TRUE, LITERAL_BOOLEAN_FALSE, LITERAL_NULL,
			LITERAL_INTEGER, LITERAL_FLOATING_POINT,
			LITERAL_CHARACTER_DELIM, LITERAL_STRING_DELIM
		);
	}
	
	private static UniversalIterator<JavaPattern> getValues(String label) {
		List<JavaPattern> list = new ArrayList<JavaPattern>();
		for(JavaPattern pattern: values())
			if(pattern.toString().startsWith(label + "_"))
				list.add(pattern);
		return Iterators.iterator(list);
	}
}
