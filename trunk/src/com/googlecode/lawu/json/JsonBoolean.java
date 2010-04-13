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

import java.util.Locale;

public class JsonBoolean implements JsonValue {
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
		return this.value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public void setValue(CharSequence value) {
		value = value.toString().toLowerCase(Locale.ENGLISH);
		if(value.equals("true"))
			this.value = true;
		else if(value.equals("false"))
			this.value = false;
		else
			throw new IllegalArgumentException("argument is not \"true\" or \"false\"");
	}

	@Override
	public String toJson() {
		return this.value ? "true" : "false";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj == this || (obj instanceof JsonBoolean && this.value == ((JsonBoolean) obj).value);
	}
	
	@Override
	public int hashCode() {
		return this.value ? 3 : 2;
	}
	
	@Override
	public String toString() {
		return "JSON boolean: " + toJson();
	}
}
