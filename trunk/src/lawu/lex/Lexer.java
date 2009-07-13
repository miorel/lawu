package lawu.lex;

import lawu.util.iterator.UniversalIterator;

public interface Lexer<P extends TokenPattern> extends UniversalIterator<Token<P>> {
}
