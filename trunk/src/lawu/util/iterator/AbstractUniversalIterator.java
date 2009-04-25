package lawu.util.iterator;

public abstract class AbstractUniversalIterator<T> implements UniversalIterator<T> {
	public boolean hasNext() {
		return !isDone();
	}

	public T next() {
		T ret = current();
		advance();
		return ret;
	}

	public void remove() {
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
