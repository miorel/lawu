/*
 * Copyright (C) 2010 Miorel-Lucian Palii
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
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

	public JsonValue get(String... keys) {
		JsonValue ret = this;
		for(String key: keys)
			ret = ((JsonObject) ret).get(key);
		return ret;
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
