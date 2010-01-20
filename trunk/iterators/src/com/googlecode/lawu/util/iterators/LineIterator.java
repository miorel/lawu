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
public abstract class LineIterator extends AbstractUniversalIterator<String> {
	private boolean done;
	private boolean beginning;
	private String current;
	
	/**
	 * Default constructor, does nothing.
	 */
	public LineIterator() {
	}
	
	/**
	 * Initializes a line iterator. Reads one line as a side effect.
	 */
	protected void init() {
		this.done = false;
		advance();
		this.beginning = true;
	}
	
	/**
	 * Reads the next line and prepares it to be returned by calls to
	 * <code>current()</code>. If there is an I/O error, it's silently trapped,
	 * but the iterator is set to done.
	 */
	@Override
	public void advance() {
		if(!isDone()) {
			try {
				current = getNextLine();
				if(current == null)
					done = true;
			}
			catch(IOException e) {
				done = true;
			}
			beginning = false;	
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
	
	/**
	 * Retrieves the current line.
	 *
	 * @return the current line
	 */
	@Override
	public String current() {
		return current;
	}

	/**
	 * Checks whether there are any more lines over which to iterate.
	 * 
	 * @return whether there are any more lines
	 */
	@Override
	public boolean isDone() {
		return done;
	}

	/**
	 * Does nothing in a newly-created iterator, otherwise throws an
	 * <code>IllegalStateException</code>.
	 * 
	 * @throws IllegalStateException if the iterator isn't "fresh"
	 */
	@Override
	public void reset() throws IllegalStateException {
		if(!beginning)
			throw new IllegalStateException("Can't reread old lines.");
	}
}
