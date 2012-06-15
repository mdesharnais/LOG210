package hotel;

import java.util.Date;

public class Stay {
	
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Date getArrivalDate() {
		return arrival;
	}
	
	public Date getDepartureDate() {
		return departure;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public Client getClient() {
		return client;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Date arrival;
	private Date departure;
	private Room room;
	private Client client;
}
