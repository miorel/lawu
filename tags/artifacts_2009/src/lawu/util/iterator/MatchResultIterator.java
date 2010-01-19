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

import java.util.regex.MatchResult;

/**
 * @author Miorel-Lucian Palii
 */
public class MatchResultIterator extends AbstractUniversalIterator<String> {
	private final MatchResult match;
	private int pointer;
	
	public MatchResultIterator(MatchResult match) {
		this.match = match;
		reset();
	}
	
	@Override
	public void advance() {
		++this.pointer;
	}

	@Override
	public String current() {
		return this.match.group(this.pointer);
	}

	@Override
	public boolean isDone() {
		return this.pointer > this.match.groupCount();
	}

	@Override
	public void reset() {
		this.pointer = 1;
	}

}
