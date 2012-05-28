package hotel;

import hotel.util.ErrorIterator;
import hotel.util.StringLengthValidator;
import hotel.util.TelephoneNumberValidator;
import hotel.util.ValidationError;
import hotel.util.Validator;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public Iterator<ValidationError> errorIterator() {
		ArrayList<Validator> validators = new ArrayList<Validator>();
		validators.add(telephoneNumberValidator.value(telephoneNumber));
		validators.add(nameValidator.value(name));
		
		return new ErrorIterator(validators.iterator());
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
	
	public void save() {
		
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private String name;
	private String telephoneNumber;
	
	private TelephoneNumberValidator telephoneNumberValidator = new TelephoneNumberValidator(); 
	private StringLengthValidator    nameValidator = new StringLengthValidator().max(50);
}
