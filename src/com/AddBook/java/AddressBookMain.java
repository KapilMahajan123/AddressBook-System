package com.AddBook.java;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Kapil
 *
 */
public class AddressBookMain {

	public static void main(String[] args) {
		String addrBookName = "", stateName, cityName;
		System.out.println("Welcome to Address Book Program!");
		Scanner scanner = new Scanner(System.in);
		AddressBook addrBook;
		HashMap<String, AddressBook> addrBooks = new HashMap<String, AddressBook>();

		char superChoice = ' ', choice, viewChoice;

		while (true) {

			if (superChoice == 'x')
				break;

			System.out.println("Enter '1' to add new Address Book!");
			System.out.println("Enter '2' to view existing Address Book");
			System.out.println("Enter 'x' to Exit Program!");
			System.out.println("Enter your choice:");
			superChoice = scanner.next().charAt(0);

			switch (superChoice) {
			case '1':
				scanner.nextLine();
				System.out.print("Enter New Address Book Name: ");
				addrBookName = scanner.nextLine();
				addrBooks.put(addrBookName, new AddressBook());
				choice = ' ';

				while (true) {

					if (choice == 'x')
						break;

					System.out.println("Press '1' to add new Contact!");
					System.out.println("Press '2' to edit existing Contact!");
					System.out.println("Press '3' to view Contacts in list!");
					System.out.println("Press '4' to delete Contact!");
					System.out.println("Press 'x' to exit current Address Book!");
					System.out.print("Enter your choice: ");
					choice = scanner.next().charAt(0);

					addrBook = addrBooks.get(addrBookName);
					System.out.println();
					switch (choice) {
					case '1':
						addrBook.addPerson();
						break;
					case '2':
						addrBook.updatePerson();
						break;
					case '3':
						System.out.println("\n-------------------------------------------------------");
						System.out.println("Name of Address Book: " + addrBookName + "\n");
						System.out.print(addrBook);
						System.out.println("-------------------------------------------------------");
						break;
					case '4':
						addrBook.deletePerson();
						break;
					case 'x':
						System.out.println("Exiting Current Address Book!\n");
						continue;
					default:
						System.out.println("Invalid Input: Please choose correct option!");
					}
					System.out.println();

				}
				break;
			case '2':
				scanner.nextLine();
				System.out.println("Enter Name of Address Book to view:");
				addrBookName = scanner.nextLine();
				addrBook = addrBooks.get(addrBookName);

				System.out.println("Enter '1' to view by State Names!");
				System.out.println("Enter '2' to view by City Names!");
				System.out.println("Enter your choice: ");
				viewChoice = scanner.next().charAt(0);

				System.out.println("\n-------------------------------------------------------");
				System.out.println("Name of Address Book: " + addrBookName + "\n");
				switch (viewChoice) {
				case '1':
					scanner.nextLine();
					System.out.println("Enter State Name: ");
					stateName = scanner.nextLine();
					addrBook.viewAddrBook(stateName);
					break;
				case '2':
					scanner.nextLine();
					System.out.println("Enter State Name: ");
					stateName = scanner.nextLine();

					System.out.println("Enter City Name: ");
					cityName = scanner.next();
					
					addrBook.viewAddrBook(stateName, cityName);
					break;
				default:
					System.out.println("Invalid: View Choice!");
				}

				System.out.println("-------------------------------------------------------");
				break;
			case 'x':
				System.out.println("Exiting Program!");
				continue;
			default:
				System.out.println("Invalid: Please enter correct choice!");
			}
		}

		scanner.close();
	}
}