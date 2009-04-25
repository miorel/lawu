package lawu.util.iterator;

public class ArrayIterator<T> extends AbstractUniversalIterator<T> {
	private final T[] array;
	private int pointer;
	
	public ArrayIterator(T... array) {
		this.array = array;
	}
	
	public void advance() {
		++pointer;
	}

	public T current() {
		return array[pointer];
	}

	public boolean isDone() {
		return pointer >= array.length;
	}

	public void reset() {
		pointer = 0;
	}
}
