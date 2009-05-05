/**
 * 
 */
package lawu.util;

/**
 * @author Miorel-Lucian Palii
 */
public class Triple<T, U, V> {
	private final T first;
	private final U second;
	private final V third;
	
	public Triple(T first, U second, V third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public T getFirst() {
		return this.first;
	}
	
	public U getSecond() {
		return this.second;
	}
	
	public V getThird() {
		return this.third;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %s, %s]", getFirst(), getSecond(), getThird()); //$NON-NLS-1$
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(this == obj)
			ret = true;
		else if(obj instanceof Triple) {
			Triple<?, ?, ?> triple = (Triple<?, ?, ?>) obj;
			ret = (this.first == null ? triple.first == null : this.first.equals(triple.first))
				&& (this.second == null ? triple.second == null : this.second.equals(triple.second))
				&& (this.third == null ? triple.third == null : this.third.equals(triple.third));
		}
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int f = this.first == null ? 0 : this.first.hashCode();
		int s = this.second == null ? 0 : this.second.hashCode();
		int t = this.third == null ? 0 : this.third.hashCode();
		return (f * prime + s) * prime + t;
	}
}
