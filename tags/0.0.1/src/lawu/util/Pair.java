/**
 * 
 */
package lawu.util;

/**
 * @author Miorel-Lucian Palii
 */
public class Pair<T, U> {
	private final T first;
	private final U second;
	
	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return this.first;
	}
	
	public U getSecond() {
		return this.second;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %s]", getFirst(), getSecond()); //$NON-NLS-1$
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(this == obj)
			ret = true;
		else if(obj instanceof Pair) {
			Pair<?, ?> pair = (Pair<?, ?>) obj;
			ret = (this.first == null ? pair.first == null : this.first.equals(pair.first))
				&& (this.second == null ? pair.second == null : this.second.equals(pair.second));
		}
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int f = this.first == null ? 0 : this.first.hashCode();
		int s = this.second == null ? 0 : this.second.hashCode();
		return f * prime + s;
	}
}
