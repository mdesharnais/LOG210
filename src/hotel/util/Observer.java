package hotel.util;

public interface Observer<T>
	extends java.util.Observer {
		
	void update(Observable o, Object arg);
}
