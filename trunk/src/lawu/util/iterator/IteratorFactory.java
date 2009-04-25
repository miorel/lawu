package lawu.util.iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IteratorFactory {
	public <T> UniversalIterator<T> iterator(T... array) {
		return new ArrayIterator<T>(array);
	}

	public <T> UniversalIterator<T> iterator(List<T> list) {
		return new ListIterator<T>(list);
	}

	public <T> UniversalIterator<T> iterator(Iterable<T> iterable) {
		return iterator(iterable.iterator());
	}

	public <T> UniversalIterator<T> iterator(final java.util.Iterator<T> iterator) {
		return new AbstractUniversalIterator<T>() {
			private final List<T> list = new ArrayList<T>();
			private int pointer;

			public void advance() {
				++pointer;
				current();
			}

			public T current() {
				T ret = null;
				if(pointer < list.size())
					ret = list.get(pointer);
				else {
					ret = iterator.next();
					list.add(ret);
				}
				return ret;
			}

			public boolean isDone() {
				return pointer >= list.size() && !iterator.hasNext();
			}

			public void reset() {
				pointer = 0;
			}
		};
	}

	public <T> UniversalIterator<T> iterator(final Enumeration<T> enumeration) {
		return new AbstractUniversalIterator<T>() {
			private final List<T> list = new ArrayList<T>();
			private int pointer;

			public void advance() {
				++pointer;
				current();
			}

			public T current() {
				T ret = null;
				if(pointer < list.size())
					ret = list.get(pointer);
				else {
					ret = enumeration.nextElement();
					list.add(ret);
				}
				return ret;
			}

			public boolean isDone() {
				return pointer >= list.size() && !enumeration.hasMoreElements();
			}

			public void reset() {
				pointer = 0;
			}
		};
	}
}
