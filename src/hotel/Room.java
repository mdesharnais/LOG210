package hotel;

import java.util.Observable;

public class Room {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Categorie getCategorie()
	{
		return categorie;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setCategorie(Categorie value)
	{
		categorie = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Categorie categorie;
	
	// --------------------------------------------------	
	// Inner class

	public static class Categorie
		extends Observable {
		
		// --------------------------------------------------
		// Constructor(s)
		
		public Categorie()
		{
			this("");
		}
		
		public Categorie(String categorieName)
		{
			setName(categorieName);
			id = ++s_lastId;
		}
		
		// --------------------------------------------------
		// Accessor(s)
		
		public String getName()
		{
			return name;
		}
		
		public int getId()
		{
			return id;
		}
		
		// --------------------------------------------------
		// Mutators(s)
		
		public void setName(String value)
		{
			name = value;
			setChanged();
			notifyObservers(this);
		}
		
		// --------------------------------------------------
		// Method(s)
		
		public String toString()
		{
			return name;
		}
		
		// --------------------------------------------------
		// Attribute(s)
		
		private String     name;
		private int        id;
		private static int s_lastId = 0;
	}
}
