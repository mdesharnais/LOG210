package hotel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agenda
	implements Iterable<Reservation> {
	
	// --------------------------------------------------
	// Constructor(s)
	
	private Agenda() {
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)

	public static Agenda getInstance() {
		return instance;
	}
	
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

	private static Agenda     instance = new Agenda();
	private List<Reservation> reservations = new ArrayList<Reservation>();
}