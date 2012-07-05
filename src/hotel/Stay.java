package hotel;

import java.util.Date;

public class Stay {
	
	// --------------------------------------------------
	// Constructor(s)
	
	public Stay() {
		
	}
	
	public Stay(Date arrival, Date departure, Room room, Client client) {
		this.arrival = arrival;
		this.departure = departure;
		this.room = room;
		this.client = client;
	}
	
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
	
	public void setArrivalDate(Date value) {
		this.arrival = value;
	}
	
	public void setDepartureDate(Date value) {
		this.departure = value;
	}
	
	public void setRoom(Room value) {
		this.room = value;
	}
	
	public void setClient(Client value) {
		this.client = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Date arrival;
	private Date departure;
	private Room room;
	private Client client;
}
