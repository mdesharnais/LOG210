package hotel;

import hotel.util.Identifiable;
import hotel.util.Observable;

public class Room {
	
	// --------------------------------------------------
	// Constructor(s)
	
	public Room (int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Category getCategorie()
	{
		return categorie;
	}
	
	public int getRoomNumber() {
		return roomNumber;
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
	private int roomNumber;
	
	// --------------------------------------------------	
	// Inner class

	public static class Category
		extends Observable<Category>
		implements Comparable<Category>, Identifiable {
		
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
		
		@Override
		public int getId()
		{
			return id;
		}
		
		// --------------------------------------------------
		// Mutators(s)
		
		public void setName(String value)
		{
			name = value;
			notifyObservers();
		}
		
		// --------------------------------------------------
		// Method(s)
		
		@Override
		public String toString()
		{
			return name;
		}
		
		@Override
		public int compareTo(Category other) {
			return name.compareTo(other.name);
		}
		
		// --------------------------------------------------
		// Attribute(s)
		
		private String     name;
		private int        id;
		private static int s_lastId = 0;
	}
}
