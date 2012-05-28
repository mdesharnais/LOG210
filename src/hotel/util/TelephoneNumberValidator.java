package hotel.util;

public class TelephoneNumberValidator
	implements Validator {

	// --------------------------------------------------
	// Constructor(s)
	
	public TelephoneNumberValidator(String num) {
		telephoneNumber = num;
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	// --------------------------------------------------
	// Mutators(s)
	
	@Override
	public Error validate() {
		return null;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)

	public String telephoneNumber;
}
