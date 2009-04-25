package lawu.util.iterator;

import lawu.dp.Iterator;
import lawu.util.Filter;

public class FilteredIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private final Filter<T> filter;
	
	public FilteredIterator(Iterator<T> iterator, Filter<T> filter) {
		this.iterator = iterator;
		this.filter = filter;
	}
	
	public void advance() {
		do iterator.advance();
		while(!filter.keep(iterator.current()));
	}

	public T current() {
		return iterator.current();
	}

	public boolean isDone() {
		return iterator.isDone();
	}

	public void reset() {
		iterator.reset();
		if(!filter.keep(iterator.current()))
			advance();
	}
}
