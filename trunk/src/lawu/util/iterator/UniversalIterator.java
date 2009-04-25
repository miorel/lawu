package lawu.util.iterator;

import java.util.Enumeration;

import lawu.dp.Iterator;

public interface UniversalIterator<T> extends Iterator<T>,
		java.util.Iterator<T>, Iterable<T>, Enumeration<T> {
}
