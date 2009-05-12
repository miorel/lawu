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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.MatchResult;

import lawu.dp.Iterator;
import lawu.util.Filter;
import lawu.util.Mapper;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <p>
 * Utility methods for manipulating iterators and iterable structures. The
 * ultimate goal is to have an intuitive interface for straightforwardly dealing
 * with all kinds of traversals.
 * </p>
 * 
 * <p>
 * For example, the <code>iterator()</code> method comes in numerous flavors.
 * Its intent is to give the most logical iterator based on the argument(s). The
 * method not only supports "obvious" iterables, such as <code>List</code>s and
 * arrays, but can also be used to iterate over the matching groups of a
 * <code>MatchResult</code>, the characters of a <code>CharSequence</code>, the
 * <code>Node</code>s in a <code>NodeList</code>, and hopefully (eventually)
 * anything else over which it may be philosophically desirable to iterate.
 * Design pattern addicts rejoice: calling <code>iterator()</code> with no
 * arguments will return a null iterator (not <code>null</code>, silly, just an
 * iterator with has no elements). Similarly, calling it with a single element
 * will return a single element iterator.
 * </p>
 * 
 * <p>
 * In addition to providing a variety of iterators, this class comes with
 * methods for concisely accomplishing some common tasks, such as sorting,
 * filtering, joining multiple iterators, or defining mapping involving all
 * elements of a traversal. A neat trick is to:
 * 
 * <pre>
 * import static lawu.util.iterator.Iterators.*;
 * </pre>
 * 
 * ...and then you can map, grep, or join to your heart's desire. You won't win
 * any code brevity contests (this is still Java), but you might make a few Perl
 * hackers smile.
 * </p>
 * 
 * <p>
 * All iterators returned by this class are subclasses of
 * <code>UniversalIterator</code>, which means that you can use them whether you
 * need an <code>Iterable</code>, a Java <code>Iterator</code>, a Gang of Four
 * iterator, or even an <code>Enumeration</code>. Adapter methods are also
 * provided for converting any of these interfaces to
 * <code>UniversalIterator</code>s.
 * </p>
 * 
 * @author Miorel-Lucian Palii
 */
public class Iterators {
	/**
	 * There is no need to instantiate this class.
	 */
	private Iterators() {
	}
	
	/**
	 * Returns an iterator over the passed elements or element array.
	 * 
	 * @param <T> the type of elements
	 * @param array elements over which to iterate
	 * @return an iterator over the elements
	 */
	public static <T> UniversalIterator<T> iterator(T... array) {
		return new ArrayIterator<T>(array);
	}

	/**
	 * Returns an iterator over the list.
	 * 
	 * @param <T> the type of list elements
	 * @param list list of elements over which to iterate
	 * @return an iterator over the list
	 */
	public static <T> UniversalIterator<T> iterator(List<T> list) {
		return new ListIterator<T>(list);
	}

	/**
	 * Adapts a Gang of Four iterator to a <code>UniversalIterator</code>.
	 * 
	 * @param <T> the type over which the iteration takes place
	 * @param iterator adaptee
	 * @return an universal iterator
	 */
	public static <T> UniversalIterator<T> iterator(Iterator<T> iterator) {
		return new IteratorAdapter<T>(iterator);
	}

	/**
	 * Adapts an <code>Iterable</code> to a <code>UniversalIterator</code>.
	 * 
	 * @param <T> the type over which the iteration takes place
	 * @param iterable adaptee
	 * @return an universal iterator
	 */
	public static <T> UniversalIterator<T> iterator(Iterable<T> iterable) {
		return iterator(iterable.iterator());
	}

	/**
	 * Adapts a Java <code>Iterator</code> to a <code>UniversalIterator</code>.
	 * This method should be avoided if possible because Java iterators do not
	 * provide a <code>reset()</code>-like method, so emulating it requires
	 * copying references to all the elements during the traversal.
	 * 
	 * @param <T> the type over which the iteration takes place
	 * @param iterator adaptee
	 * @return an universal iterator
	 */
	public static <T> UniversalIterator<T> iterator(java.util.Iterator<T> iterator) {
		return new JIteratorAdapter<T>(iterator);
	}

	/**
	 * Adapts an <code>Enumeration</code> to a <code>UniversalIterator</code>.
	 * This method should be avoided if possible because
	 * <code>Enumeration</code>s do not provide a <code>reset()</code>-like
	 * method, so emulating it requires copying references to all the elements
	 * during the traversal.
	 * 
	 * @param <T> the type over which the iteration takes place
	 * @param enumeration adaptee
	 * @return an universal iterator
	 */
	public static <T> UniversalIterator<T> iterator(Enumeration<T> enumeration) {
		return new JEnumerationAdapter<T>(enumeration);
	}

	/**
	 * Returns an iterator over the nodes in the node list.
	 * 
	 * @param list the node list
	 * @return a node iterator
	 */
	public static UniversalIterator<Node> iterator(NodeList list) {
		return new NodeListIterator(list);
	}

	/**
	 * Returns an iterator over the characters of a <code>CharSequence</code>.
	 * 
	 * @param sequence the character sequence
	 * @return a character iterator
	 */
	public static UniversalIterator<Character> iterator(CharSequence sequence) {
		return new CharacterIterator(sequence);
	}

	/**
	 * Returns an iterator over the matching groups of a
	 * <code>MatchResult</code>
	 * 
	 * @param match the match result
	 * @return a match result iterator
	 */
	public static UniversalIterator<String> iterator(MatchResult match) {
		return new MatchResultIterator(match);
	}

	/**
	 * Returns an iterator over all the files in the directory hierarchy with
	 * the specified root. That is, this method is similar to the Unix
	 * <code>find</code> utility: if the <code>File</code> given to this method
	 * is a directory, the returned iterator will recurse through the directory
	 * tree in a depth-first manner. If the argument represents a normal file,
	 * the iterator will have a single element, the <code>File</code> itself.
	 * Directory tree nodes on the same level will be traversed in
	 * lexicographical order based on path, in a system-dependent manner
	 * (case-sensitive on Windows, case-insensitive on Unix).
	 * 
	 * @param file root of the directory hierarchy to traverse
	 * @return an iterator over the directory hierarchy
	 */
	public static UniversalIterator<File> iterator(File file) {
		return new FileIterator(file);
	}
	
	/**
	 * Maps the elements of a traversal using the specified mapping function.
	 * The mapping is done lazily, i.e. the backing mapper does not get to see
	 * the elements of the mapped traversal until the returned iterator is
	 * explicitly asked for an element. Defining a mapping function with side
	 * effects might be a bad idea, but if you insist on applying it to all
	 * elements without doing anything else, you may find the
	 * <code>traverse()</code> method of use.
	 * 
	 * @param <T> the mapping function's domain (the type of the input
	 *            traversal)
	 * @param <U> the mapping function's range (the type over which the returned
	 *            iterator iterates )
	 * @param mapper the mapping function
	 * @param iterator the traversal to map
	 * @return an iterator that performs the same traversal as the input but
	 *         which applies the mapping function to each element before
	 *         returning it
	 */
	public static <T, U> UniversalIterator<U> map(Mapper<? super T, ? extends U> mapper, Iterator<? extends T> iterator) {
		return new MappingIterator<T, U>(mapper, iterator);
	}

	/**
	 * Keeps only those elements of a traversal which pass the specified filter.
	 * 
	 * @param <T> the type over which the returned iterator iterates
	 * @param filter the filtering method
	 * @param iterator the traversal to filter
	 * @return an iterator that gives only those elements of the input which
	 *         pass the specified filter
	 */
	public static <T> UniversalIterator<T> filter(Filter<? super T> filter, Iterator<? extends T> iterator) {
		return new FilteredIterator<T>(filter, iterator);
	}

	/**
	 * Unix-esque synonym for <code>filter()</code>.
	 * 
	 * @param <T> the type over which the returned iterator iterates
	 * @param filter the filtering method
	 * @param iterator the traversal to filter
	 * @return an iterator that gives only those elements of the input which
	 *         pass the specified filter
	 */
	public static <T> UniversalIterator<T> grep(Filter<? super T> filter, Iterator<? extends T> iterator) {
		return filter(filter, iterator);
	}

	/**
	 * Unfolds an iterator of iterators by joining the elements of its elements
	 * into a single iterator.
	 * 
	 * @param <T> the type over which the iteration takes place
	 * @param iterator the iterator to unfold
	 * @return an iterator over all the elements of the given iterators
	 */
	public static <T> UniversalIterator<T> join(Iterator<? extends Iterator<? extends T>> iterator) {
		return new JoiningIterator<T>(iterator);
	}

	/**
	 * Joins the specified iterators into a single one.
	 * 
	 * @param <T> the type over which the iteration takes place
	 * @param iterators the iterators to join
	 * @return an iterator over all the elements of the given iterators
	 */
	public static <T> UniversalIterator<T> join(Iterator<? extends T>... iterators) {
		return join(iterator(iterators));
	}

	/**
	 * Orders a traversal using the default comparison method.
	 * 
	 * @param <T> the type over which the iteration takes place
	 * @param iterator the traversal to sort
	 * @return an iterator which gives the same elements as the input but sorted
	 *         in order according to the default comparison method of the input
	 *         type
	 */
	public static <T extends Comparable<T>> UniversalIterator<T> sort(Iterator<? extends T> iterator) {
		List<T> list = new ArrayList<T>();
		for(iterator.reset(); !iterator.isDone(); iterator.advance())
			list.add(iterator.current());
		Collections.sort(list);
		return iterator(list);
	}

	/**
	 * Orders a traversal using the specified comparison method.
	 * 
	 * @param <T> the type over which the iteration takes place
	 * @param comparator comparison method
	 * @param iterator the traversal to sort
	 * @return an iterator which gives the same elements as the input but sorted
	 *         in order according to the given comparison method
	 */
	public static <T> UniversalIterator<T> sort(Comparator<? super T> comparator, Iterator<? extends T> iterator) {
		List<T> list = new ArrayList<T>();
		for(iterator.reset(); !iterator.isDone(); iterator.advance())
			list.add(iterator.current());
		Collections.sort(list, comparator);
		return iterator(list);
	}

	/**
	 * Traverses all of the elements of an iterator from the beginning, doing
	 * nothing. This could be useful primarily for forcing evaluation of lazy
	 * methods, such as <code>map()</code>.
	 * 
	 * @param iterator iterator to traverse
	 */
	public static void traverse(Iterator<?> iterator) {
		for(iterator.reset(); !iterator.isDone(); iterator.advance()) {}
	}
}
