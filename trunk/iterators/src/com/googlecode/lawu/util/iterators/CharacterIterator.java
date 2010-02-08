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
 * <p>
 * An iterator over the characters of a <code>CharSequence</code>.
 * </p>
 * 
 * <p>
 * There is no defense mechanism preventing modification of the underlying
 * sequence while this iterator is in use. Any changes will therefore propagate
 * through to users of this iterator. Taking advantage of this is discouraged.
 * </p>
 * 
 * @author Miorel-Lucian Palii
 */
public class CharacterIterator extends AbstractUniversalIterator<Character> {
	private final CharSequence sequence;
	private int pointer;

	/**
	 * Constructs an iterator over the characters of the specified
	 * <code>CharSequence</code>.
	 *  
	 * @param sequence sequence over whose characters to iterate
	 */
	public CharacterIterator(CharSequence sequence) {
		if(sequence == null)
			throw new IllegalArgumentException("Can't iterate over null sequence.");
		this.sequence = sequence;
		reset();
	}
	
	/**
	 * Advances this iterator to the next position in the sequence.
	 */
	@Override
	public void advance() {
		++pointer;
	}

	/**
	 * Retrieves the current character in the sequence.
	 * 
	 * @return the current character
	 */
	@Override
	public Character current() {
		return Character.valueOf(sequence.charAt(pointer));
	}

	/**
	 * Checks whether this iterator has reached the end of the sequence.
	 * 
	 * @return whether the end of the sequence has been reached
	 */
	@Override
	public boolean isDone() {
		return pointer >= sequence.length();
	}

	/**
	 * Moves this iterator to the beginning of the sequence.
	 */
	@Override
	public void reset() {
		pointer = 0;
	}
}
