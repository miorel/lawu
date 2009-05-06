package lawu.util.iterator;

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
 * method not only supports "obvious" iterables, such as Lists and arrays, but
 * can also be used to iterate over the matching groups of a MatchResult, the
 * characters of a CharSequence, the Nodes in a NodeList, and hopefully
 * (eventually) anything else over which it may be philosophically desirable to
 * iterate. Design pattern addicts rejoice: calling <code>iterator()</code> with
 * no arguments will return a null iterator (not <code>null</code>, silly, just
 * an iterator with has no elements). Similarly, calling it with a single
 * element will return a single element iterator.
 * </p>
 * 
 * <p>
 * In addition to providing a variety of iterators, this class comes with
 * methods for concisely accomplishing some common tasks, such as sorting,
 * filtering, joining multiple iterators, or defining a mapping for all elements
 * of a traversal from one type onto another. A neat trick is to:
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
		return new DelegatingIterator<T>(iterator);
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
		return new IteratorAdapter<T>(iterator);
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
		return new EnumerationAdapter<T>(enumeration);
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
	 * @return
	 */
	public static <T, U> UniversalIterator<U> map(Mapper<T, U> mapper, Iterator<T> iterator) {
		return new MappingIterator<T, U>(mapper, iterator);
	}

	/**
	 * @param <T> the type over which the returned iterator iterates
	 * @param filter
	 * @param iterator
	 * @return
	 */
	public static <T> UniversalIterator<T> filter(Filter<T> filter, Iterator<T> iterator) {
		return new FilteredIterator<T>(filter, iterator);
	}

	/**
	 * Unix-esque synonym for <code>filter()</code>.
	 * 
	 * @param <T>
	 * @param filter
	 * @param iterator
	 * @return
	 */
	public static <T> UniversalIterator<T> grep(Filter<T> filter, Iterator<T> iterator) {
		return filter(filter, iterator);
	}

	/**
	 * @param <T>
	 * @param iterator
	 * @return
	 */
	public static <T> UniversalIterator<T> join(Iterator<? extends Iterator<T>> iterator) {
		return new JoiningIterator<T>(iterator);
	}

	/**
	 * @param <T>
	 * @param iterators
	 * @return
	 */
	public static <T> UniversalIterator<T> join(Iterator<T>... iterators) {
		return join(iterator(iterators));
	}

	/**
	 * @param <T>
	 * @param iterator
	 * @return
	 */
	public static <T extends Comparable<T>> UniversalIterator<T> sort(Iterator<T> iterator) {
		List<T> list = new ArrayList<T>();
		for(iterator.reset(); !iterator.isDone(); iterator.advance())
			list.add(iterator.current());
		Collections.sort(list);
		return iterator(list);
	}

	/**
	 * @param <T>
	 * @param iterator
	 * @return
	 */
	public static <T> UniversalIterator<T> sort(Iterator<T> iterator, Comparator<T> comparator) {
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
