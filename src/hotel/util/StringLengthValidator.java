package hotel.util;

public class StringLengthValidator
	implements Validator {

	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	@Override
	public ValidationError validate() {
		return null;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public StringLengthValidator value(String str) {
		value = str;
		return this;
	}
	
	public StringLengthValidator min(int n) {
		minLength = n;
		return this;
	}
	
	public StringLengthValidator max(int n) {
		maxLength = n;
		return this;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)

	private String value;
	private int minLength = 0;
	private int maxLength = 0;
}
