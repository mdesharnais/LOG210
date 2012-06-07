package hotel;

import hotel.util.ObservableList;
import hotel.util.ValidationException;

import java.util.Map;
import java.util.TreeMap;

public class Hotel {
	
	// --------------------------------------------------
	// Constructor(s)
	
	private Hotel() {
		generateRoomCategories();
		generateClients();
		generateUsers();
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	public static Hotel getInstance() {
		return instance;
	}
	
	public ObservableList<Room.Category> getRoomCategories() {
		return roomCategories;
	}
	
	public Room.Category getRoomCategory(int id) {
		for (Room.Category cat : roomCategories) {
			if (cat.getId() == id)
				return cat;
		}
		
		return null;
	}
	
	public Map<Room.Category, Integer> getTotalRoomCategories() {
		Map<Room.Category, Integer> categoriesOccurences = new TreeMap<Room.Category, Integer>();
		
		for (Room.Category c : roomCategories) {
			categoriesOccurences.put(c, 5);
		}
		
		return categoriesOccurences;
	}
	
	public ObservableList<Client> getClients() {
		return clients;
	}
	
	public ObservableList<User> getUsers() {
		return users;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)
	
	private void generateRoomCategories() {
		roomCategories.add(new Room.Category("Cheap"));
		roomCategories.add(new Room.Category("Normal"));
		roomCategories.add(new Room.Category("Deluxe"));
	}
	
	private void generateClients() {
		try {
			clients.add(new Client("Gilles",     "111 111-1111"));
			clients.add(new Client("Paul",       "222 222-2222"));
			clients.add(new Client("Robert",     "333 333-3333"));
			clients.add(new Client("Abraham",    "444 444-4444"));
			clients.add(new Client("Erménégile", "555 555-5555"));
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
	
	private void generateUsers() {
		try {
			users.add(new User("admin", ""));
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private static Hotel                  instance = new Hotel();
	private ObservableList<Room.Category> roomCategories = new ObservableList<Room.Category>();
	private ObservableList<Client>        clients = new ObservableList<Client>();
	private ObservableList<User>          users = new ObservableList<User>();
}
