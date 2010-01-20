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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * A line iterator that can read from an <tt>InputStream</tt> and related
 * objects.
 * 
 * @author Miorel-Lucian Palii
 */
public class StreamIterator extends LineIterator {
	private final BufferedReader reader;
	
	/**
	 * Constructs an iterator that reads from the specified reader.
	 * 	
	 * @param reader input source
	 * @throws IllegalArgumentException if passed <tt>null</tt>
	 */
	public StreamIterator(BufferedReader reader) throws IllegalArgumentException {
		if(reader == null)
			throw new IllegalArgumentException("Can't read lines from null reader.");
		this.reader = reader;
		init();
	}

	/**
	 * Constructs an iterator that reads from the specified reader.
	 * 
	 * @param reader input source
	 * @throws IllegalArgumentException if passed <tt>null</tt>
	 */
	public StreamIterator(Reader reader) throws IllegalArgumentException {
		if(reader == null)
			throw new IllegalArgumentException("Can't read lines from null reader.");
		this.reader = new BufferedReader(reader);
		init();
	}

	/**
	 * Constructs an iterator that reads from the specified stream.
	 * 
	 * @param stream input source
	 * @throws IllegalArgumentException if passed <tt>null</tt>
	 */
	public StreamIterator(InputStream stream) throws IllegalArgumentException {
		if(stream == null)
			throw new IllegalArgumentException("Can't read lines from null stream.");
		this.reader = new BufferedReader(new InputStreamReader(stream));
		init();
	}
	
	/**
	 * Constructs an iterator that reads from the specified file.
	 * 
	 * @param file input source
	 * @throws FileNotFoundException if the file can't be opened for reading
	 * @throws IllegalArgumentException if passed <tt>null</tt>
	 */
	public StreamIterator(File file) throws FileNotFoundException, IllegalArgumentException {
		if(file == null)
			throw new IllegalArgumentException("Can't read lines from null file.");
		this.reader = new BufferedReader(new FileReader(file));
		init();
	}

	/**
	 * Constructs an iterator that reads from the file with the specified name.
	 * 
	 * @param file name of file to use as input source
	 * @throws FileNotFoundException if the file can't be opened for reading
	 * @throws IllegalArgumentException if passed <tt>null</tt>
	 */
	public StreamIterator(String file) throws FileNotFoundException, IllegalArgumentException {
		if(file == null)
			throw new IllegalArgumentException("Can't read lines from null file.");
		this.reader = new BufferedReader(new FileReader(file));
		init();
	}
	
	/**
	 * Reads and returns the contents of the next line, or <tt>null</tt> if
	 * there are no more lines.
	 * 
	 * @return the contents of the next line, or <tt>null</tt> if there are
	 * no more lines
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected String getNextLine() throws IOException {
		return reader.readLine();
	}
}
