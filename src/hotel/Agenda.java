package hotel;

import java.util.ArrayList;
import java.util.Iterator;

public class Agenda
	implements Iterable<Reservation> {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)

	public void save(Reservation value)
	{
		reservations.add(value);
	}
	
	public void delete(Reservation value)
	{
		reservations.remove(value);
	}
	
	@Override 
	public Iterator<Reservation> iterator() {
		return reservations.iterator();
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
}