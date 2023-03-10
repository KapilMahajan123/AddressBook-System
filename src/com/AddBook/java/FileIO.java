package com.AddBook.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.opencsv.CSVWriter;

/**
 * 
 * @author Kapil
 *
 */
public class FileIO {
	static String FILE_PATH = "C:\\Users\\mahaj\\Desktop\\229\\Day22-AddressBook\\src\\";

	static Scanner sc = new Scanner(System.in);

	static boolean read(File filePath) throws FileNotFoundException {
		for (File file : filePath.listFiles()) {
			System.out.println("AddressBook name: " + file.getName());
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
		return true;
	}

	static boolean writeTxtFile(ArrayList<Contact> addressBook, String addressBookName) throws IOException {
		File file = new File(FILE_PATH + "txt\\" + addressBookName + ".txt");
		boolean isCreated = file.createNewFile();
		if (!isCreated) {
			file.delete();
			file.createNewFile();
		}
		System.out.println("file created");
		FileWriter fileWriter = new FileWriter(file);
		String data = "";
		for (Contact contactPerson : addressBook) {
			data = data.concat(contactPerson.toString()).concat("\n");
		}
		System.out.println(data);
		fileWriter.write(data);
		fileWriter.close();
		return true;
	}

	public static boolean writeCsvFile(ArrayList<Contact> contacts, String addressBookName) throws IOException {
		File file = new File(FILE_PATH + "CSV\\" + addressBookName + ".csv");
		boolean isCreated = file.createNewFile();
		if (!isCreated) {
			file.delete();
			file.createNewFile();
		}
		System.out.println("file created");
		FileWriter fileWriter = new FileWriter(file);
		CSVWriter csvWriter = new CSVWriter(fileWriter);
		List<String[]> data = new ArrayList<>();
		for (Contact person : contacts) {
			String[] contactData = new String[] { person.getFirstName(), person.getLastName(), person.getAddress(),
					person.getCity(), person.getState(), String.valueOf(person.getZip()),
					String.valueOf(person.getPhoneNo()), person.getEmail() };
			data.add(contactData);
		}
		csvWriter.writeAll(data);

		fileWriter.close();
		return true;
	}

	public static void writeJsonFile(ArrayList<Contact> contacts, String addressBookName) throws IOException {
		File file = new File(FILE_PATH + "Json\\" + addressBookName + ".json");
		boolean isCreated = file.createNewFile();
		if (!isCreated) {
			file.delete();
			file.createNewFile();
		}
		System.out.println("file created");
		FileWriter writer = new FileWriter(file);
		JsonWriter json = new JsonWriter(writer);
		String data = "";
		for (Contact person : contacts) {
			data = data.concat((person.toString() + "\n"));
		}
		writer.write(data);
		writer.close();
	}
	
}
