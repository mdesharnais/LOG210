package hotel;

import hotel.util.Identifiable;
import hotel.util.Observable;

public class Room {
	
	// --------------------------------------------------
	// Constructor(s)
	
	public Room (int roomNumber, Category category) {
		this.roomNumber = roomNumber;
		this.category = category;
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Category getCategorie() {
		return category;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setCategorie(Category value) {
		category = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Category category;
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
