package lawu.util.iterator;

import lawu.dp.Iterator;
import lawu.util.Filter;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class FilteredIterator<T> extends AbstractUniversalIterator<T> {
	private final Filter<T> filter;
	private final Iterator<T> iterator;
	
	/**
	 * @param filter
	 * @param iterator
	 */
	public FilteredIterator(Filter<T> filter, Iterator<T> iterator) {
		this.filter = filter;
		this.iterator = iterator;
		reset();
	}
	
	public void advance() {
		do this.iterator.advance();
		while(!this.filter.keep(this.iterator.current()));
	}

	public T current() {
		return this.iterator.current();
	}

	public boolean isDone() {
		return this.iterator.isDone();
	}

	public void reset() {
		this.iterator.reset();
		if(!this.filter.keep(this.iterator.current()))
			advance();
	}
}
