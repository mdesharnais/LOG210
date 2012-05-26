package hotel;

import java.util.Observable;

public class ReservationDetail
	extends Observable {
	// --------------------------------------------------
	// Constructor(s)
	
	public ReservationDetail() {
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
