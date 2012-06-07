package hotel;

import hotel.util.ValidationException;

import java.util.Date;
import java.util.Observer;

public class ReservationSystem {
	
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Method(s)
	
	public void startNewReservation() {
		reservation = new Reservation();
	}
	
	public void addLine(int categoryID, int quantity, Date arrivalDate, Date departureDate) throws ValidationException {
		// On valide
		
		
		// On ajoute
		Reservation.Detail newLine = new Reservation.Detail();
		
		newLine.setCategory(Hotel.getInstance().getRoomCategory(categoryID));
		newLine.setQuantity(quantity);
		newLine.setArrivalAndDepartureDates(arrivalDate, departureDate);
		
		reservation.getDetails().add(newLine);
	}
	
	public void removeLine(int id) {
		for( Reservation.Detail d : reservation.getDetails()) {
			if (d.getId() == id) {
				reservation.getDetails().remove(d);
				break;
			}
		}
	}
	
	public int confirm(String clientName, String clientTelephoneNumber) throws ValidationException {
		if (!saved) {
			if (reservation.getDetails().isEmpty())
				throw new ValidationException();
			
			Client client = null;
			
			for (Client c : Hotel.getInstance().getClients()) {
				if (c.getName().equals(clientName) && c.getTelephoneNumber().equals(clientTelephoneNumber)) {
					client = c;
					break;
				}
			}
			
			if (client == null)
				client = new Client(clientName, clientTelephoneNumber);
			
			reservation.setClient(client);
			reservation.generateConfirmationNumber();
			Agenda.getInstance().save(reservation);
			saved = true;
		}
		
		return reservation.getConfirmationNumber();
	}
	
	public void addReservationListener(Observer o) {
		reservation.addObserver(o);
	}
	
	public void addReservationDetailAddedListener(Observer o) {
		reservation.getDetails().AddElementAddedListener(o);
	}
	
	public void addReservationDetailRemovedListener(Observer o) {
		reservation.getDetails().AddElementRemovedListener(o);
	}

	// --------------------------------------------------
	// Attribute(s)
	
	Reservation reservation = new Reservation();
	boolean     saved;
}
