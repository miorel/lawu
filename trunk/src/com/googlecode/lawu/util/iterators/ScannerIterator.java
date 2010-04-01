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

import java.util.Scanner;

/**
 * A line iterator that reads from a {@link Scanner}.
 * 
 * @author Miorel-Lucian Palii
 */
public class ScannerIterator extends LineIterator {
	private final Scanner scanner;

	/**
	 * Constructs an iterator that reads from the specified scanner.
	 * 
	 * @param scanner
	 *            the input source
	 */
	public ScannerIterator(Scanner scanner) {
		if(scanner == null)
			throw new IllegalArgumentException("Can't read lines from null scanner.");
		this.scanner = scanner;
		init();
	}

	/**
	 * Reads and returns the contents of the next line, or <code>null</code> if
	 * there are no more lines.
	 * 
	 * @return the contents of the next line, or <code>null</code> if there are
	 *         no more lines
	 */
	@Override
	protected String getNextLine() {
		return scanner.hasNextLine() ? scanner.nextLine() : null;
	}
}
