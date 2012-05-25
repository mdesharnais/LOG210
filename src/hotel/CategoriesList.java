package hotel;

import hotel.Room.Categorie;

import java.util.ArrayList;
import java.util.Iterator;

public class CategoriesList
	implements Iterable<Room.Categorie> {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)

	@Override
	public Iterator<Categorie> iterator() {
		return categories.iterator();
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private ArrayList<Room.Categorie> categories;
}
