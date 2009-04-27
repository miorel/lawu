package lawu.util.iterator;

import lawu.util.iterator.UniversalIterator;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public abstract class AbstractUniversalIterator<T> implements UniversalIterator<T> {
	/**
	 * 
	 */
	public AbstractUniversalIterator() {
	}
	
	public boolean hasNext() {
		return !isDone();
	}

	public T next() {
		T ret = current();
		advance();
		return ret;
	}

	/**
	 * Always throws an <code>UnsupportedOperationException</code>. I adhere to
	 * the Dave Small philosophy that this method is an abomination. The
	 * ability to remove an element is not inherent to iterators, nor does it
	 * make sense for all iterators. 
	 * 
	 * @throws UnsupportedOperationException always
	 */
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	public UniversalIterator<T> iterator() {
		return this;
	}

	public boolean hasMoreElements() {
		return hasNext();
	}

	public T nextElement() {
		return next();
	}	
}
