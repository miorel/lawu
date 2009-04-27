package lawu.util.iterator;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class ArrayIterator<T> extends AbstractUniversalIterator<T> {
	private final T[] array;
	private int pointer;
	
	/**
	 * @param array
	 */
	public ArrayIterator(T... array) {
		this.array = array;
	}
	
	public void advance() {
		++this.pointer;
	}

	public T current() {
		return this.array[this.pointer];
	}

	public boolean isDone() {
		return this.pointer >= this.array.length;
	}

	public void reset() {
		this.pointer = 0;
	}
}
