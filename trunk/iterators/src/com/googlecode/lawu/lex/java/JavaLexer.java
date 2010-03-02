package com.googlecode.lawu.lex.java;

import static com.googlecode.lawu.lex.java.JavaPattern.ANNOTATION_MARKER;
import static com.googlecode.lawu.lex.java.JavaPattern.COMMENT;
import static com.googlecode.lawu.lex.java.JavaPattern.COMMENT_MARKER_BEGIN;
import static com.googlecode.lawu.lex.java.JavaPattern.COMMENT_MARKER_END;
import static com.googlecode.lawu.lex.java.JavaPattern.EOL_COMMENT;
import static com.googlecode.lawu.lex.java.JavaPattern.EOL_COMMENT_MARKER;
import static com.googlecode.lawu.lex.java.JavaPattern.IDENTIFIER;
import static com.googlecode.lawu.lex.java.JavaPattern.KEYWORD;
import static com.googlecode.lawu.lex.java.JavaPattern.LINE_TERMINATOR;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_BOOLEAN;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_CHARACTER;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_CHARACTER_MARKER;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_FLOATING_POINT;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_INTEGER;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_NULL;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_STRING;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_STRING_MARKER;
import static com.googlecode.lawu.lex.java.JavaPattern.OPERATOR;
import static com.googlecode.lawu.lex.java.JavaPattern.SEPARATOR;
import static com.googlecode.lawu.lex.java.JavaPattern.SUBSTITUTE_CHARACTER;
import static com.googlecode.lawu.lex.java.JavaPattern.WHITESPACE;

import com.googlecode.lawu.lex.AbstractLexer;
import com.googlecode.lawu.util.Iterators;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class JavaLexer extends AbstractLexer<JavaPattern> {
	private enum State {
		NORMAL {
			@Override
			protected UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(
					COMMENT_MARKER_BEGIN,
					EOL_COMMENT_MARKER,
					LINE_TERMINATOR,
					WHITESPACE,
					LITERAL_CHARACTER_MARKER,
					LITERAL_STRING_MARKER,
					LITERAL_BOOLEAN,
					LITERAL_NULL,
					LITERAL_INTEGER,
					LITERAL_FLOATING_POINT,
					KEYWORD,
					OPERATOR,
					SEPARATOR,
					IDENTIFIER,
					ANNOTATION_MARKER,
					SUBSTITUTE_CHARACTER
				);
			}
			
			@Override
			protected void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern != null)
					switch(pattern) {
					case COMMENT_MARKER_BEGIN:
						lexer.setState(IN_COMMENT);
						break;
					case EOL_COMMENT_MARKER:
						lexer.setState(IN_EOL_COMMENT);
						break;
					case LITERAL_CHARACTER_MARKER:
						lexer.setState(IN_LITERAL_CHARACTER);
						break;
					case LITERAL_STRING_MARKER:
						lexer.setState(IN_LITERAL_STRING);
						break;
					case ANNOTATION_MARKER:
						lexer.setState(IN_ANNOTATION);
						break;
					default:
						break;
					}
			}
		},
		IN_COMMENT {
			protected UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(COMMENT_MARKER_END, COMMENT);
			}

			@Override
			protected void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern != null)
					switch(pattern) {
					case COMMENT_MARKER_END:
						lexer.setState(NORMAL);
						break;
					default:
						break;
					}
			}
		},
        IN_EOL_COMMENT {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(EOL_COMMENT, LINE_TERMINATOR);
			}

			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LINE_TERMINATOR)
					lexer.setState(NORMAL);
			}
		},
		IN_LITERAL_CHARACTER {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(LITERAL_CHARACTER);
			}

			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_CHARACTER)
					lexer.setState(ENDING_LITERAL_CHARACTER);
			}
		},
		ENDING_LITERAL_CHARACTER {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(LITERAL_CHARACTER_MARKER);
			}

			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_CHARACTER_MARKER)
					lexer.setState(NORMAL);
			}
		},
		IN_LITERAL_STRING {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(LITERAL_STRING, LITERAL_STRING_MARKER);
			}

			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_STRING_MARKER)
					lexer.setState(NORMAL);
			}
		},
		IN_ANNOTATION {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(IDENTIFIER);
			}

			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == IDENTIFIER)
					lexer.setState(NORMAL);
			}
		};
		
		protected abstract UniversalIterator<JavaPattern> patterns();
		
		protected abstract void trigger(JavaLexer lexer, JavaPattern pattern);
	}
	
	private State state = State.NORMAL;
	
	public JavaLexer(CharSequence text) {
		super(JavaUnicodeEscapeTranslator.getInstance().decode(text));
	}
	
	protected void setState(State state) {
		this.state = state;
	}
	
	@Override
	protected UniversalIterator<JavaPattern> patterns() {
		return state.patterns();
	}
	
	@Override
	protected void trigger(JavaPattern pattern) {
		state.trigger(this, pattern);
	}
}
