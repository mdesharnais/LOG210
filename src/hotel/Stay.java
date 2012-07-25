package hotel;

import hotel.Reservation.Detail;
import hotel.util.Identifiable;
import hotel.util.Observable;
import hotel.util.ObservableList;
import hotel.util.ValidationException;

import java.util.Date;

public class Stay {
	
	// --------------------------------------------------
	// Constructor(s)
	
	public Stay() {
		
	}
	
	public Stay(Client client) {
		this.client = client;
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Date getArrivalDate() {
		return details.get(0).getArrivalDate();
	}
	
	public Date getDepartureDate() {
		return details.get(details.size() - 1).getDepartureDate();
	}
	
	public Room getRoom() {
		return details.get(details.size() - 1).getRoom();
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
		this.client = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Client client;
	private ObservableList<Detail> details = new ObservableList<Detail>();
	
	// --------------------------------------------------
	// Inner type(s)
	
	public static class Detail extends Observable<Detail> implements Identifiable {
		// --------------------------------------------------
		// Constructor(s)

		public Detail(Room r, Date arrival, Date departure) {
			id = ++s_lastId;
			room = r;
			this.arrival = arrival;
			this.departure = departure;
		}

		// --------------------------------------------------
		// Accessor(s)

		public Room getRoom() {
			return room;
		}

		public Date getArrivalDate() {
			return arrival;
		}

		public Date getDepartureDate() {
			return departure;
		}

		@Override
		public int getId() {
			return id;
		}

		// --------------------------------------------------
		// Mutators(s)

		public void setRoom(Room value) {
			room = value;
			notifyObservers();
		}

		public void setArrivalAndDepartureDates(Date arrival, Date departure) throws ValidationException {
			if (arrival.after(departure))
				throw new ValidationException();
			
			this.arrival = arrival;
			this.departure = departure;
			notifyObservers();
		}

		// --------------------------------------------------
		// Method(s)
		
		// --------------------------------------------------
		// Attribute(s)

		private Room room;
		private Date arrival;
		private Date departure;
		private int id;
		private static int s_lastId = 0;
	}
}
