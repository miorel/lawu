package com.googlecode.lawu.parse;

import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public final String type;
	public final List<Node> children = new ArrayList<Node>();
	
	public Node(String type) {
		this.type = type;
	}
	
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Node) {
			Node n = (Node) o;
			ret = n.type.equals(type) && n.children.equals(children);
		}
		return ret;
	}
	
	public int hashCode() {
		return type.hashCode();
	}
	
	public void print(PrintStream stream) {
		print(stream, "");
	}

	private void print(PrintStream stream, String indent) {
		stream.println(indent + type);
		for(Node child: children)
			child.print(stream, indent + "  ");
	}
}
