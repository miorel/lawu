package com.googlecode.lawu.util.iterators;

import java.io.IOException;

/**
 * <p>
 * Abstract definition of an iterator that gets lines from an input source.
 * </p>
 * 
 * <p>
 * A subclass should override <code>getNextLine()</code> to define how the
 * lines are read and call <code>init()</code> from within the constructor.
 * </p>
 * 
 * @author Miorel-Lucian Palii
 */
public abstract class LineIterator extends IteratorAdapter<String> {	
	/**
	 * Default constructor, does nothing.
	 */
	public LineIterator() {
	}
	
	/**
	 * Reads the next line and prepares it to be returned by calls to
	 * <code>current()</code>. If there is an I/O error, it's silently trapped,
	 * but the iterator is set to done.
	 */
	@Override
	protected void doAdvance() {
		if(!isDone()) {
			try {
				String line = getNextLine();
				setCurrent(line);
				if(line == null)
					markAsDone();
			}
			catch(IOException e) {
				markAsDone();
			}	
		}
	}

	/**
	 * Defines how this iterator reads lines. Implementations should signal
	 * that there are no more lines by returning <code>null</code>. 
	 * 
	 * @return the contents of the next line, or <code>null</code> if there are
	 *         no more lines
	 * @throws IOException if an I/O error occurs
	 */
	protected abstract String getNextLine() throws IOException;
}
