/*
 * lawu
 * Copyright (C) 2009 Miorel-Lucian Palii
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
package lawu.chem.pdb.primitives;

import java.util.Locale;

/**
 * @author Miorel-Lucian Palii
 */
public class Real {
	private double value;
	private int width;
	private int precision;
	
	public Real(java.lang.String value, int width, int precision) {
		setWidth(width);
		setPrecision(precision);
		setValue(value);
	}
	
	public Real(double value, int width, int precision) {
		setWidth(width);
		setPrecision(precision);
		setValue(value);
	}
	
	protected void setWidth(int width) {
		if(width < 0)
			throw new RuntimeException("");
		this.width = width;
	}
	
	protected void setPrecision(int precision) {
		if(precision < 0)
			throw new RuntimeException("");
		this.precision = precision;
	}
	
	protected void setValue(java.lang.String value) {
		if(value == null)
			throw new NullPointerException("");
		if(!value.matches(" *-?\\d+\\.?\\d*")) //$NON-NLS-1$
			throw new RuntimeException("");
		setValue(Double.parseDouble(value.trim()));
	}
	
	protected void setValue(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return this.value;
	}
	
	@Override
	public java.lang.String toString() {
		java.lang.String format = java.lang.String.format("%%%d.%d", //$NON-NLS-1$
				java.lang.Integer.valueOf(this.width),
				java.lang.Integer.valueOf(this.precision)); 
		return java.lang.String.format(Locale.US, format,
				Double.valueOf(this.value));
	}
	
	@Override
	public int hashCode() {
		return Double.valueOf(this.value).hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Real) {
			Real r = (Real) o;
			ret = this.width == r.width && this.precision == r.precision
				&& Double.valueOf(this.value).equals(Double.valueOf(r.value));
		}
		return ret;
	}
}
