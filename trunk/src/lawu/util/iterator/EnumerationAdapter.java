/**
 * 
 */
package lawu.util.iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Miorel-Lucian Palii
 */
public class EnumerationAdapter<T> extends AbstractUniversalIterator<T> {
	private final List<T> list;
	private final Enumeration<T> enumeration;
	private int pointer;
	
	/**
	 * @param enumeration
	 */
	public EnumerationAdapter(Enumeration<T> enumeration) {
		this.list = new ArrayList<T>();
		this.enumeration = enumeration;
		reset();
	}

	public void advance() {
		++this.pointer;
		current();
	}

	public T current() {
		T ret = null;
		if(this.pointer < this.list.size())
			ret = this.list.get(this.pointer);
		else if(this.enumeration.hasMoreElements()) {
			ret = this.enumeration.nextElement();
			this.list.add(ret);
		}
		return ret;
	}

	public boolean isDone() {
		return this.pointer >= this.list.size()
			&& !this.enumeration.hasMoreElements();
	}

	public void reset() {
		this.pointer = 0;
	}
}
