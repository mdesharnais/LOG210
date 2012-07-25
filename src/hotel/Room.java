package hotel;

import hotel.util.Identifiable;
import hotel.util.Observable;

public class Room implements Comparable<Room>, Identifiable {
	
	// --------------------------------------------------
	// Constructor(s)
	
	public Room (int roomNumber, Category category) {
		this.id = ++s_lastId;
		this.roomNumber = roomNumber;
		this.category = category;
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	@Override
	public int getId() {
		return id;
	}
	
	public Category getCategorie() {
		return category;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	@Override
	public int compareTo(Room other) {
		if (roomNumber < other.roomNumber)
			return -1;
		else if (roomNumber > other.roomNumber)
			return 1;
		else
			return 0;
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
	
	private Category   category;
	private int        roomNumber;
	private int        id;
	private static int s_lastId = 0;
	
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
