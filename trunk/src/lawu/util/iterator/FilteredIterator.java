package lawu.util.iterator;

import lawu.dp.Iterator;
import lawu.util.Filter;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class FilteredIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private final Filter<T> filter;
	
	/**
	 * @param iterator
	 * @param filter
	 */
	public FilteredIterator(Iterator<T> iterator, Filter<T> filter) {
		this.iterator = iterator;
		this.filter = filter;
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
