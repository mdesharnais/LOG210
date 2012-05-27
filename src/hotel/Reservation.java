package hotel;

import hotel.util.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

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
	
	public ObservableList<Detail> getDetails() {
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
	
	private Date                   arrival;
	private Date                   departure;
	private int                    confirmationNumber;
	private Client                 client;
	private User                   clerk;
	private ObservableList<Detail> details = new ObservableList<Detail>();
	
	// --------------------------------------------------
	// Attribute(s)
	
	public static class Detail
		extends Observable {
		
		// --------------------------------------------------
		// Constructor(s)
		
		public Detail() {
			id = ++s_previousId;
		}
		
		// --------------------------------------------------
		// Accessor(s)
		
		public int getId() {
			return id;
		}
		
		public Room.Categorie getCategorie()
		{
			return categorie;
		}
		
		public int getQuantity()
		{
			return quantity;
		}
		
		// --------------------------------------------------
		// Mutators(s)
		
		public void setCaterorie(Room.Categorie value)
		{
			categorie = value;
			setChanged();
			notifyObservers(this);
		}
		
		public void setQuantity(int value)
		{
			quantity = value;
			setChanged();
			notifyObservers(this);
		}
		
		// --------------------------------------------------
		// Method(s)
		
		// --------------------------------------------------
		// Attribute(s)
		
		private Room.Categorie categorie;
		private int            quantity;
		private int            id;
		private static int     s_previousId = 0;
	}
}
