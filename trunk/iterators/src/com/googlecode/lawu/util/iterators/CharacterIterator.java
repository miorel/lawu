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
package com.googlecode.lawu.util.iterators;

/**
 * An iterator over the characters of a <code>CharSequence</code>.
 * 
 * @author Miorel-Lucian Palii
 */
public class CharacterIterator extends ListIterator<Character> {
	private final CharSequence sequence;

	/**
	 * Constructs an iterator over the characters of the specified
	 * <code>CharSequence</code>.
	 * 
	 * @param sequence
	 *            sequence over whose characters to iterate
	 */
	public CharacterIterator(CharSequence sequence) {
		super(0, sequence.length());
		this.sequence = sequence;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Character get(int position) {
		return Character.valueOf(sequence.charAt(position));
	}
}
