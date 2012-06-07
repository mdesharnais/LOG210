package hotel;

import hotel.Room.Category;

import java.util.ArrayList;
import java.util.Iterator;

public class CategoriesList
	implements Iterable<Room.Category> {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)

	/**
	 * Retourne l'iterateur de l'arraylist
	 */
	@Override
	public Iterator<Category> iterator() {
		return categories.iterator();
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private ArrayList<Room.Category> categories;
}
