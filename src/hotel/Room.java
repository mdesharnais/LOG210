package hotel;

public class Room {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public Categorie getCategorie()
	{
		return categorie;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setCategorie(Categorie value)
	{
		categorie = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private Categorie categorie;
	
	// --------------------------------------------------	
	// Inner class

	public class Categorie {
		// --------------------------------------------------
		// Constructor(s)
		
		// --------------------------------------------------
		// Accessor(s)
		
		public String getName()
		{
			return name;
		}
		
		// --------------------------------------------------
		// Mutators(s)
		
		public void setName(String value)
		{
			name = value;
		}
		
		// --------------------------------------------------
		// Method(s)
		
		// --------------------------------------------------
		// Attribute(s)
		
		private String name;
	}
}
