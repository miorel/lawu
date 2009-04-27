/**
 * 
 */
package lawu.util.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Miorel-Lucian Palii
 *
 */
public class IteratorAdapter<T> extends AbstractUniversalIterator<T> {
	private final List<T> list;
	private final Iterator<T> iterator;
	private int pointer;

	/**
	 * @param iterator
	 */
	public IteratorAdapter(Iterator<T> iterator) {
		this.list = new ArrayList<T>();
		this.iterator = iterator;
	}

	public void advance() {
		++this.pointer;
		current();
	}

	public T current() {
		T ret = null;
		if(this.pointer < this.list.size())
			ret = this.list.get(this.pointer);
		else {
			ret = this.iterator.next();
			this.list.add(ret);
		}
		return ret;
	}

	public boolean isDone() {
		return this.pointer >= this.list.size() && !this.iterator.hasNext();
	}

	public void reset() {
		this.pointer = 0;
	}
}
