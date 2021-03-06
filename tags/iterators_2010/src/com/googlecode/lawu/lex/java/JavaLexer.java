package com.googlecode.lawu.lex.java;

import static com.googlecode.lawu.lex.java.JavaPattern.*;

import com.googlecode.lawu.lex.AbstractLexer;
import com.googlecode.lawu.util.Iterators;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class JavaLexer extends AbstractLexer<JavaPattern> {
	private enum State {
		NORMAL {
			@SuppressWarnings("unchecked")
			@Override
			protected UniversalIterator<JavaPattern> patterns() {
				return Iterators.join(
					Iterators.iterator(COMMENT_BLOCK_BEGIN, COMMENT_EOL_BEGIN),
					JavaPattern.getKeywords(),
					JavaPattern.getOperators(),
					JavaPattern.getSeparators(),
					Iterators.iterator(
						LINE_TERMINATOR,
						WHITESPACE,
						LITERAL_CHARACTER_DELIM,
						LITERAL_STRING_DELIM,
						LITERAL_BOOLEAN_TRUE,
						LITERAL_BOOLEAN_FALSE,
						LITERAL_NULL,
						LITERAL_INTEGER,
						LITERAL_FLOATING_POINT,
						IDENTIFIER,
						ANNOTATION_BEGIN,
						SUBSTITUTE_CHARACTER)
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
				return Iterators.iterator(COMMENT_BLOCK_END, COMMENT_BLOCK_CONTENTS);
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
				return Iterators.iterator(COMMENT_EOL_CONTENTS, LINE_TERMINATOR);
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
				return Iterators.iterator(LITERAL_CHARACTER_CONTENTS);
			}

			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_CHARACTER_CONTENTS)
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
				return Iterators.iterator(LITERAL_STRING_CONTENTS, LITERAL_STRING_DELIM);
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
