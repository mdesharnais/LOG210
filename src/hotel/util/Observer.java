package hotel.util;

public interface Observer<T> {
	
	// --------------------------------------------------
	// Method(s)
	
	public void update(T obj);
}
