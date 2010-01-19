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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import lawu.dp.UnresettableIteratorException;

/**
 * @author Miorel-Lucian Palii
 */
public class ReaderIterator extends AbstractUniversalIterator<String> {
	private final BufferedReader reader;
	private String current;
	private boolean beginning;
	private boolean done;

	public ReaderIterator(Reader reader) {
		this.reader = new BufferedReader(reader);
		this.done = false;
		advance();
		this.beginning = true;
	}

	public void advance() {
		if(!this.done) {
			this.beginning = false;
			this.done = true;
			try {
				if((this.current = this.reader.readLine()) != null)
					this.done = false;
			}
			catch(IOException e) {
			}
		}
	}

	public String current() {
		return this.current;
	}

	public boolean isDone() {
		return this.done;
	}

	public void reset() throws UnresettableIteratorException {
		if(!this.beginning)
			throw new UnresettableIteratorException("");
	}
}
