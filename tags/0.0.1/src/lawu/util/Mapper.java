package lawu.util;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 * @param <U>
 */
public interface Mapper<T, U> {
	/**
	 * @param element
	 * @return
	 */
	public U map(T element);
}
