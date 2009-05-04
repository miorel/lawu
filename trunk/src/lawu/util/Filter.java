package lawu.util;

/**
 * @author Miorel-Lucian Palii
 * @param <T> the type which this filter filters
 */
public interface Filter<T> {
	/**
	 * @param element the element to check
	 * @return whether or not to keep the element
	 */
	public boolean keep(T element);
}
