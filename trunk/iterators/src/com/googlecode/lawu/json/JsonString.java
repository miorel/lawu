package com.googlecode.lawu.json;

import static com.googlecode.lawu.util.Iterators.iterator;

public class JsonString extends AbstractJsonValue {
	private String value;
	
	public JsonString() {
		this("");
	}
	
	public JsonString(CharSequence value) {
		setValue(value);
	}
	
	public void setValue(CharSequence value) {
		this.value = value == null ? "" : value.toString();
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public Type getType() {
		return Type.STRING;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof JsonString && this.value.equals(((JsonString) o).value);
	}
	
	@Override
	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("\"");
		for(char c: iterator(value)) {
			switch(c) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '/':
				sb.append("\\/");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			default:
				if(Character.getType(c) == Character.CONTROL)
					sb.append(String.format("\\u%04x", (int) c));
				else
					sb.append(c);
				break;
			}
		}
		sb.append("\"");
		return sb.toString();
	}
}
