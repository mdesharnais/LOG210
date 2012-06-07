package hotel;

import hotel.util.Identifiable;
import hotel.util.ObservableList;
import hotel.util.ValidationException;

import java.util.Date;
import java.util.Observable;

public class Reservation extends Observable implements Identifiable {

	// --------------------------------------------------
	// Constructor(s)

	public Reservation() {
		id = ++s_lastId;
	}
	
	// --------------------------------------------------
	// Accessor(s)

	@Override
	public int getId() {
		return id;
	}
	
	public int getConfirmationNumber() {
		return confirmationNumber;
	}

	public Client getClient() {
		return client;
	}

	public ObservableList<Detail> getDetails() {
		return details;
	}

	// --------------------------------------------------
	// Mutators(s)

	public void setClient(Client value) {
		client = value;
		notifyObservers();
	}
	
	/**
	 * genere un numero de confirmation
	 */
	public void generateConfirmationNumber() {
		confirmationNumber = id*id*2*3*4*5*6*7;
	}

	// --------------------------------------------------
	// Method(s)

	// --------------------------------------------------
	// Attribute(s)

	private int confirmationNumber;
	private Client client;
	private ObservableList<Detail> details = new ObservableList<Detail>();
	private int id;
	private static int s_lastId = 0;

	// --------------------------------------------------
	// Attribute(s)

	public static class Detail extends Observable implements Identifiable {

		// --------------------------------------------------
		// Constructor(s)

		public Detail() {
			id = ++s_lastId;
		}

		// --------------------------------------------------
		// Accessor(s)

		public Room.Category getCategory() {
			return categorie;
		}

		public int getQuantity() {
			return quantity;
		}

		public Date getArrival() {
			return arrival;
		}

		public Date getDeparture() {
			return departure;
		}

		@Override
		public int getId() {
			return id;
		}

		// --------------------------------------------------
		// Mutators(s)

		public void setCategory(Room.Category value) {
			categorie = value;
			setChanged();
			notifyObservers();
		}

		public void setQuantity(int value) throws ValidationException {
			if (value < QUANTITY_MIN_VALUE || QUANTITY_MAX_VALUE < value)
				throw new ValidationException();
			
			quantity = value;
			setChanged();
			notifyObservers();
		}

		public void setArrivalAndDepartureDates(Date arrival, Date departure) throws ValidationException {
			if (arrival.after(departure))
				throw new ValidationException();
			
			this.arrival = arrival;
			this.departure = departure;
			setChanged();
			notifyObservers();
		}

		// --------------------------------------------------
		// Method(s)
		
		// --------------------------------------------------
		// Attribute(s)

		private Room.Category categorie;
		private int quantity;
		private Date arrival;
		private Date departure;
		private int id;
		private static int s_lastId = 0;
		
		public static final int QUANTITY_MIN_VALUE = 1;
		public static final int QUANTITY_MAX_VALUE = 999;
	}
}
