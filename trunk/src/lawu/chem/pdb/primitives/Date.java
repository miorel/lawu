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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author Miorel-Lucian Palii
 */
public class Date {
	private long date;
	
	private final static DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy", Locale.US); //$NON-NLS-1$
	private final static Calendar prototype = new GregorianCalendar();
	
	public Date() {
		this(prototype);
	}
	
	public Date(Calendar date) {
		setDate(date);
	}
	
	public Date(java.util.Date date) {
		setDate(date);
	}
	
	public Date(java.lang.String date) {
		setDate(date);
	}

	public Date(long date) {
		setDate(date);
	}
	
	protected void setDate(java.lang.String date) {
		if(date == null)
			throw new NullPointerException("");
		java.lang.String d = date.toUpperCase();
		if(!d.matches("\\d{1,2}-[A-Z]{3}-\\d{2}")) //$NON-NLS-1$
			throw new RuntimeException("");
		try {
			setDate(dateFormat.parse(d));		
		}
		catch(ParseException e) {
			throw new RuntimeException("");
		}
	}
	
	protected void setDate(java.util.Date date) {
		if(date == null)
			throw new NullPointerException("");
		Calendar c = (Calendar) prototype.clone();
		c.setTime(date);
		setDate(c);
	}
	
	protected void setDate(Calendar date) {
		if(date == null)
			throw new NullPointerException("");
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH);
		int year = date.get(Calendar.YEAR);
		date.clear();
		date.set(year, month, day);
		this.date = date.getTimeInMillis();
	}

	protected void setDate(long date) {
		setDate(new java.util.Date(date));
	}
	
	protected java.lang.String formatDate(Object o) {
		return java.lang.String.format(Locale.US, "%1$td-%1$Tb-%1$ty", o); //$NON-NLS-1$
	}
	
	public java.util.Date getDate() {
		return getDateAsCalendar().getTime();
	}
	
	public Calendar getDateAsCalendar() {
		Calendar ret = (Calendar) prototype.clone();
		ret.setTimeInMillis(this.date);
		return ret;
	}
	
	public long getDateAsLong() {
		return this.date;
	}

	@Override
	public java.lang.String toString() {
		return formatDate(Long.valueOf(this.date));
	}

	@Override
	public int hashCode() {
		return (int) (this.date ^ (this.date >>> 32));
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Date)
			ret = this.date == ((Date) o).date;
		return ret;
	}
}
