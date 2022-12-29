package com.AddBook.java;

import java.util.ArrayList;
import java.util.HashMap;
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
	private ArrayList<ContactPerson> persons;
	private int count;
	private boolean checkEquality;
	private HashMap<ContactPerson, String> personsState, personsCity;

	public AddressBook() {

		persons = new ArrayList<>();
		personsState = new HashMap<>();
		personsCity = new HashMap<>();
	}

	private void inputNames() {
		System.out.println("Enter first name: ");
		fname = scanner.next();
		System.out.println("Enter last name: ");
		lname = scanner.next();
	}

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

	void addPerson() {
		System.out.println("Enter Person " + (count + 1) + " Details:");
		inputNames();
		inputContacts();
		ContactPerson person = new ContactPerson(fname, lname, mail, address, city, state, zip, phone);

		List<ContactPerson> duplicate = persons.stream().filter(prsn -> prsn.equals(person))
				.collect(Collectors.toList());

		if (duplicate.toString().equals("[]")) {
			count++;
			persons.add(person);
			personsState.put(person, state);
			personsCity.put(person, city);
		} else
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
			personsState.remove(state);
			personsCity.remove(city);

			inputContacts();
			ContactPerson person = new ContactPerson(fname, lname, mail, address, city, state, zip, phone);
			persons.set(i, person);

			personsState.put(person, state);
			personsState.put(person, city);
			System.out.println("Person " + (i + 1) + " Contact updated successfully!");
		} else
			System.out.println("No match available!");
	}

	void deletePerson() {
		inputNames();
		checkEquality = areNamesEqual();
		if (checkEquality) {
			count--;
			ContactPerson removedPerson = persons.remove(i);
			personsState.remove(removedPerson);
			personsCity.remove(removedPerson);

			System.out.println("Person " + (i + 1) + " Contact removed successfully!");
		} else
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

		persons.stream().filter(predicatePerson).forEach(prsn -> System.out.print("\n" + prsn + "\n"));
	}

	void viewPersons(String... stateCity) {
		String state = stateCity[0];

		System.out.println("\n-------------------------------------------------------");
		
		try {
			System.out.println("State Name: " + stateCity[0]);
			System.out.println("City Name: " + stateCity[1]);
			String city = stateCity[1];

			personsCity.keySet().stream().filter(prsn -> city.equals(personsCity.get(prsn)))
			.forEach(prsn -> System.out.print("\n" + prsn + "\n"));			

		} catch (ArrayIndexOutOfBoundsException aioobe) {
			
			personsState.keySet().stream().filter(prsn -> state.equals(personsState.get(prsn)))
					.forEach(prsn -> System.out.print("\n" + prsn + "\n"));
			
		}
	}
	
	long getCountByState(String state) {
		return personsState.values().stream()
				.filter(prsnState -> prsnState.equals(state)).count();
	}
	
	long getCountByCity(String city) {
		return personsCity.values().stream()
				.filter(prsnCity -> prsnCity.equals(city)).count();
	}


}