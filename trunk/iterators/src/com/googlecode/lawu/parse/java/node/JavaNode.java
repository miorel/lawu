package com.googlecode.lawu.parse.java.node;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.lawu.lex.Token;
import com.googlecode.lawu.lex.java.JavaPattern;

public class JavaNode {
	public Token<JavaPattern> token;
	public List<JavaNode> children = new ArrayList<JavaNode>();
	
	public void print() {
		print("");
	}
	
	public void print(String prefix) {
		if(token != null)
			System.out.println(prefix + token.getType() + " = " + token.getValue().replaceAll("\\r", "\\\\r").replaceAll("\\n", "\\\\n"));
		for(JavaNode node: children)
			node.print("  " + prefix);
	}
}
