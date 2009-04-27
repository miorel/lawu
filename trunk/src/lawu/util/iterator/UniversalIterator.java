package lawu.util.iterator;

import java.util.Enumeration;

import lawu.dp.Iterator;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public interface UniversalIterator<T> extends Iterator<T>,
		java.util.Iterator<T>, Iterable<T>, Enumeration<T> {
	public UniversalIterator<T> iterator();
}
