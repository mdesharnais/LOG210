package hotel;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		User u = new User();
		Client c = new Client();
		Room ro = new Room();
		Room.Categorie ca = new Room.Categorie();
		Reservation re = new Reservation();
		
		u.setUsername("bob");
		u.setPassword("1234");
		System.out.println(u.getUsername());
		System.out.println(u.isValidPassword("1234"));

		c.setName("name");
		c.setTelephoneNumber("123-456-7890");
		System.out.println(c.getName());
		System.out.println(c.getTelephoneNumber());
		
		ca.setName("suite");
		System.out.println(ca.getName());
		
		ro.setCategorie(ca);
		
		re.setArrival(new Date());
		re.setDeparture(new Date());
		re.setClerk(u);
		System.out.println(re.getArrival());
		System.out.println(re.getDeparture());
	}

}
