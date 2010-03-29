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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.util.DelegatingList;
import com.googlecode.lawu.util.Iterators;
import com.googlecode.lawu.util.Mapper;
import com.googlecode.lawu.util.Strings;

public class JsonArray extends DelegatingList<JsonValue> implements JsonValue {
	private final List<JsonValue> list;
	
	public JsonArray() {
		this.list = new ArrayList<JsonValue>();
	}

	public JsonArray(Collection<? extends JsonValue> c) {
		this.list = new ArrayList<JsonValue>(c);
	}

	public JsonArray(JsonValue... values) {
		this(Iterators.iterator(values));
	}

	public JsonArray(Iterator<JsonValue> values) {
		this();
		for(JsonValue value: Iterators.adapt(values))
			this.list.add(value);
	}
	
	public JsonArray(int initialCapacity) {
		this.list = new ArrayList<JsonValue>(initialCapacity);
	}

	@Override
	public Type getType() {
		return Type.ARRAY;
	}

	@Override
	protected List<JsonValue> getDelegate() {
		return list;
	}

	@Override
	public String toJson() {
		return String.format("[%s]", Strings.join(",", Iterators.map(new Mapper<JsonValue, String>() {
			@Override
			public String map(JsonValue value) {
				return value.toJson();
			}
		}, iterator())));
	}
	
	@Override
	public String toString() {
		return "JSON array: " + toJson();
	}
}
