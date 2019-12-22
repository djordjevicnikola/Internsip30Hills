package internship;

import java.util.Scanner;

public class ChoosingAPerson {

	public static int theChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Press 1 if you want to search by ID number or 2 if you want to search by name: ");
		int theChoice, person = 0;
		theChoice = sc.nextInt();
		while (theChoice != 1 && theChoice != 2) {
			System.err.print("Wrong entry, enter 1 for search by id number or 2 for search by name: ");
			theChoice = sc.nextInt();
		}
		if (theChoice == 1) {
			person = choiceById();
		}
		if (theChoice == 2) {
			person = choiceByName();
			while (person == 0) {
				System.err.print("Incorrect entry or person does not exist, please try again. \n");
				person = choiceByName();
			}
		}
		return person;
	}

	private static int choiceByName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a person's name: ");
		String name = sc.next();
		int choice = ReadingJson.readingJson(name);
		return choice;
	}

	private static int choiceById() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter person ID: ");
		int choice = sc.nextInt();
		while (choice < 1 || choice > 20) {
			System.err.print("Incorrect entry, enter ID between 1 and 20: ");
			choice = sc.nextInt();
		}
		return choice;
	}
}
