package lawu.util.iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Miorel-Lucian Palii
 */
public class IteratorFactory {
	/**
	 * @param <T>
	 * @param array
	 * @return
	 */
	public <T> UniversalIterator<T> iterator(T... array) {
		return new ArrayIterator<T>(array);
	}

	/**
	 * @param <T>
	 * @param list
	 * @return
	 */
	public <T> UniversalIterator<T> iterator(List<T> list) {
		return new ListIterator<T>(list);
	}

	/**
	 * @param <T>
	 * @param iterable
	 * @return
	 */
	public <T> UniversalIterator<T> iterator(Iterable<T> iterable) {
		return iterator(iterable.iterator());
	}

	/**
	 * @param <T>
	 * @param iterator
	 * @return
	 */
	public <T> UniversalIterator<T> iterator(final java.util.Iterator<T> iterator) {
		return new AbstractUniversalIterator<T>() {
			private final List<T> list = new ArrayList<T>();
			private int pointer;

			public void advance() {
				++this.pointer;
				current();
			}

			public T current() {
				T ret = null;
				if(this.pointer < this.list.size())
					ret = this.list.get(this.pointer);
				else {
					ret = iterator.next();
					this.list.add(ret);
				}
				return ret;
			}

			public boolean isDone() {
				return this.pointer >= this.list.size() && !iterator.hasNext();
			}

			public void reset() {
				this.pointer = 0;
			}
		};
	}

	/**
	 * @param <T>
	 * @param enumeration
	 * @return
	 */
	public <T> UniversalIterator<T> iterator(final Enumeration<T> enumeration) {
		return new AbstractUniversalIterator<T>() {
			private final List<T> list = new ArrayList<T>();
			private int pointer;

			public void advance() {
				++this.pointer;
				current();
			}

			public T current() {
				T ret = null;
				if(this.pointer < this.list.size())
					ret = this.list.get(this.pointer);
				else {
					ret = enumeration.nextElement();
					this.list.add(ret);
				}
				return ret;
			}

			public boolean isDone() {
				return this.pointer >= this.list.size() && !enumeration.hasMoreElements();
			}

			public void reset() {
				this.pointer = 0;
			}
		};
	}
}
