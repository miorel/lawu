package lawu.util.iterator;

import java.util.List;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public class ListIterator<T> extends AbstractUniversalIterator<T> {
	private final List<T> list;
	private int pointer;
	
	/**
	 * @param list
	 */
	public ListIterator(List<T> list) {
		this.list = list;
	}
	
	public void advance() {
		++this.pointer;
	}

	public T current() {
		return this.list.get(this.pointer);
	}

	public boolean isDone() {
		return this.pointer >= this.list.size();
	}

	public void reset() {
		this.pointer = 0;
	}
}
