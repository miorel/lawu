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
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * A line iterator that can read from an <code>InputStream</code> and related
 * objects.
 * 
 * @author Miorel-Lucian Palii
 */
public class StreamIterator extends LineIterator {
	private final BufferedReader reader;

	/**
	 * Constructs an iterator that reads from the specified
	 * <code>BufferedReader</code>.
	 * 
	 * @param reader
	 *            the input source
	 */
	public StreamIterator(BufferedReader reader) {
		if(reader == null)
			throw new IllegalArgumentException("Can't read lines from null reader.");
		this.reader = reader;
		init();
	}

	/**
	 * Constructs an iterator that reads from the specified <code>Reader</code>.
	 * 
	 * @param reader
	 *            the input source
	 */
	public StreamIterator(Reader reader) {
		if(reader == null)
			throw new IllegalArgumentException("Can't read lines from null reader.");
		this.reader = new BufferedReader(reader);
		init();
	}

	/**
	 * Constructs an iterator that reads from the specified stream.
	 * 
	 * @param stream
	 *            the input source
	 */
	public StreamIterator(InputStream stream) {
		if(stream == null)
			throw new IllegalArgumentException("Can't read lines from null stream.");
		this.reader = new BufferedReader(new InputStreamReader(stream));
		init();
	}

	/**
	 * Constructs an iterator that reads from the specified file.
	 * 
	 * @param file
	 *            the input source
	 * @throws FileNotFoundException
	 *             if the file can't be opened for reading
	 */
	public StreamIterator(File file) throws FileNotFoundException {
		if(file == null)
			throw new IllegalArgumentException("Can't read lines from null file.");
		this.reader = new BufferedReader(new FileReader(file));
		init();
	}

	/**
	 * Constructs an iterator that reads from the specified file descriptor.
	 * 
	 * @param fd
	 *            the input source
	 */
	public StreamIterator(FileDescriptor fd) {
		if(fd == null)
			throw new IllegalArgumentException("Can't read lines from null file descriptor.");
		this.reader = new BufferedReader(new FileReader(fd));
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
	public StreamIterator(String file) throws FileNotFoundException {
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
