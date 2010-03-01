package com.googlecode.lawu.lex;

import com.googlecode.lawu.util.iterators.UniversalIterator;

public interface Lexer<P extends TokenPattern> extends UniversalIterator<Token<P>> {
}
