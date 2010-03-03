package com.googlecode.lawu.lex.java;

import static com.googlecode.lawu.lex.java.JavaPattern.ANNOTATION_BEGIN;
import static com.googlecode.lawu.lex.java.JavaPattern.COMMENT_BLOCK;
import static com.googlecode.lawu.lex.java.JavaPattern.COMMENT_BLOCK_BEGIN;
import static com.googlecode.lawu.lex.java.JavaPattern.COMMENT_BLOCK_END;
import static com.googlecode.lawu.lex.java.JavaPattern.COMMENT_EOL;
import static com.googlecode.lawu.lex.java.JavaPattern.COMMENT_EOL_BEGIN;
import static com.googlecode.lawu.lex.java.JavaPattern.IDENTIFIER;
import static com.googlecode.lawu.lex.java.JavaPattern.KEYWORD;
import static com.googlecode.lawu.lex.java.JavaPattern.LINE_TERMINATOR;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_BOOLEAN;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_CHARACTER;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_CHARACTER_DELIM;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_FLOATING_POINT;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_INTEGER;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_NULL;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_STRING;
import static com.googlecode.lawu.lex.java.JavaPattern.LITERAL_STRING_DELIM;
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
					COMMENT_BLOCK_BEGIN,
					COMMENT_EOL_BEGIN,
					LINE_TERMINATOR,
					WHITESPACE,
					LITERAL_CHARACTER_DELIM,
					LITERAL_STRING_DELIM,
					LITERAL_BOOLEAN,
					LITERAL_NULL,
					LITERAL_INTEGER,
					LITERAL_FLOATING_POINT,
					KEYWORD,
					OPERATOR,
					SEPARATOR,
					IDENTIFIER,
					ANNOTATION_BEGIN,
					SUBSTITUTE_CHARACTER
				);
			}
			
			@Override
			protected void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern != null)
					switch(pattern) {
					case COMMENT_BLOCK_BEGIN:
						lexer.setState(IN_COMMENT);
						break;
					case COMMENT_EOL_BEGIN:
						lexer.setState(IN_EOL_COMMENT);
						break;
					case LITERAL_CHARACTER_DELIM:
						lexer.setState(IN_LITERAL_CHARACTER);
						break;
					case LITERAL_STRING_DELIM:
						lexer.setState(IN_LITERAL_STRING);
						break;
					case ANNOTATION_BEGIN:
						lexer.setState(IN_ANNOTATION);
						break;
					default:
						break;
					}
			}
		},
		IN_COMMENT {
			protected UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(COMMENT_BLOCK_END, COMMENT_BLOCK);
			}

			@Override
			protected void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern != null)
					switch(pattern) {
					case COMMENT_BLOCK_END:
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
				return Iterators.iterator(COMMENT_EOL, LINE_TERMINATOR);
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
				return Iterators.iterator(LITERAL_CHARACTER_DELIM);
			}

			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_CHARACTER_DELIM)
					lexer.setState(NORMAL);
			}
		},
		IN_LITERAL_STRING {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(LITERAL_STRING, LITERAL_STRING_DELIM);
			}

			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_STRING_DELIM)
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
