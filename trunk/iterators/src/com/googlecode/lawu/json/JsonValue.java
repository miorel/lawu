package com.googlecode.lawu.json;

public interface JsonValue {
	public enum Type {
		STRING, NUMBER, OBJECT, ARRAY, BOOLEAN, NULL
	}
	
	public Type getType();
	
	public String toJson();
}
