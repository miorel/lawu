package lawu.util.iterator;

public interface Iterator<T> {
	public void reset();
	
	public boolean isDone();
	
	public void advance();
	
	public T current();
}
