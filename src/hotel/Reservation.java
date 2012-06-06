package hotel;

import hotel.util.Identifiable;
import hotel.util.ObservableList;

import java.util.Date;
import java.util.Observable;

public class Reservation extends Observable {

	// --------------------------------------------------
	// Constructor(s)

	// --------------------------------------------------
	// Accessor(s)

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

	// --------------------------------------------------
	// Method(s)

	// --------------------------------------------------
	// Attribute(s)

	private int confirmationNumber;
	private Client client;
	private ObservableList<Detail> details = new ObservableList<Detail>();

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

		public void setQuantity(int value) {
			quantity = value;
			setChanged();
			notifyObservers();
		}

		public void setArrival(Date value) {
			arrival = value;
		}

		public void setDeparture(Date value) {
			departure = value;
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
	}
}
