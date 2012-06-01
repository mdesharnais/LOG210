package hotel;

import java.util.Observable;

public class Room {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Category getCategorie()
	{
		return categorie;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setCategorie(Category value)
	{
		categorie = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Category categorie;
	
	// --------------------------------------------------	
	// Inner class

	public static class Category
		extends Observable {
		
		// --------------------------------------------------
		// Constructor(s)
		
		public Category()
		{
			this("");
		}
		
		public Category(String categorieName)
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
