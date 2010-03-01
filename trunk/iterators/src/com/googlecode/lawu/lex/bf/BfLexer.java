/**
 * 
 */
package com.googlecode.lawu.lex.bf;

import com.googlecode.lawu.lex.AbstractLexer;
import com.googlecode.lawu.util.Iterators;
import com.googlecode.lawu.util.iterators.UniversalIterator;

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
}
