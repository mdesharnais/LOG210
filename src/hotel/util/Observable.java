package hotel.util;

public class Observable
	extends java.util.Observable {
	
	public void notifyObservers(Object arg)  {
		setChanged();
		super.notifyObservers(arg);
	}
}
