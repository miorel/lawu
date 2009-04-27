package lawu.util.iterator;

import java.util.Enumeration;
import java.util.List;

import lawu.dp.Iterator;
import lawu.util.Filter;
import lawu.util.Mapper;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Miorel-Lucian Palii
 */
public class Iterators {
	/**
	 * @param <T>
	 * @param array
	 * @return
	 */
	public static <T> UniversalIterator<T> iterator(T... array) {
		return new ArrayIterator<T>(array);
	}
	
	/**
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T> UniversalIterator<T> iterator(List<T> list) {
		return new ListIterator<T>(list);
	}

	/**
	 * @param <T>
	 * @param iterator
	 * @return
	 */
	public static <T> UniversalIterator<T> iterator(final Iterator<T> iterator) {
		return new DelegatingIterator<T>(iterator);
	}
	
	/**
	 * @param <T>
	 * @param iterable
	 * @return
	 */
	public static <T> UniversalIterator<T> iterator(Iterable<T> iterable) {
		return iterator(iterable.iterator());
	}

	/**
	 * @param <T>
	 * @param iterator
	 * @return
	 */
	public static <T> UniversalIterator<T> iterator(java.util.Iterator<T> iterator) {
		return new IteratorAdapter<T>(iterator);
	}

	/**
	 * @param <T>
	 * @param enumeration
	 * @return
	 */
	public static <T> UniversalIterator<T> iterator(Enumeration<T> enumeration) {
		return new EnumerationAdapter<T>(enumeration);
	}
	
	/**
	 * @param list
	 * @return
	 */
	public static UniversalIterator<Node> iterator(NodeList list) {
		return new NodeListIterator(list);
	}
	
	/**
	 * @param sequence
	 * @return
	 */
	public static UniversalIterator<Character> iterator(CharSequence sequence) {
		return new CharacterIterator(sequence);
	}
	
	/**
	 * @param <T>
	 * @param <U>
	 * @param mapper
	 * @param iterator
	 * @return
	 */
	public static <T, U> UniversalIterator<U> map(Mapper<T, U> mapper, Iterator<T> iterator) {
		return new MappingIterator<T, U>(mapper, iterator);
	}

	/**
	 * @param <T>
	 * @param filter
	 * @param iterator
	 * @return
	 */
	public static <T> UniversalIterator<T> filter(Filter<T> filter, Iterator<T> iterator) {
		return new FilteredIterator<T>(filter, iterator);
	}
	
	/**
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
}
