package hotel;

import hotel.util.ErrorIterator;
import hotel.util.StringLengthValidator;
import hotel.util.TelephoneNumberValidator;
import hotel.util.ValidationError;
import hotel.util.ValidationException;
import hotel.util.Validator;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public Iterator<ValidationError> errorIterator() {
		ArrayList<Validator> validators = new ArrayList<Validator>();
		validators.add(telephoneNumberValidator.value(telephoneNumber));
		validators.add(nameValidator.value(name));
		
		return new ErrorIterator(validators.iterator());
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
	
	private TelephoneNumberValidator telephoneNumberValidator = new TelephoneNumberValidator(); 
	private StringLengthValidator    nameValidator = new StringLengthValidator().max(50);
}
