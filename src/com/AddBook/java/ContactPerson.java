package com.AddBook.java;

/**
 * 
 * @author Kapil
 *
 */
public class ContactPerson {
	
	/**
	 * following naming conventiaon
	 */
	private String firstName, lastName, email, address, city, state;
	private int zip;
	private long phonNum;

	ContactPerson(String firstName, String lastName, String email, String address, String city, String state, int zip,
			long phonNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phonNum = phonNum;
	}

	String getName() {
		return firstName + lastName;
	}
	
	public String toString() {
		return "Person Name: " + firstName + " " + lastName + "\nPerson Address: " + address + ", " + city + ", "
				+ state + "\nPerson Email: " + email + "\nPerson Postal Code: " + zip + "\nPerson Phone number: "
				+ phonNum + "\n\n";
	}	

	public boolean equals(ContactPerson person) {
		String name1 = getName();
		String name2 = person.firstName + person.lastName;
		if (name1.equals(name2)) {
			return true;
		}
		return false;
	}
}