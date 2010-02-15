package com.googlecode.lawu.json;

public abstract class AbstractJsonValue implements JsonValue {
	@Override
	public String toString() {
		return String.format("JSON %s: %s", getType().toString().toLowerCase(), toJson());
	}
}
