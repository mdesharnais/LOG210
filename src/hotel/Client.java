package hotel;

import hotel.util.ErrorIterator;
import hotel.util.StringLengthValidator;
import hotel.util.TelephoneNumberValidator;
import hotel.util.ValidationError;
import hotel.util.Validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class Client extends Observable {
	// --------------------------------------------------
	// Constructor(s)
	
	public Client() {
		this("", "");
	}
	
	public Client(String name, String telephoneNumber) {
		this.setName(name);
		this.setTelephoneNumber(telephoneNumber);
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
		
	public void save() {
		
	}
	
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
