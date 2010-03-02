package com.googlecode.lawu.parse.java;

import static com.googlecode.lawu.lex.java.JavaPattern.TERMINALS;
import static com.googlecode.lawu.util.Iterators.adapt;
import static com.googlecode.lawu.util.Iterators.grep;
import static com.googlecode.lawu.util.Iterators.iterator;
import static com.googlecode.lawu.util.Iterators.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.lex.Token;
import com.googlecode.lawu.lex.java.JavaLexer;
import com.googlecode.lawu.lex.java.JavaPattern;
import com.googlecode.lawu.util.Strings;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class JavaParser {
	private final List<Token<JavaPattern>> list;
	
	private List<String> imports;
	
	public JavaParser(CharSequence text) {
		this(new JavaLexer(text));
	}
	
	public JavaParser(Iterator<Token<JavaPattern>> iterator) {
		this.list = list(iterator);
	}
	
	protected UniversalIterator<Token<JavaPattern>> getTerminals() {
		return grep(TERMINALS, iterator(list));
	}
	
	protected UniversalIterator<String> getImports() {
		synchronized(list) {
			if(imports == null) {
				imports = new ArrayList<String>();
				UniversalIterator<Token<JavaPattern>> iter = getTerminals();
				for(Token<JavaPattern> token: iter)
					if(token.getType() == JavaPattern.KEYWORD && token.getValue().equals("import")) {
						Queue<String> q = new LinkedList<String>();
						for(Token<JavaPattern> succ: iter) {
							if(succ.getType() == JavaPattern.SEPARATOR && succ.getValue().equals(";"))
								break;
							q.add(succ.getValue());
						}
						boolean isStatic = false;
						if(!q.isEmpty() && q.peek().equals("static")) {
							isStatic = true;
							q.poll();
						}
						String imp = Strings.join("", adapt(q));
						if(isStatic)
							imp = "static " + imp;
						imports.add(imp);
					}
			}
		}
		return iterator(imports);
	}
	
	public static void main(String[] arg) throws Throwable {
		/*StringBuilder sb = Streams.slurp(System.in);
		JavaParser parser = new JavaParser(sb);
		for(String imp: parser.getImports())
			System.out.println(imp);
		for(Token<JavaPattern> token: parser.getTerminals())
			System.out.printf("%25s %4d %s%n", token.getType(), Integer.valueOf(token.getValue().length()), token.getValue());*/
	}
}
