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
		if (validateName(value))
			name = value;
	}
	
	public void setTelephoneNumber(String value)
	{
		if (validateTelephoneNumber(value))
			telephoneNumber = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	private boolean validateName(String value) {
		return true;
	}
	
	private boolean validateTelephoneNumber(String value) {
		return true;
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private String name;
	private String telephoneNumber; 
}
