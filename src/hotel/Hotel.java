package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	
	// --------------------------------------------------
	// Constructor(s)
	
	private Hotel() {
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	public static Hotel getInstance() {
		return instance;
	}
	
	public List<Room.Category> getRoomCategories() {
		return roomCategories;
	}
	
	public Room.Category getRoomCategory(int id) {
		for (Room.Category cat : roomCategories) {
			if (cat.getId() == id)
				return cat;
		}
		
		return null;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private static Hotel        instance = new Hotel();
	private List<Room.Category> roomCategories = new ArrayList<Room.Category>();
	private List<Client>        clients = new ArrayList<Client>();
}