package lawu.util.iterator;

import lawu.dp.Iterator;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class JoiningIterator<T> extends AbstractUniversalIterator<T> {
	private final Iterator<Iterator<T>> iterator;
	
	/**
	 * @param iterator
	 */
	public JoiningIterator(Iterator<Iterator<T>> iterator) {
		this.iterator = iterator;
	}
	
	/**
	 * @param iterators
	 */
	public JoiningIterator(Iterator<T>... iterators) {
		this(new IteratorFactory().iterator(iterators));
	}
	
	public void advance() {
		while(this.iterator.current().isDone() && !this.iterator.isDone()) {
			this.iterator.advance();
			this.iterator.current().reset();
		}
		this.iterator.current().advance();
	}

	public T current() {
		return this.iterator.current().current();
	}

	public boolean isDone() {
		return this.iterator.isDone();
	}

	public void reset() {
		this.iterator.reset();
		if(!this.iterator.isDone())
			this.iterator.current().reset();
	}
}
