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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A line iterator that can read from an <code>InputStream</code> and related
 * objects.
 * 
 * @author Miorel-Lucian Palii
 */
public class BufferedReaderIterator extends LineIterator {
	private final BufferedReader reader;

	/**
	 * Constructs an iterator that reads from the specified
	 * <code>BufferedReader</code>.
	 * 
	 * @param reader
	 *            the input source
	 */
	public BufferedReaderIterator(BufferedReader reader) {
		if(reader == null)
			throw new IllegalArgumentException("Can't read lines from null reader.");
		this.reader = reader;
		init();
	}

	/**
	 * Constructs an iterator that reads from the file with the specified name.
	 * 
	 * @param file
	 *            name of the file to use as input source
	 * @throws FileNotFoundException
	 *             if the file can't be opened for reading
	 */
	public BufferedReaderIterator(String file) throws FileNotFoundException {
		if(file == null)
			throw new IllegalArgumentException("Can't read lines from null file.");
		this.reader = new BufferedReader(new FileReader(file));
		init();
	}
	
	/**
	 * Reads and returns the contents of the next line, or <code>null</code> if
	 * there are no more lines.
	 * 
	 * @return the contents of the next line, or <code>null</code> if there are
	 *         no more lines
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected String getNextLine() throws IOException {
		return reader.readLine();
	}
}
