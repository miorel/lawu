package com.googlecode.lawu.lex;

public class Token<P extends TokenPattern> {
	private final P type;
	private final String value;
	
	public Token(P type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public P getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}
}

