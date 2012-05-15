package hotel;

public class Client {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public String getName()
	{
		return name;
	}
	
	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setName(String value)
	{
		name = value;
	}
	
	public void setTelephoneNumber(String value)
	{
		telephoneNumber = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	private String name;
	private String telephoneNumber; 
}
