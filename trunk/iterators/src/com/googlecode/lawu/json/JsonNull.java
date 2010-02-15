package com.googlecode.lawu.json;

public class JsonNull extends AbstractJsonValue {
	private static final JsonNull instance = new JsonNull(); 
	
	private JsonNull() {
	}

	public static JsonNull getInstance() {
		return instance;
	}
	
	@Override
	public Type getType() {
		return Type.NULL;
	}

	@Override
	public String toJson() {
		return "null";
	}
	
	@Override
	public String toString() {
		return "JSON null";
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof JsonNull;
	}
}
