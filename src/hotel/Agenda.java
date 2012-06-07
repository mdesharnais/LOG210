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
	
	public void save(Reservation value)
	{
		add(value);
	}
	
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
	
	// --------------------------------------------------
	// Attribute(s)

	private static Agenda instance = new Agenda();
}