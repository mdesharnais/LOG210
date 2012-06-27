package hotel;

import java.util.ArrayList;
import java.util.List;

import hotel.util.Observable;
import hotel.util.ValidationException;

public class Client extends Observable<Client> {
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
	
	public List<Integer> getReservationList()
	{
		return reservationList;
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
	
	public void addReservation(int noConfirmation) {
		reservationList.add(noConfirmation);
	}
	
	public void deleteReservation(int noConfirmation) {
		reservationList.remove(noConfirmation);
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private String name;
	private String telephoneNumber;
	private List<Integer> reservationList = new ArrayList<Integer>();
}
