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
		s = new Stay();
		s.setArrivalDate(arrivalDate);
		s.setDepartureDate(departureDate);
		s.setClient(client);
	}
	
	public void enterRoomCategory(int roomCategoryId) {
		s = new Stay();
	}
	
	public void confirmStay(int roomId) throws RoomNotFound {
		boolean found = false;
		
		for (Room room : Hotel.getInstance().getRooms()) {
			if (room.getRoomNumber() == roomId) {
				s.setRoom(room);
				found = true;
				break;
			}
		}
		
		if (!found)
			throw new RoomNotFound();
		else
			Agenda.getInstance().addStay(s);
	}

	// --------------------------------------------------
	// Attribute(s)
	
	private Stay s;
}
