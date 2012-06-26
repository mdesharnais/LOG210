package hotel;

import hotel.util.ObservableList;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Agenda extends ObservableList<Reservation> {
	
	// --------------------------------------------------
	// Constructor(s)
	
	private Agenda() {
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)

	public static Agenda getInstance() {
		return instance;
	}
	
	/**
	 * Ajoute une reservation
	 * @param value
	 */
	public void save(Reservation value)
	{
		add(value);
	}
	
	/**
	 * Enleve une reservation
	 * @param value
	 */
	public void delete(Reservation value)
	{
		remove(value);
	}
	
	
	// Here are the different possibilities:
	//                 begin                end
	//                   |                   |
	// arrival departure |                   |
	//           arrival | departure         |
	//           arrival |                   | departure
	//                   | arrival departure |
	//                   |           arrival | departure
	//                   |                   | arrival departure
	/**
	 * Cette fonction retourne la liste, par categorie, du nombre de chambres utilisee dans l'interval de dates donnees
	 * @param begin
	 * @param end
	 * @return
	 */
	public Map<Room.Category, Integer> getUsedRoomCategoriesBetween(Date begin, Date end) {
		Map<Room.Category, Integer> categoriesOccurences = new TreeMap<Room.Category, Integer>();
		
		for (Reservation r : this) {
			for (Reservation.Detail d : r.getDetails()) {
				Date arrival = d.getArrival();
				Date departure = d.getDeparture();
				
				if (arrival.before(begin) && departure.after(begin)
						|| arrival.before(begin) && departure.after(end)
						|| arrival.after(begin) && arrival.before(end) && departure.after(begin) && departure.before(end)
						|| arrival.after(begin) && arrival.before(end) && departure.after(end)) {
					
					Integer count = categoriesOccurences.get(d.getCategory());
					if (count == null)
						count = 0;
					categoriesOccurences.put(d.getCategory(), count + d.getQuantity());
				}	
			}
		}
		
		return categoriesOccurences;
	}
	
	/**
	 * Cette fonction retourne la liste, par categorie, du nombre de chambres libre dans l'interval de dates donnees
	 * @param begin
	 * @param end
	 * @return
	 */
	public Map<Room.Category, Integer> getFreeRoomCategoriesBetween(Date begin, Date end) {
		Map<Room.Category, Integer> categoriesUsed = getUsedRoomCategoriesBetween(begin, end);
		Map<Room.Category, Integer> results = new TreeMap<Room.Category, Integer>();
		
		for (Map.Entry<Room.Category, Integer> entry : Hotel.getInstance().getTotalRoomCategories().entrySet()) {
			Room.Category category = entry.getKey();
			Integer quantity = entry.getValue();
			Integer used = categoriesUsed.get(category);
			used = (used != null ? used : 0);
			results.put(category, quantity - used);
		}
		
		return results;
	}
	
	public Reservation getReservation(int noConfirmation) {
		Reservation r = null;
		for(int i = 0; i < size(); i++)
			r = get(i);
		return r;
	}
	
	// --------------------------------------------------
	// Attribute(s)

	private static Agenda instance = new Agenda();
}