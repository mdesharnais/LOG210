package hotel;

import hotel.util.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agenda extends ObservableList<Reservation> {
	
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
		add(value);
	}
	
	public void delete(Reservation value)
	{
		remove(value);
	}
	
	// --------------------------------------------------
	// Attribute(s)

	private static Agenda               instance = new Agenda();
}