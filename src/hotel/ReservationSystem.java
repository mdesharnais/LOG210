package hotel;

import hotel.util.NotEnoughRooms;
import hotel.util.ValidationException;

import java.util.Date;
import java.util.Map;
import java.util.Observer;

public class ReservationSystem {
	
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Method(s)
	
	/**
	 * Cree une nouvelle instance du systeme de reservation
	 */
	public void startNewReservation() {
		reservation = new Reservation();
	}
	
	/**
	 * Ajoute une ligne a la reservation en cours
	 * @param categoryID
	 * @param quantity
	 * @param arrivalDate
	 * @param departureDate
	 * @throws ValidationException
	 */
	public void addLine(int categoryID, int quantity, Date arrivalDate, Date departureDate) throws ValidationException {
		Map<Room.Category, Integer> freeCategories = Agenda.getInstance().getFreeRoomCategoriesBetween(arrivalDate, departureDate);
		Room.Category category = Hotel.getInstance().getRoomCategory(categoryID);
		Integer freeRooms = freeCategories.get(category);
		freeRooms = (freeRooms != null ? freeRooms : 0);
		
		// TODO: Ne pas oublier de prendre en compte les détails de la réservations.
		// Finalement, on va le mettre dans les "known issues".
		
		if (quantity > freeRooms)
			throw new NotEnoughRooms();
		
		Reservation.Detail newLine = new Reservation.Detail();
		
		newLine.setCategory(Hotel.getInstance().getRoomCategory(categoryID));
		newLine.setQuantity(quantity);
		newLine.setArrivalAndDepartureDates(arrivalDate, departureDate);
		
		reservation.getDetails().add(newLine);
	}
	
	/**
	 * Supprime une ligne a la reservation en cours
	 * @param id
	 */
	public void removeLine(int id) {
		for( Reservation.Detail d : reservation.getDetails()) {
			if (d.getId() == id) {
				reservation.getDetails().remove(d);
				break;
			}
		}
	}
	
	/**
	 * Permet de sauvegarder la reservation en cours
	 * @param clientName
	 * @param clientTelephoneNumber
	 * @return
	 * @throws ValidationException
	 */
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
	
	/**
	 * Ajoute un observer a la reservation
	 * @param o
	 */
	public void addReservationListener(Observer o) {
		reservation.addObserver(o);
	}
	
	/**
	 * Ajoute un observer au detail de la reservation 
	 * @param o
	 */
	public void addReservationDetailAddedListener(Observer o) {
		reservation.getDetails().AddElementAddedListener(o);
	}
	
	/**
	 * Supprime un observer au detail de la reservation
	 * @param o
	 */
	public void addReservationDetailRemovedListener(Observer o) {
		reservation.getDetails().AddElementRemovedListener(o);
	}

	// --------------------------------------------------
	// Attribute(s)
	
	Reservation reservation;
	boolean     saved;
}
