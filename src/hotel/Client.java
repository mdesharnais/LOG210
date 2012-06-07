package hotel;

import hotel.util.ValidationException;

import java.util.Observable;

public class Client extends Observable {
	// --------------------------------------------------
	// Constructor(s)
	
	public Client(String name, String telephoneNumber) throws ValidationException {
		setName(name);
		setTelephoneNumber(telephoneNumber);
	}
	
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
	
	public void setName(String value) throws ValidationException
	{
		if (value.isEmpty())
			throw new ValidationException();
		
			name = value;
	}
	
	public void setTelephoneNumber(String value) throws ValidationException
	{
		// Should validate telephone number.
		telephoneNumber = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	/**
	 * Retourne le nom du client (format String)
	 */
	public String toString() {
		return getName();
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private String name;
	private String telephoneNumber;
}
