package com.AddBook.java;

/**
 * 
 * @author Kapil
 *
 */
public class ContactPerson implements Comparable<ContactPerson>{
	
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
	/**
	 * getter method to get city, state and names and 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
	
	public Integer getZip() {
		return zip;
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
	
	public int compareTo(ContactPerson person) {
		if (getName().compareTo(person.getName()) > 0)
			return 1;
		else if (getName().compareTo(person.getName()) < 0)
			return -1;
		else
			return 0;		
	}
}