package com.googlecode.lawu.parse.java;

import static com.googlecode.lawu.lex.java.JavaPattern.SEPARATOR;
import static com.googlecode.lawu.util.Iterators.adapt;
import static com.googlecode.lawu.util.Iterators.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.lex.Token;
import com.googlecode.lawu.lex.java.JavaLexer;
import com.googlecode.lawu.lex.java.JavaPattern;
import com.googlecode.lawu.parse.java.node.JavaNode;
import com.googlecode.lawu.util.Streams;
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class JavaParser {
	public JavaParser() {
	}
	
	public JavaNode parse(CharSequence text) {
		return parse(new JavaLexer(text));
	}
	
	public JavaNode parse(Iterator<Token<JavaPattern>> tokens) {
		JavaNode root = new JavaNode();
		Stack<Token<JavaPattern>> stack = new Stack<Token<JavaPattern>>(); 
		for(tokens.reset(); !tokens.isDone(); tokens.advance()) {
			JavaNode cur = new JavaNode();
			Token<JavaPattern> token = tokens.current();
			JavaPattern type = token.getType();
			String value = token.getValue();
			cur.token = token;
			switch(type) {
			case KEYWORD:
				if(value.matches("(?:package|import)")) {
					tokens.advance();
					for(Token<JavaPattern> t: readLine(tokens)) {
						JavaNode node = new JavaNode();
						node.token = t;
						cur.children.add(node);
					}
				}
				break;
			default:
			}
			root.children.add(cur);
		}
		return root;
	}
	
	protected UniversalIterator<Token<JavaPattern>> readLine(Iterator<Token<JavaPattern>> tokens) {
		List<Token<JavaPattern>> ret = new ArrayList<Token<JavaPattern>>();
		for(Token<JavaPattern> token: adapt(tokens)) {
			ret.add(token);
			if(token.getType() == SEPARATOR && token.getValue().equals(";"))
				break;
		}
		return iterator(ret);
	}
	
	public static void main(String[] arg) throws Throwable {
		StringBuilder sb = Streams.slurp(System.in);
		JavaParser parser = new JavaParser();
		parser.parse(sb).print();
	}
}
