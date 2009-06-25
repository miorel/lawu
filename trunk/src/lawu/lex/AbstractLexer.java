/**
 * 
 */
package lawu.lex;

import lawu.util.iterator.AbstractUniversalIterator;
import lawu.util.iterator.UniversalIterator;

public abstract class AbstractLexer<L extends Lexer<L, S, P>, S extends LexerState, P extends TokenPattern<L, S, P>> extends AbstractUniversalIterator<Token<P>> implements Lexer<L, S, P> {
	private S state;
	private StringBuilder text;
	private StringBuilder lexed;
	private Token<P> current;
	
	public AbstractLexer(S state, CharSequence text) {
		setState(state);
		this.text = new StringBuilder(text);
		this.lexed = new StringBuilder(this.text.length());
	}
	
	@Override
	public S getState() {
		return this.state;
	}
	
	void setState(S state) {
		this.state = state;
	}

	@Override
	public void advance() {
		String val = current().getValue();
		this.lexed.append(val);
		this.text.delete(0, val.length());
		this.current = null;
	}

	@Override
	public Token<P> current() {
		if(this.current == null && !isDone())
			for(P pattern: patterns()) {
				int matchLength = pattern.matchLength((L) this, this.text);
				if(matchLength != 0) {
					this.current = new Token<P>(pattern, this.text.substring(0, matchLength));
					break;
				}
			}
		if(this.current == null)
			throw new RuntimeException("");
		return this.current;
	}
	
	protected abstract UniversalIterator<P> patterns();

	@Override
	public boolean isDone() {
		return this.text.length() == 0;
	}

	@Override
	public void reset() {
		this.lexed.append(this.text);
		this.text = this.lexed;
		this.lexed = new StringBuilder(this.text.length());
	}
}
