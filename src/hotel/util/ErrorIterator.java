package hotel.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ErrorIterator
	implements Iterator<ValidationError> {
	
	// --------------------------------------------------
	// Constructor(s)
	
	public ErrorIterator(Iterator<Validator> it) {
		validatorIterator = it;
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	@Override
	public boolean hasNext() {
		// If there is no error, try to find a new one
		if (error == null)
			error = getNextError();

		return error != null;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	@Override
	public ValidationError next() {
		// If there is no error, try to find a new one
		if (error == null)
			error = getNextError();

		// If there is still no error, end of iteration
		if (error == null)
			throw new NoSuchElementException();

		// return the error and leave the current error in a null state
		ValidationError temp = error;
		error = null;
		return temp;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	// --------------------------------------------------
	// Method(s)
	
	/**
	 * Return the next error or null if no error can be found.
	 */
	private ValidationError getNextError() {
		ValidationError error = null;

		while (validatorIterator.hasNext() && error == null) {
			Validator v = validatorIterator.next();
			error = v.validate();
		}

		return error;
	}
	
	// --------------------------------------------------
	// Attribute(s)

	private Iterator<Validator> validatorIterator;
	private ValidationError               error;
}
