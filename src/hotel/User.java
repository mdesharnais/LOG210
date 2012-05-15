package hotel;

public class User {
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	public String getUsername()
	{
		return username;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void setUsername(String value)
	{
		username = value;
	}
	
	public void setPassword(String value)
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
