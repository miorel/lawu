package com.googlecode.lawu.lex.bf;

import static com.googlecode.lawu.util.Iterators.grep;
import static com.googlecode.lawu.util.Iterators.iterator;
import static com.googlecode.lawu.util.Iterators.join;
import static com.googlecode.lawu.util.Iterators.map;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.lex.Token;
import com.googlecode.lawu.util.Filter;
import com.googlecode.lawu.util.Mapper;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class Bf2c {
	public Bf2c() {
	}
	
	public UniversalIterator<String> translate(CharSequence text) {
		return translate(new BfLexer(text));
	}
	
	@SuppressWarnings("unchecked")
	public UniversalIterator<String> translate(Iterator<Token<BfPattern>> iterator) {
		String endl = System.getProperty("line.separator");
		return join(
			iterator("#include <stdio.h>", endl, "int main(){int x[32768];int p;for(p=0;p<32768;++p)x[p]=0;p=0;"),
			grep(Filter.NON_NULL, map(new Mapper<Token<BfPattern>,String>() {
				@Override
				public String map(Token<BfPattern> token) {
					String ret = null;
					switch(token.getType()) {
					case DECREMENT_BYTE:
						ret = "--x[p];";
						break;
					case INCREMENT_BYTE:
						ret = "++x[p];";
						break;
					case DECREMENT_POINTER:
						ret = "--p;";
						break;
					case INCREMENT_POINTER:
						ret = "++p;";
						break;
					case INPUT:
						ret = "x[p]=getchar();";
						break;
					case OUTPUT:
						ret = "putchar(x[p]);";
						break;
					case CONTINUE:
						ret = "}";
						break;
					case WHILE_NOT_ZERO:
						ret = "while(x[p]){";
						break;
					default:
						break;
					}
					return ret;
				}
			}, iterator)),
			iterator("return 0;}", endl)
		);
	}
}
