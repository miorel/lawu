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
	private final Mapper<T, U> mapper;
	private final Iterator<T> iterator;
	
	/**
	 * @param mapper
	 * @param iterator
	 */
	public MappingIterator(Mapper<T, U> mapper, Iterator<T> iterator) {
		this.mapper = mapper;
		this.iterator = iterator;
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
