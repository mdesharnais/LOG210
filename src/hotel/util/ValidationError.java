package hotel.util;

/**
 * Represent an error which can be found when validating business logic.
 * 
 * @see hotel.util.Validator
 */
public enum ValidationError {
	INVALID_TELEPHONE_NUMBER,
	INVALID_DATE_RANGE,
	STRING_TO_LONG,
	STRING_TO_SHORT
}
