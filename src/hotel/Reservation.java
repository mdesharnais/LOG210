package hotel;

import hotel.util.ObservableList;

import java.util.Date;
import java.util.Observable;

public class Reservation {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public int getConfirmationNumber()
	{
		return confirmationNumber;
	}
	
	public Client getClient()
	{
		return client;
	}
	
	public ObservableList<Detail> getDetails() {
		return details;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setClient(Client value) {
		client = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private int                    confirmationNumber;
	private Client                 client;
	private ObservableList<Detail> details = new ObservableList<Detail>();
	
	// --------------------------------------------------
	// Attribute(s)
	
	public static class Detail
		extends Observable {
		
		// --------------------------------------------------
		// Constructor(s)
		
		// --------------------------------------------------
		// Accessor(s)
		
		public Room.Category getCategorie()
		{
			return categorie;
		}
		
		public int getQuantity()
		{
			return quantity;
		}
	
		public Date getArrival()
		{
			return arrival;
		}
		
		public Date getDeparture()
		{
			return departure;
		}
		
		// --------------------------------------------------
		// Mutators(s)
		
		public void setCaterorie(Room.Category value)
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
		
		// --------------------------------------------------
		// Attribute(s)
		
		private Room.Category categorie;
		private int            quantity;
		private Date           arrival;
		private Date           departure;
	}
}
