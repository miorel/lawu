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
package com.googlecode.lawu.net.www.spoj;

public enum Result {
	AC("accepted"),
	CE("compilation error"),
	RE("runtime error"),
	SE("system error"),
	TLE("time limit exceeded"),
	WA("wrong answer"),
	PENDING("??", "pending");
	
	private final String abbreviation;
	private final String title;	
	
	private Result(String title) {
		this.abbreviation = toString();
		this.title = title;
	}
	
	private Result(String abbreviation, String title) {
		this.abbreviation = abbreviation;
		this.title = title;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}

	public String getTitle() {
		return title;
	}
	
	public static Result forAbbreviation(String abbreviation) {
		Result ret = null;
		for(Result res: Result.values())
			if(res.abbreviation.equals(abbreviation)) {
				ret = res;
				break;
			}
		return ret;
	}
}
