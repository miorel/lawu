package lawu.util.iterator;

import lawu.dp.Iterator;

public class JoiningIterator<T> extends AbstractUniversalIterator<T> {
	private final Iterator<Iterator<T>> iterator;
	
	public JoiningIterator(Iterator<Iterator<T>> iterator) {
		this.iterator = iterator;
	}
	
	public JoiningIterator(Iterator<T>... iterators) {
		this(new IteratorFactory().iterator(iterators));
	}
	
	public void advance() {
		while(iterator.current().isDone() && !iterator.isDone()) {
			iterator.advance();
			iterator.current().reset();
		}
		iterator.current().advance();
	}

	public T current() {
		return iterator.current().current();
	}

	public boolean isDone() {
		return iterator.isDone();
	}

	public void reset() {
		iterator.reset();
		if(!iterator.isDone())
			iterator.current().reset();
	}
}
