package hotel;

public class ReservationDetail {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Room.Categorie getCategorie()
	{
		return categorie;
	}
	
	public int getCount()
	{
		return count;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setCaterorie(Room.Categorie value)
	{
		categorie = value;
	}
	
	public void setCount(int value)
	{
		count = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Room.Categorie categorie;
	private int            count;
}
