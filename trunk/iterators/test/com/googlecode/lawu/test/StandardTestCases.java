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
package com.googlecode.lawu.test;

public class StandardTestCases {
	@SuppressWarnings("boxing")
	public static final Integer[][] INTEGER_ARRAYS = {
		{},
		{42},
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
		{3, 1, 4, 1, 5, 9},
		{1, 3, 3, 7},
		{10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
		{0},
		{-29},
		{Integer.MIN_VALUE},
		{Integer.MAX_VALUE},
		{4, -27, 999, 0, 0, 4, 4, 2, 4, Integer.MIN_VALUE, -5, -1, -2, -4, 4, Integer.MAX_VALUE},
	};
	
	private StandardTestCases() {
	}
}
