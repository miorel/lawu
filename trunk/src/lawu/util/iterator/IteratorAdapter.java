package lawu.util.iterator;

import lawu.dp.Iterator;

/**
 * @author Miorel-Lucian Palii
 *
 */
public class IteratorAdapter<T> extends AbstractUniversalIterator<T> {
	private final Iterator<T> iterator;
	
	/**
	 * @param iterator
	 */
	public IteratorAdapter(Iterator<T> iterator) {
		this.iterator = iterator;
		reset();
	}

	public void advance() {
		this.iterator.advance();
	}

	public T current() {
		return this.iterator.current();
	}

	public boolean isDone() {
		return this.iterator.isDone();
	}

	public void reset() {
		this.iterator.reset();
	}
}
