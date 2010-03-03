package com.googlecode.lawu.lex.java;

import static com.googlecode.lawu.util.Iterators.iterator;
import static com.googlecode.lawu.util.Iterators.map;
import static com.googlecode.lawu.util.Strings.PATTERN_QUOTE;
import static com.googlecode.lawu.util.Strings.join;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.googlecode.lawu.lex.Token;
import com.googlecode.lawu.lex.TokenPattern;
import com.googlecode.lawu.util.Filter;

public enum JavaPattern implements TokenPattern {
	SUBSTITUTE_CHARACTER(true, false) {
		@Override
		protected String getMatchRegex() {
			return Pattern.quote("\u001a") + "\\z";
		}
	},
	LINE_TERMINATOR(true, false) {
		@Override
		protected String getMatchRegex() {
			// allowed line terminators are: "\n", "\r\n", "\r"
			return "(?:\\n|\\r\\n?)";
		}
	},
	WHITESPACE(true, false) {
		@Override
		protected String getMatchRegex() {
			// allowed (non line terminator) whitespace is " ", "\t", "\f"
			return "[ \t\f]+";
		}
	},
	COMMENT_BLOCK_BEGIN(true, false) {
		@Override
		protected String getMatchRegex() {
			return Pattern.quote("/*");
		}
	},
	COMMENT_BLOCK_END(true, false) {
		@Override
		protected String getMatchRegex() {
			return Pattern.quote("*/");
		}
	},
	COMMENT_BLOCK(false, false) {
		@Override
		protected String getExcludeRegex() {
			return COMMENT_BLOCK_END.getMatchRegex();
		}
	},
    COMMENT_EOL_BEGIN(true, false) {
		@Override
		protected String getMatchRegex() {
			return Pattern.quote("//");
		}
	},
	COMMENT_EOL(false, false) {
		@Override
		protected String getExcludeRegex() {
			return LINE_TERMINATOR.getMatchRegex();
		}
	},
	KEYWORD(true) {
		@Override
		protected String getMatchRegex() {
			return makeIdentifiers("abstract assert boolean break byte case catch char class const continue default do double else enum extends final finally float for goto if implements import instanceof int interface long native new package private protected public return short static strictfp super switch synchronized this throw throws transient try void volatile while".split(" "));
		}
	},
	OPERATOR(true) {
		@Override
		protected String getMatchRegex() {
			return makeDisjunction(">>>= <<= >>= >>> != %= && &= *= ++ += -- -= /= << <= == >= >> ^= |= || ! % & * + - / : < = > ? ^ | ~".split(" "));
		}
	},
	LITERAL_BOOLEAN(true) {
		@Override
		protected String getMatchRegex() {
			return makeIdentifiers("true", "false");
		}
	},
	LITERAL_NULL(true) {
		@Override
		protected String getMatchRegex() {
			return makeIdentifiers("null");
		}
	},
	LITERAL_CHARACTER_DELIM(true) {
		@Override
		protected String getMatchRegex() {
			return Pattern.quote("'");
		}
	},
	LITERAL_CHARACTER(true) {
		@Override
		protected String getMatchRegex() {
			return "(?:[^" + Pattern.quote("\r\n\'\\") + "]|" + getEscapeSequences() + ")";
		}
	},
	LITERAL_STRING_DELIM(true) {
		@Override
		protected String getMatchRegex() {
			return Pattern.quote("\"");
		}
	},
	LITERAL_STRING(true) {
		@Override
		protected String getMatchRegex() {
			return "(?:[^" + Pattern.quote("\r\n\"\\") + "]|" + getEscapeSequences() + ")+";
		}
	},
	LITERAL_INTEGER(true) {
		@Override
		protected String getMatchRegex() {
			return "(?:0[0-7]*|[1-9]\\d+|0[xX]\\p{XDigit}+)[lL]?(?!\\p{javaJavaIdentifierPart})";
		}
	},
	LITERAL_FLOATING_POINT(true) {
		@Override
		protected String getMatchRegex() {
			String signedInt = "[\\Q+-\\E]?\\d+";
			String dec = "(?:\\d+\\.?\\d*|\\.\\d+)(?:[eE]" + signedInt + ")?";
			String hex = "0[xX](?:\\p{XDigit}+\\.?\\p{XDigit}*|\\.\\p{XDigit}+)[pP]" + signedInt;
			return "(?:(?:" + dec + ")|(?:" + hex + "))[fFdD]?(?!\\p{javaJavaIdentifierPart})";
		}
	},
	SEPARATOR(true) {
		@Override
		protected String getMatchRegex() {
			return "[" + Pattern.quote("(){}[];,.") + "]";
		}
	},
	IDENTIFIER(true) {
		@Override
		protected String getMatchRegex() {
			return "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";
		}
	},
	ANNOTATION_BEGIN(true) {
		@Override
		protected String getMatchRegex() {
			return Pattern.quote("@");
		}
	};
	
	public static final Filter<Token<JavaPattern>> TERMINALS = new Filter<Token<JavaPattern>>() {
		@Override
		public boolean keep(Token<JavaPattern> token) {
			return token.getType().isTerminal();
		}
	};
	
	private final Pattern pattern;
	private final boolean anchor;
	
	private final boolean terminal;
	
	private JavaPattern(boolean anchor) {
		this(anchor, true);
	}
	
	private JavaPattern(boolean anchor, boolean terminal) {
		this.terminal = terminal;
		this.anchor = anchor; // if anchored, we look for the match regex at the beginning, otherwise we get everything until the exclude regex
		this.pattern = Pattern.compile(anchor ? "\\A" + getMatchRegex() : getExcludeRegex());
	}

	public boolean isTerminal() {
		return terminal;
	}
	
	protected String getMatchRegex() {
		throw new UnsupportedOperationException();
	}
	
	protected String getExcludeRegex() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int matchLength(CharSequence text) {
		Matcher m = pattern.matcher(text);
		int ret = 0;
		if(!anchor)
			ret = m.find() ? m.start() : text.length();
		else if(m.find())
			ret = m.end() - m.start();
		return ret;
	}
	
	protected static String makeDisjunction(String... tokens) {
		return String.format("(?:%s)", join("|", map(PATTERN_QUOTE, iterator(tokens))));
	}
	
	protected static String makeIdentifiers(String... identifiers) {
		return makeDisjunction(identifiers) + "(?!\\p{javaJavaIdentifierPart})";
	}
	
	protected static String getEscapeSequences() {
		// allowed escapes are \b, \t, \n, \f, \r, \", \', \\, and \{0 to 255 in octal}
		return "\\\\(?:[" + Pattern.quote("btnfr\"\'\\") + "]|[0-3]?[0-7]{1,2})";
	}
}
