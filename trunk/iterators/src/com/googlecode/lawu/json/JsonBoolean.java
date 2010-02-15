package com.googlecode.lawu.json;

public class JsonBoolean extends AbstractJsonValue {
	private boolean value;
	
	public JsonBoolean() {
		this(false);
	}
	
	public JsonBoolean(boolean value) {
		setValue(value);
	}
	
	public JsonBoolean(String value) {
		setValue(value);
	}
	
	public boolean getValue() {
		return value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public void setValue(CharSequence value) {
		value = value.toString().toLowerCase();
		if(value.equals("true"))
			this.value = true;
		else if(value.equals("false"))
			this.value = false;
		else
			throw new IllegalArgumentException("argument is not \"true\" or \"false\"");
	}
	
	@Override
	public Type getType() {
		return Type.BOOLEAN;
	}

	@Override
	public String toJson() {
		return value ? "true" : "false";
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof JsonBoolean && this.value == ((JsonBoolean) o).value;
	}
	
	@Override
	public int hashCode() {
		return value ? 3 : 2;
	}
}
