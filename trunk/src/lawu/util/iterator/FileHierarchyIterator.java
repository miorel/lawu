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

import java.io.File;
import java.util.Arrays;
import java.util.Stack;

import lawu.dp.Iterator;

/**
 * @author Miorel-Lucian Palii
 */
public class FileHierarchyIterator extends AbstractUniversalIterator<File> {
	private final Stack<Iterator<File>> iterators;
	private final File root;

	public FileHierarchyIterator(File file) {
		this.root = file;
		this.iterators = new Stack<Iterator<File>>();
		reset();
	}

	@Override
	public void advance() {
		if(!isDone()) {
			File currentFile = current();
			this.iterators.peek().advance();
			if(currentFile.isDirectory()) {
				File[] fileArray = currentFile.listFiles();
				Arrays.sort(fileArray);
				Iterator<File> fileIter = Iterators.iterator(fileArray);
				fileIter.reset();
				this.iterators.push(fileIter);
			}
			while(!isDone() && this.iterators.peek().isDone())
				this.iterators.pop();
		}
	}

	@Override
	public File current() {
		return this.iterators.peek().current();
	}

	@Override
	public boolean isDone() {
		return this.iterators.isEmpty();
	}

	@Override
	public void reset() {
		this.iterators.clear();
		this.iterators.add(Iterators.iterator(this.root));
	}
}
