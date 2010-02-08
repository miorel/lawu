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

/**
 * <p>
 * Abstract adapter for iterators and other objects that are conceptually
 * iterable.
 * </p>
 * <p>
 * Java's <code>Iterator</code> combines into one the Gang of Four iterator's
 * retrieve current element and advance operations. Other structures over which
 * it may be desirable to iterate have analogous methods, such as
 * <code>BufferedReader</code>'s <code>readLine()</code>. This class aims to
 * reduce code duplication in adapters for all these structures by providing a
 * flexible common skeleton.
 * </p>
 * <p>
 * Subclasses should implement <code>doAdvance()</code>, using
 * <code>setCurrent()</code> and <code>markAsDone()</code> for state changes.
 * There is no need to check if the iterator is done from within
 * <code>doAdvance()</code>, as this check is already made here.
 * </p>
 * <p>
 * They should also call <code>init()</code> from within their constructors so
 * the iterator is valid. This requirement of the contract is not explicitly
 * enforced at this time, so run your tests.
 * </p>
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type over which the iteration takes place
 */
public abstract class IteratorAdapter<T> extends AbstractUniversalIterator<T> {
	private boolean done;
	private boolean fresh;
	private T current;

	/**
	 * Default constructor, does nothing.
	 */
	public IteratorAdapter() {
	}

	/**
	 * Initializes the adapter. May retrieve one element from the adaptee as a
	 * side effect.
	 */
	protected void init() {
		this.done = false;
		advance();
		this.fresh = true;
	}

	/**
	 * Retrieves the next element and prepares it to be returned by calls to
	 * <code>current()</code>.
	 */
	@Override
	public final void advance() {
		if(!isDone()) {
			doAdvance();
			fresh = false;
		}
	}

	/**
	 * Does the actual work of advancing this iterator.
	 */
	protected abstract void doAdvance();

	/**
	 * Marks this iterator as done. In other words, marks it such that
	 * subsequent calls to <code>isDone()</code> will return <code>true</code>.
	 */
	protected void markAsDone() {
		done = true;
	}

	/**
	 * Sets the current element to the specified value.
	 * 
	 * @param element
	 *            the new current element
	 */
	protected void setCurrent(T element) {
		current = element;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() {
		return current;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDone() {
		return done;
	}

	/**
	 * Checks whether this is a "fresh" iterator. Calls to
	 * <code>advance()</code> will set this to <code>false</code>. Newly-created
	 * iterators are expected to return <code>true</code> from this method.
	 * 
	 * @return whether this iterator is "fresh"
	 */
	protected boolean isFresh() {
		return fresh;
	}

	/**
	 * Does nothing in a newly-created iterator, otherwise throws an
	 * <code>IllegalStateException</code>.
	 * 
	 * @throws IllegalStateException
	 *             if the iterator isn't "fresh"
	 */
	@Override
	public void reset() throws IllegalStateException {
		if(!isFresh())
			throw new IllegalStateException("Can't go back to old elements.");
	}
}
