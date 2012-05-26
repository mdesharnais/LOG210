package hotel;

import hotel.util.ObservableList;

import java.util.ArrayList;
import java.util.Date;

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
	
	public ObservableList<ReservationDetail> getDetails() {
		return details;
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
	
	public void setClerk(User value)
	{
		clerk = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Date                              arrival;
	private Date                              departure;
	private int                               confirmationNumber;
	private Client                            client;
	private User                              clerk;
	private ObservableList<ReservationDetail> details = new ObservableList<ReservationDetail>();
}
