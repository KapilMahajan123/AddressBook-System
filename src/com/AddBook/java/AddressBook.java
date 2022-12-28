package com.AddBook.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Kapil
 *
 */
public class AddressBook {
	/*
	 * creating instance object
	 */
	private Scanner scanner = new Scanner(System.in);
	private String fname, lname, mail, address, city, state;
	private int zip, i;
	private long phone;
	private ArrayList<ContactPerson> persons = new ArrayList<>();
	private int count;
	private boolean checkEquality;
	
	//Method input first and last name
	private void inputNames() {
		System.out.println("Enter first name: ");
		fname = scanner.next();
		System.out.println("Enter last name: ");
		lname = scanner.next();
	}
	//method to get input contacts 
	private void inputContacts() {
		System.out.println("Enter email: ");
		mail = scanner.next();
		scanner.nextLine();
		System.out.println("Enter address: ");
		address = scanner.nextLine();
		System.out.println("Enter city: ");
		city = scanner.next();
		scanner.nextLine();
		System.out.println("Enter state: ");
		state = scanner.nextLine();
		System.out.println("Enter postal(zip) code: ");
		zip = scanner.nextInt();
		System.out.println("Enter phone number: ");
		phone = scanner.nextLong();
	}
	
	/*
	 * method of add person
	 */
	void addPerson() {
		System.out.println("Enter Person " + (count + 1) + " Details:");
		inputNames();
		inputContacts();
		ContactPerson person = new ContactPerson(fname, lname, mail, address, city, state, zip, phone);
		
		List<ContactPerson> duplicate = persons.stream()
				.filter(prsn -> prsn.equals(person))
				.collect(Collectors.toList());
		
        if (duplicate.toString().equals("[]")) {
    		count++;
        	persons.add(person);
        }
        else
        	System.out.println("Duplicate Name: Can't add person details!");

	}
	private boolean areNamesEqual() {
		for (i = 0; i < persons.size(); i++)
			if (persons.get(i).getName().equals(fname + lname)) {
				System.out.println("Match found at position " + i);
				return true;
			}
		return false;
	}

	void updatePerson() {
		inputNames();
		checkEquality = areNamesEqual();
		if (checkEquality) {
			inputContacts();
			persons.set(i, new ContactPerson(fname, lname, mail, address, city, state, zip, phone));
			System.out.println("Person " + (i + 1) + " Contact updated successfully!");
		}
		else
			System.out.println("No match available!");
	}
	/*
	 * Ability to delete a person using person name
	 */
	void deletePerson() {
		inputNames();
		checkEquality = areNamesEqual();
		if (checkEquality) {
			count--;
			persons.remove(i);
			System.out.println("Person " + (i + 1) + " Contact removed successfully!");
		}
		else
			System.out.println("No match available!");
	}

	public String toString() {
		String personsData = "";
		for (i = 0; i < count; i++) {
			personsData += "Person " + (i + 1) + " Details:\n";
			personsData += persons.get(i);
		}
		return personsData;
	}
	void viewAddrBook(String... stateCity) {
		String state = stateCity[0];

		Predicate<ContactPerson> predicatePerson;
		
		System.out.println("\n-------------------------------------------------------");
		
		try {
			System.out.println("State Name: " + stateCity[0]);
			System.out.println("City Name: " + stateCity[1]);
			String city = stateCity[1];
			
			predicatePerson = person -> person.getState().equals(state) && person.getCity().equals(city);
			
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			predicatePerson = person -> person.getState().equals(state);
			
		}

		persons.stream().filter(predicatePerson)
				.forEach(prsn -> System.out.print("\n" + prsn + "\n"));
	}
	
}