package com.googlecode.lawu.lex;

import java.util.NoSuchElementException;

import com.googlecode.lawu.util.iterators.AbstractUniversalIterator;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public abstract class AbstractLexer<P extends TokenPattern> extends AbstractUniversalIterator<Token<P>> implements Lexer<P> {
	private StringBuilder text;
	private StringBuilder lexed;
	private Token<P> current;
	
	public AbstractLexer(CharSequence text) {
		this.text = new StringBuilder(text);
		this.lexed = new StringBuilder(this.text.length());
	}

	@Override
	public void advance() {
		String val = current().getValue();
		lexed.append(val);
		text.delete(0, val.length());
		current = null;
	}

	@Override
	public Token<P> current() {
		if(isDone())
			throw new NoSuchElementException("There is no more text to lex.");
		if(current == null)
			for(P pattern: patterns()) {
				int matchLength = pattern.matchLength(text);
				if(matchLength > 0) {
					current = new Token<P>(pattern, text.substring(0, matchLength));
					trigger(pattern);
					break;
				}
			}
		if(current == null)
			throw new RuntimeException(); // TODO better exception
		return current;
	}
	
	/**
	 * @param pattern
	 */
	protected void trigger(P pattern) {
	}
	
	protected abstract UniversalIterator<P> patterns();

	@Override
	public boolean isDone() {
		return text.length() == 0 && current == null;
	}

	@Override
	public void reset() {
		lexed.append(text);
		text = lexed;
		lexed = new StringBuilder(text.length());
	}
}
