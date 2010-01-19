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
package lawu.util.iterator;

/**
 * @author Miorel-Lucian Palii
 */
public class CharacterIterator extends AbstractUniversalIterator<Character> {
	private final CharSequence sequence;
	private int pointer;

	/**
	 * @param sequence
	 */
	public CharacterIterator(CharSequence sequence) {
		this.sequence = sequence;
		reset();
	}
	
	@Override
	public void advance() {
		++this.pointer;
	}

	@Override
	public Character current() {
		return Character.valueOf(this.sequence.charAt(this.pointer));
	}

	@Override
	public boolean isDone() {
		return this.pointer >= this.sequence.length();
	}

	@Override
	public void reset() {
		this.pointer = 0;
	}
}
