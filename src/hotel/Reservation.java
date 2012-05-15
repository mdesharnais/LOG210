package hotel;

import java.util.Date;
import java.util.ArrayList;

public class Reservation {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Date getArrival()
	{
		return arrival;
	}
	
	public Date getDeparture()
	{
		return departure;
	}
	
	public int getConfirmationNumber()
	{
		return confirmationNumber;
	}
	
	public Client getClient()
	{
		return client;
	}
	
	public User getClerk()
	{
		return clerk;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setArrival(Date value)
	{
		arrival = value;
	}
	
	public void setDeparture(Date value)
	{
		departure = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	public void addRoom(Room value)
	{
		rooms.add(value);
	}
	
	public void removeRoom(Room value)
	{
		rooms.remove(value);
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Date            arrival;
	private Date            departure; 
	private int             confirmationNumber;
	private Client          client;
	private User            clerk;
	private ArrayList<Room> rooms;
}
