package hotel.util;

/**
 * Function object representing the business logic validation of one or may attributes.
 */
public interface Validator {
	
	public ValidationError validate();
	
}
