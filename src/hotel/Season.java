package hotel;

import hotel.Room.Category;
import hotel.util.Identifiable;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Map;
import java.util.Date;

public class Season implements Identifiable {
	
	// --------------------------------------------------
	// Constructor(s)
	
	/**
	 * L'interval de date specifie est inclusivement
	 * @param startDate
	 * @param endDate
	 */
	public Season(Date startDate, Date endDate) {
		id = ++s_lastId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)
	
	/**
	 * Si la categorie n'existe pas elle est ajoute avec son prix, sinon
	 * l'ancien prix est remplacer par le nouveau prix
	 * @param category
	 * @param price
	 */
	public void setCategoryPrice(Room.Category category, double price) {
		categoryList.put(category, price);
	}
	
	/**
	 * Retourne le prix courant de la categorie, si la categorie n'est pas trouve, le prix associe est 0
	 * @param category
	 * @return
	 */
	public double getCategoryPrice(Room.Category category) {
		Double price = categoryList.get(category);
		if (price != null)
			return price.doubleValue();
		else
			return 0;
	}
	
	/**
	 * Retourne l'iterateur de la tree map
	 * @return
	 */
	public Iterator<Entry<Category, Double>> iterator() {
		return categoryList.entrySet().iterator();
	}
	
	// --------------------------------------------------
	// Attribute(s)

	private int id;
	private static int s_lastId = 0;
	private Date startDate;
	private Date endDate;
	private Map<Room.Category, Double> categoryList = new TreeMap<Room.Category, Double>();
}
