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

import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonNumber extends AbstractJsonValue {
	private BigDecimal value;
	
	public JsonNumber() {
		this(BigDecimal.ZERO);
	}
	
	public JsonNumber(double value) {
		setValue(value);
	}

	public JsonNumber(BigInteger value) {
		setValue(value);
	}
	
	public JsonNumber(BigDecimal value) {
		setValue(value);
	}
	
	public void setValue(BigDecimal value) {
		if(value == null)
			value = BigDecimal.ZERO;
		this.value = value;
	}

	public void setValue(BigInteger value) {
		setValue(new BigDecimal(value));
	}

	public void setValue(long value) {
		setValue(BigInteger.valueOf(value));
	}
	
	public void setValue(double value) {
		setValue(BigDecimal.valueOf(value));
	}
	
	public int intValue() {
		return value.intValue();
	}

	public long longValue() {
		return value.longValue();
	}

	public double doubleValue() {
		return value.doubleValue();
	}
	
	public BigInteger bigIntegerValue() {
		return value.toBigInteger();
	}

	public BigDecimal bigDecimalValue() {
		return value;
	}
	
	@Override
	public Type getType() {
		return Type.NUMBER;
	}

	@Override
	public String toJson() {
		return value.stripTrailingZeros().toString().replaceFirst("[Ee]\\+?", "e");
	}
}
