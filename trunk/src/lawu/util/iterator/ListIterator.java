package lawu.util.iterator;

import java.util.List;

public class ListIterator<T> extends AbstractUniversalIterator<T> {
	private final List<T> list;
	private int pointer;
	
	public ListIterator(List<T> list) {
		this.list = list;
	}
	
	public void advance() {
		++pointer;
	}

	public T current() {
		return list.get(pointer);
	}

	public boolean isDone() {
		return pointer >= list.size();
	}

	public void reset() {
		pointer = 0;
	}
}
