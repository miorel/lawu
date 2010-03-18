package com.googlecode.lawu.parse;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public String type;
	public String value;
	
	public final List<Node> children = new ArrayList<Node>();  
}
