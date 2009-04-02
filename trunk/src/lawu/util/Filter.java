package lawu.util;

public interface Filter<T> {
	public boolean keep(T element);
}
