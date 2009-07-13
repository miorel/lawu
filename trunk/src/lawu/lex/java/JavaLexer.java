/**
 * 
 */
package lawu.lex.java;

import lawu.lex.AbstractLexer;
import lawu.lex.Token;
import lawu.util.Files;
import lawu.util.iterator.Iterators;
import lawu.util.iterator.UniversalIterator;

import static lawu.lex.java.JavaPattern.*;

/**
 * @author Miorel-Lucian Palii
 */
public class JavaLexer extends AbstractLexer<JavaPattern> {
	private enum State {
		NORMAL {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(new JavaPattern[] {
						COMMENT_MARKER_BEGIN,
						EOL_COMMENT_MARKER,
						LINE_TERMINATOR,
						WHITESPACE,
						KEYWORD,
						LITERAL_INTEGER_DECIMAL,
						LITERAL_INTEGER_HEXADECIMAL,
						LITERAL_INTEGER_OCTAL,
						LITERAL_NULL,
						LITERAL_BOOLEAN,
						LITERAL_STRING_MARKER,
						LITERAL_CHARACTER_MARKER,
						ANNOTATION_MARKER,
						SEPARATOR,
						OPERATOR,
						IDENTIFIER,
				});
			}
			
			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern != null)
					switch(pattern) {
					case EOL_COMMENT_MARKER:
						lexer.setState(IN_EOL_COMMENT);
						break;
					case COMMENT_MARKER_BEGIN:
						lexer.setState(IN_COMMENT);
						break;
					case LITERAL_STRING_MARKER:
						lexer.setState(IN_STRING);
						break;
					case LITERAL_CHARACTER_MARKER:
						lexer.setState(IN_CHARACTER);
						break;
					case ANNOTATION_MARKER:
						lexer.setState(IN_ANNOTATION);
						break;
					default:
						break;
					}
			}
		},
		IN_STRING {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(new JavaPattern[] {
						LITERAL_STRING,
				});
			}
			
			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_STRING)
					lexer.setState(ENDING_STRING);
			}			
		},
		ENDING_STRING {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(new JavaPattern[] {
						LITERAL_STRING_MARKER,
				});
			}
			
			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_STRING_MARKER)
					lexer.setState(NORMAL);
			}
		},
		IN_CHARACTER {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(new JavaPattern[] {
						LITERAL_CHARACTER,
				});
			}
			
			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_CHARACTER)
					lexer.setState(ENDING_CHARACTER);
			}			
		},
		ENDING_CHARACTER {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(new JavaPattern[] {
						LITERAL_CHARACTER_MARKER,
				});
			}
			
			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LITERAL_CHARACTER_MARKER)
					lexer.setState(NORMAL);
			}
		},
		IN_COMMENT {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(new JavaPattern[] {
						COMMENT,
						COMMENT_MARKER_END,
				});
			}
			
			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == COMMENT_MARKER_END)
					lexer.setState(NORMAL);
			}
		},
		IN_EOL_COMMENT {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(new JavaPattern[] {
						EOL_COMMENT,
						LINE_TERMINATOR,
				});
			}
			
			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == LINE_TERMINATOR)
					lexer.setState(NORMAL);
			}
		},
		IN_ANNOTATION {
			@Override
			public UniversalIterator<JavaPattern> patterns() {
				return Iterators.iterator(new JavaPattern[] {
						WHITESPACE,
						ANNOTATION,
				});
			}
			
			@Override
			public void trigger(JavaLexer lexer, JavaPattern pattern) {
				if(pattern == ANNOTATION)
					lexer.setState(NORMAL);
			}			
		};
		
		public abstract UniversalIterator<JavaPattern> patterns();
		
		public void trigger(@SuppressWarnings("unused") JavaLexer lexer, @SuppressWarnings("unused") JavaPattern pattern) {
		}
	}
	
	private State state;
	
	public JavaLexer(CharSequence text) {
		super(text);
		setState(State.NORMAL);
	}

	@Override
	protected UniversalIterator<JavaPattern> patterns() {
		return this.state.patterns();
	}
	
	@Override
	protected void trigger(JavaPattern pattern) {
		this.state.trigger(this, pattern);
	}
	
	protected void setState(State state) {
		this.state = state;
	}
	
	public static void main(String[] arg) throws Throwable {
		StringBuilder sb = Files.slurp(System.in);
		for(Token<JavaPattern> token: new JavaLexer(sb))
			System.out.printf("%s %d %s\n", token.getType(), //$NON-NLS-1$
					Integer.valueOf(token.getValue().length()),
					token.getValue());
	}
}
