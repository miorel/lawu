/**
 * 
 */
package lawu.lex.java;

import static lawu.util.Strings.join;
import static lawu.util.iterator.Iterators.iterator;
import static lawu.util.iterator.Iterators.map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lawu.lex.TokenPattern;
import lawu.util.Mapper;

/**
 * @author Miorel-Lucian Palii
 */
public enum JavaPattern implements TokenPattern {
	DIGIT_DECIMAL_NONZERO {
		@Override
		protected String getRegex() {
			return getCharacterClass("123456789"); //$NON-NLS-1$
		}
	},
	DIGIT_DECIMAL {
		@Override
		protected String getRegex() {
			return String.format("(?:%s|%s)", getLiteralRegex('0'), DIGIT_DECIMAL_NONZERO.getRegex()); //$NON-NLS-1$
		}
	},
	DIGIT_HEXADECIMAL {
		@Override
		protected String getRegex() {
			return getCharacterClass("0123456789AaBbCcDdEeFf"); //$NON-NLS-1$
		}
	},
	DIGIT_OCTAL {
		@Override
		protected String getRegex() {
			return getCharacterClass("01234567"); //$NON-NLS-1$
		}
	},
	LINE_TERMINATOR {
		@Override
		protected String getRegex() {
			return String.format("(?:%1$s|%1$s?%2$s)", getLiteralRegex('\r'), getLiteralRegex('\n')); //$NON-NLS-1$
		}
	},
	WHITESPACE {
		@Override
		protected String getRegex() {
			return "[ \t\f]+"; //$NON-NLS-1$
		}
	},
	SEPARATOR {
		@Override
		protected String getRegex() {
			return getCharacterClass("(){}[];,."); //$NON-NLS-1$
		}
	},
	KEYWORD {
		@Override
		protected String getRegex() {
			StringBuilder sb = new StringBuilder();
			for(String keyword: "abstract assert boolean break byte case catch char class const continue default do double else enum extends final finally float for goto if implements import instanceof int interface long native new package private protected public return short static strictfp super switch synchronized this throw throws transient try void volatile while".split(" ")) { //$NON-NLS-1$ //$NON-NLS-2$
				sb.append('|');
				sb.append(getLiteralRegex(keyword));
			}
			return identifier(sb.substring(1));
		}
	},
	OPERATOR {
		@Override
		protected String getRegex() {
			StringBuilder sb = new StringBuilder();
			for(String operator: ">>>= <<= >>= >>> != %= && &= *= ++ += -- -= /= << <= == >= >> ^= |= || ! % & * + - / : < = > ? ^ | ~".split(" ")) { //$NON-NLS-1$ //$NON-NLS-2$
				sb.append('|');
				sb.append(getLiteralRegex(operator));
			}
			return String.format("(?:%s)", sb.substring(1)); //$NON-NLS-1$
		}
	},
	LITERAL_INTEGER_DECIMAL {
		@Override
		protected String getRegex() {
			String zeroDigit = getLiteralRegex('0');
			String digit = DIGIT_DECIMAL.getRegex();
			String nonZeroDigit = DIGIT_DECIMAL_NONZERO.getRegex();
			String suffix = getCharacterClass("Ll"); //$NON-NLS-1$
			return identifier(String.format("(?:%s|%s%s*)%s?", zeroDigit, nonZeroDigit, digit, suffix)); //$NON-NLS-1$
		}
	},
	LITERAL_INTEGER_HEXADECIMAL {
		@Override
		protected String getRegex() {
			String zero = getLiteralRegex('0');
			String x = getCharacterClass("Xx"); //$NON-NLS-1$
			String digit = DIGIT_HEXADECIMAL.getRegex();
			String suffix = getCharacterClass("Ll"); //$NON-NLS-1$
			return identifier(String.format("%s%s%s+%s?", zero, x, digit, suffix)); //$NON-NLS-1$
		}
	},
	LITERAL_INTEGER_OCTAL {
		@Override
		protected String getRegex() {
			String zero = getLiteralRegex('0');
			String digit = DIGIT_OCTAL.getRegex();
			String suffix = getCharacterClass("Ll"); //$NON-NLS-1$
			return identifier(String.format("%s%s+%s?", zero, digit, suffix)); //$NON-NLS-1$
		}
	},
	LITERAL_BOOLEAN {
		@Override
		protected String getRegex() {
			return identifier(getLiteralRegex("true") + '|' + getLiteralRegex("false")); //$NON-NLS-1$ //$NON-NLS-2$
		}
	},
	LITERAL_STRING_MARKER {
		@Override
		protected String getRegex() {
			return getLiteralRegex('"');
		}
	},
	LITERAL_STRING {
		@Override
		protected String getRegex() {
			return exclude(getLiteralRegex('"'), LINE_TERMINATOR.getRegex());
		}
	},
	LITERAL_CHARACTER_MARKER {
		@Override
		protected String getRegex() {
			return getLiteralRegex('\'');
		}
	},
	LITERAL_CHARACTER {
		@Override
		protected String getRegex() {
			return exclude(getLiteralRegex('\''), LINE_TERMINATOR.getRegex());
		}
	},
	ANNOTATION_MARKER {
		@Override
		protected String getRegex() {
			return getLiteralRegex('@');
		}
	},
	LITERAL_NULL {
		@Override
		protected String getRegex() {
			return identifier(getLiteralRegex("null")); //$NON-NLS-1$
		}
	},
	COMMENT_MARKER_BEGIN {
		@Override
		protected String getRegex() {
			return getLiteralRegex("/*"); //$NON-NLS-1$
		}
	},
	COMMENT_MARKER_END {
		@Override
		protected String getRegex() {
			return getLiteralRegex("*/"); //$NON-NLS-1$
		}
	},
	COMMENT {
		@Override
		protected String getRegex() {
			return exclude(COMMENT_MARKER_END);
		}
	},
	EOL_COMMENT_MARKER {
		@Override
		protected String getRegex() {
			return getLiteralRegex('/') + "{2}"; //$NON-NLS-1$
		}
	},
	EOL_COMMENT {
		@Override
		protected String getRegex() {
			return exclude(LINE_TERMINATOR);
		}
	},
	IDENTIFIER,
	ANNOTATION,
	;
	
	private final Pattern pattern;
	
	private JavaPattern() {
		this.pattern = Pattern.compile(String.format("\\A%s", getRegex())); //$NON-NLS-1$
	}
	
	protected String getRegex() {
		return "(?:\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)"; //$NON-NLS-1$
	}
	
	protected Pattern getPattern() {
		return this.pattern;
	}
	
	@Override
	public int matchLength(CharSequence text) {
		Matcher m = getPattern().matcher(text);
		return m.find() ? m.end() - m.start() : 0;
	}
	
	protected static String exclude(String... regexes) {
		StringBuilder exclude = new StringBuilder("\\Z"); //$NON-NLS-1$
		for(String r: regexes) {
			exclude.append('|');
			exclude.append(r);
		}
		return String.format("(?s)(?:[^\\\\]|\\\\.)*?(?-s)(?=%s)", exclude); //$NON-NLS-1$
	}
	
	protected static String exclude(JavaPattern... patterns) {
		StringBuilder exclude = new StringBuilder("\\Z"); //$NON-NLS-1$
		for(JavaPattern p: patterns) {
			exclude.append('|');
			exclude.append(p.getRegex());
		}
		return String.format("(?s)(?:[^\\\\]|\\\\.)*?(?-s)(?=%s)", exclude); //$NON-NLS-1$
	}
	
	protected static String getLiteralRegex(String s) {
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i != s.length(); ++i)
			ret.append(getLiteralRegex(s.charAt(i)));
		return s.length() == 1 ? ret.toString() : String.format("(?:%s)", ret.toString()); //$NON-NLS-1$
	}
	
	protected static String getLiteralRegex(char c) {
		String lit = Pattern.quote(Character.toString(c));
		String uni = Integer.toHexString(c);
		while(uni.length() < 4)
			uni = "0" + uni; //$NON-NLS-1$
		for(char h = 'a'; h <= 'f'; ++h)
			uni = uni.replaceAll(Character.toString(h), String.format("[%c%c]", //$NON-NLS-1$
					Character.valueOf((char) (h + 'A' - 'a')),
					Character.valueOf(h)));
		return String.format("(?:%s|\\\\u+%s)", lit, uni); //$NON-NLS-1$
	}
	
	protected static String getCharacterClass(String s) {
		return String.format("(?:%s)", join("|", map(new Mapper<Character, String>() { //$NON-NLS-1$ //$NON-NLS-2$
			@Override
			public String map(Character element) {
				return getLiteralRegex(element.charValue());
			}
		}, iterator(s))));
	}
	
	protected static String identifier(String s) {
		return String.format("(?:%s)(?=[^\\p{javaJavaIdentifierPart}]|\\Z)", s); //$NON-NLS-1$
	}
}
