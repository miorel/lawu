/**
 * 
 */
package lawu.lex.bf;

import lawu.lex.AbstractLexer;
import lawu.lex.Token;
import lawu.util.Files;
import lawu.util.iterator.Iterators;
import lawu.util.iterator.UniversalIterator;

/**
 * @author Miorel-Lucian Palii
 */
public class BfLexer extends AbstractLexer<BfPattern> {
	public BfLexer(CharSequence text) {
		super(text);
	}

	@Override
	protected UniversalIterator<BfPattern> patterns() {
		return Iterators.iterator(BfPattern.values());
	}
	
	public static void main(String[] arg) throws Throwable {
		StringBuilder sb = Files.slurp(System.in);
		for(Token<BfPattern> token: new BfLexer(sb))
			System.out.printf("%s %d %s\n", token.getType(), //$NON-NLS-1$
					Integer.valueOf(token.getValue().length()),
					token.getValue());
	}
}
