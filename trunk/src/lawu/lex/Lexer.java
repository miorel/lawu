package lawu.lex;

import lawu.util.iterator.UniversalIterator;

public interface Lexer<L extends Lexer<L, S, P>, S extends LexerState, P extends TokenPattern<L, S, P>> extends UniversalIterator<Token<P>> {
	public S getState();
}
