/**
 * 
 */
package lawu.lex.bf;

import lawu.lex.AbstractLexer;
import lawu.util.iterator.Iterators;
import lawu.util.iterator.UniversalIterator;

public class BfLexer extends AbstractLexer<BfLexer, BfState, BfPattern> {
	public BfLexer(CharSequence text) {
		super(null, text);
	}

	@Override
	protected UniversalIterator<BfPattern> patterns() {
		return Iterators.iterator(BfPattern.values());
	}
}
