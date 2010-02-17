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

import static com.googlecode.lawu.util.Arrays.box;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;

import com.googlecode.lawu.util.Randomness;

@Ignore
public class TestCases {
	private final int RANDOM_SIZE = 1 << 12;
	
	public TestCases() {
	}
	
	public Iterable<Integer[]> getIntegerArrays() {
		List<Integer[]> list = new ArrayList<Integer[]>();
		list.add(box(new int[] {}));
		list.add(box(new int[] {42}));
		list.add(box(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
		list.add(box(new int[] {3, 1, 4, 1, 5, 9}));
		list.add(box(new int[] {1, 3, 3, 7}));
		list.add(box(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
		for(int i = -10; i <= 10; ++i)
			list.add(box(new int[] {i}));
		list.add(box(new int[] {-29}));
		list.add(box(new int[] {Integer.MIN_VALUE}));
		list.add(box(new int[] {Integer.MAX_VALUE}));
		list.add(box(new int[] {4, -27, 999, 0, 0, 37, 4, 4, 2, 4, Integer.MIN_VALUE, -5, -1, -2, -4, 4, Integer.MAX_VALUE}));
		list.add(box(Randomness.nextInts(RANDOM_SIZE)));
		return list;
	}
	
	public Iterable<String> getStrings() {
		List<String> list = new ArrayList<String>();
		list.add("");
		for(char c = 0; c < (1 << 8); ++c)
			list.add(Character.toString(c));
		list.add("Hello World!");
		list.add("Jag k\u00e4nner en bot.");
		list.add("You just lost the game.");
		list.add("The quick brown fox jumps over the lazy dog.");
		list.add("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		list.add("                ");
		list.add("\r\n");
		StringBuilder sb = new StringBuilder(RANDOM_SIZE);
		for(int i = 0; i < RANDOM_SIZE; ++i)
			sb.append((char) Randomness.nextInt(Character.MIN_VALUE, Character.MAX_VALUE));
		list.add(sb.toString());
		return list;
	}
}
