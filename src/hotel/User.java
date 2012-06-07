package hotel;

import hotel.util.ValidationException;

public class User {
	// --------------------------------------------------
	// Constructor(s)
	
	public User() throws ValidationException {
		this("", "");
	}
	
	public User(String username, String password) throws ValidationException {
		setUsername(username);
		setPassword(password);
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	public String getUsername()
	{
		return username;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setUsername(String value) throws ValidationException
	{
		username = value;
	}
	
	public void setPassword(String value) throws ValidationException
	{
		password = value;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	public boolean isValidPassword(String value)
	{
		return password.equals(value);
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private String username;
	private String password; 
}
