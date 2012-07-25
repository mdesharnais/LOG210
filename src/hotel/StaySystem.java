package hotel;

import java.util.Date;

import hotel.util.Observer;
import hotel.util.RoomNotFound;

public class StaySystem {

	// --------------------------------------------------
	// Constructor(s)

	// --------------------------------------------------
	// Accessor(s)

	// --------------------------------------------------
	// Mutators(s)

	// --------------------------------------------------
	// Method(s)
	
	public void startStay(int confirmationNumber, Observer<Reservation> observer) {
		s = new Stay();
	}
	
	public void startStay(String clientName, String clientTelephoneNumber, Observer<Reservation> observer) {
		s = new Stay();
	}
	
	public void startStay(Date arrivalDate, Date departureDate) {
		s = new Stay();
	}
	
	public void startStay(Date arrivalDate, Date departureDate, Client client) {
		arrival = arrivalDate;
		this.departure = departure;
		this.client = client;
	}
	
	public void enterRoomCategory(int roomCategoryId) {
		s = new Stay();
	}
	
	public void confirmStay(int roomId) throws RoomNotFound {
		boolean found = false;
		Room room = null;
		
		for (Room r : Hotel.getInstance().getRooms()) {
			if (r.getRoomNumber() == roomId) {
				room = r;
				break;
			}
		}
		
		if (room == null)
			throw new RoomNotFound();
		else {
			s = new Stay();
			s.setClient(client);
			s.getDetails().add(new Stay.Detail(room, arrival, departure));
			Agenda.getInstance().save(s);
		}
	}

	// --------------------------------------------------
	// Attribute(s)
	
	private Stay s;
	private Date arrival;
	private Date departure;
	private Client client;
}
