package lawu.util;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 */
public interface Filter<T> {
	/**
	 * @param element
	 * @return
	 */
	public boolean keep(T element);
}
