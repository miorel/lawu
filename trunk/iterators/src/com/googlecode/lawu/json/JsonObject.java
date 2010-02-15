package com.googlecode.lawu.json;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.lawu.util.DelegatingMap;
import com.googlecode.lawu.util.Iterators;
import com.googlecode.lawu.util.Mapper;
import com.googlecode.lawu.util.Strings;

public class JsonObject extends DelegatingMap<String, JsonValue> implements JsonValue {
	private final Map<String, JsonValue> map;
	
	public JsonObject() {
		this.map = new HashMap<String, JsonValue>();
	}

	public JsonObject(int initialCapacity, float loadFactor) {
		this.map = new HashMap<String, JsonValue>(initialCapacity, loadFactor);
	}

	public JsonObject(int initialCapacity) {
		this.map = new HashMap<String, JsonValue>(initialCapacity);
	}

	public JsonObject(Map<? extends String, ? extends JsonValue> m) {
		this.map = new HashMap<String, JsonValue>(m);
	}

	@Override
	public Type getType() {
		return Type.OBJECT;
	}

	@Override
	protected Map<String, JsonValue> getDelegate() {
		return map;
	}

	@Override
	public String toJson() {
		return String.format("{%s}", Strings.join(",", Iterators.map(new Mapper<Entry<String, JsonValue>, String>() {
			@Override
			public String map(Entry<String, JsonValue> entry) {
				return String.format("%s:%s", new JsonString(entry.getKey()).toJson(), entry.getValue().toJson());
			}
		}, Iterators.adapt(entrySet().iterator()))));
	}
	
	@Override
	public String toString() {
		return "JSON object: " + toJson();
	}
}
