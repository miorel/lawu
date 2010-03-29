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
