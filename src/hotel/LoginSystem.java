package hotel;

import hotel.util.ValidationException;

public class LoginSystem {
	
	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Method(s)
	public void login(String username, String password) throws ValidationException {
		for (User user : Hotel.getInstance().getUsers()) {
			if (user.getUsername().equals(username) && user.isValidPassword(password)) {
				currentUser = user;
				return;
			}
		}
		
		throw new ValidationException();
	}
	
	public boolean isConnected() {
		return currentUser != null;
	}

	// --------------------------------------------------
	// Attribute(s)
	
	private User currentUser;
}
