package lawu.dp;

/**
 * The Gang of Four's favorite iterator interface. Abstracts the traversal of an
 * aggregate structure from the underlying representation. Note that method
 * names have been modified from those given by the Gang of Four but the
 * behavior is the same.
 * 
 * Use an iterator as follows:
 * 
 * <code>Iterator<SomeType> iter = someMethod();
 * for(iter.reset(); !iter.isDone(); iter.advance()) {
 *     // do something with iter.current()
 * }</code>
 * 
 * @author Miorel-Lucian Palii
 * 
 * @param <T>
 *            the type over which this iterator iterates
 */
public interface Iterator<T> {
	/**
	 * Moves this iterator to the beginning of the traversal.
	 */
	public void reset();

	/**
	 * Checks whether or not this iterator has exhausted all the elements of its
	 * underlying structure.
	 * 
	 * @return whether or not this iterator has exhausted all its elements
	 */
	public boolean isDone();

	/**
	 * Advances this iterator to the next element.
	 */
	public void advance();

	/**
	 * Retrieves the current element in the traversal represented by this
	 * iterator.
	 * 
	 * @return the current element in the traversal
	 */
	public T current();
}
