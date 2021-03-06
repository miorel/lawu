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

import java.io.File;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.util.Iterators;

/**
 * An iterator over a file hierarchy.
 * 
 * @author Miorel-Lucian Palii
 * @see Iterators#tree(File)
 */
public class FileHierarchyIterator extends TreeIterator<File> {
	private final File root;

	/**
	 * Prepares an iterator that will do a depth-first traversal of the file
	 * hierarchy that has the given root.
	 * 
	 * @param root
	 *            root of the file hierarchy
	 */
	public FileHierarchyIterator(File root) {
		if(root == null)
			throw new NullPointerException("Can't iterate over a null file hierarchy.");
		this.root = root;
		reset();
	}

	/**
	 * Returns an iterator over the subfiles of the given file. If the file is
	 * not a directory, this will be an iterator with no elements.
	 * 
	 * @param file
	 *            parent of the files to iterate over
	 * @return an iterator over the file's subfiles
	 */
	@Override
	protected Iterator<File> childIterator(File file) {
		return Iterators.children(file);
	}

	@Override
	protected Iterator<File> getInitialIterator() {
		return Iterators.iterator(this.root);
	}
}
