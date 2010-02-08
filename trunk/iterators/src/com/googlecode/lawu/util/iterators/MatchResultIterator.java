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

import java.util.regex.MatchResult;

/**
 * An iterator over the captured groups of a <code>MatchResult</code>.
 * 
 * @author Miorel-Lucian Palii
 */
public class MatchResultIterator extends AbstractUniversalIterator<String> {
	private final MatchResult match;
	private int pointer;
	
	/**
	 * Constructs an iterator over the captured groups of the specified match
	 * result.
	 *  
	 * @param match the match result
	 */
	public MatchResultIterator(MatchResult match) {
		if(match == null)
			throw new IllegalArgumentException("Can't iterate over null match result.");
		this.match = match;
		reset();
	}
	
	/**
	 * Advances this iterator to the next captured group.
	 */
	@Override
	public void advance() {
		++pointer;
	}

	/**
	 * Retrieves the current captured group.
	 * 
	 * @return the current captured group
	 */
	@Override
	public String current() {
		return match.group(pointer);
	}

	/**
	 * Checks whether there are any more captured groups.
	 * 
	 * @return whether there are any more captured groups
	 */
	@Override
	public boolean isDone() {
		return pointer > match.groupCount();
	}

	/**
	 * Moves this iterator to the first captured group.
	 */
	@Override
	public void reset() {
		pointer = 1;
	}
}
