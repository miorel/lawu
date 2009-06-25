/**
 * 
 */
package lawu.lex;

public interface TokenPattern<L extends Lexer<L, S, P>, S extends LexerState, P extends TokenPattern<L, S, P>> {
	public int matchLength(L abstractLexer, CharSequence text);
}
