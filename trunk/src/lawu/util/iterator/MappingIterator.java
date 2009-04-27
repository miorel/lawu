package lawu.util.iterator;

import lawu.dp.Iterator;
import lawu.util.Mapper;

/**
 * @author Miorel-Lucian Palii
 *
 * @param <T>
 * @param <U>
 */
public class MappingIterator<T, U> extends AbstractUniversalIterator<U> {
	private final Iterator<T> iterator;
	private final Mapper<T, U> mapper;
	
	/**
	 * @param iterator
	 * @param mapper
	 */
	public MappingIterator(Iterator<T> iterator, Mapper<T, U> mapper) {
		this.iterator = iterator;
		this.mapper = mapper;
	}
	
	public void advance() {
		this.iterator.advance();
	}

	public U current() {
		return this.mapper.map(this.iterator.current());
	}

	public boolean isDone() {
		return this.iterator.isDone();
	}

	public void reset() {
		this.iterator.reset();
	}
}
