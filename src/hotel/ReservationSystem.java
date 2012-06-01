package hotel;

import java.util.Date;

public class ReservationSystem {
	
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Method(s)
	
	public void startNewReservation() {
		reservation = new Reservation();
	}
	
	public void addLine(int categoryID, int quantity, Date arrivalDate, Date departureDate) {
		Reservation.Detail newLine = new Reservation.Detail();
		
		newLine.setCaterorie(Hotel.getInstance().getRoomCategory(categoryID));
		newLine.setQuantity(quantity);
		newLine.setArrival(arrivalDate);
		newLine.setDeparture(departureDate);
		
		reservation.getDetails().add(newLine);
	}
	
	public void confirm(String clientName, String clientTelephoneNumber) {
		if (!saved) {
			Client client = null;
			
			for (Client c : Hotel.getInstance().getClients()) {
				if (c.getName().equals(clientName) && c.getTelephoneNumber().equals(clientTelephoneNumber)) {
					client = c;
					break;
				}
			}
			
			if (client == null) {
				client = new Client();
				client.setName(clientName);
				client.setTelephoneNumber(clientTelephoneNumber);
			}
			
			reservation.setClient(client);
			Agenda.getInstance().save(reservation);
		}
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	Reservation reservation;
	boolean     saved;
}
