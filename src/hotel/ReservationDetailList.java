package hotel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class ReservationDetailList
	implements Iterable<ReservationDetail> {
	
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public int size() {
		return data.size();
	}
	
	public ReservationDetail get(int index) {
		return data.get(index);
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void add(ReservationDetail value) {
		data.add(value);
		elementAdded.notifyObservers(this);
	}
	
	// --------------------------------------------------
	// Method(s)

	@Override
	public Iterator<ReservationDetail> iterator() {
		return data.iterator();
	}
	
	public void AddElementAddedListener(Observer observer) {
		elementAdded.addObserver(observer);
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private ArrayList<ReservationDetail> data = new ArrayList<ReservationDetail>();
	private hotel.util.Observable elementAdded = new hotel.util.Observable(); 
}
