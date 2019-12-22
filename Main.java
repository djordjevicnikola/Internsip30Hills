package internship;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to the 30Hills social network!\n");
		int theChoice = ChoosingAPerson.theChoice();
		System.out.println("\nThe person you were looking for: ");
		ReadingJson.jsonToString(theChoice);
		System.out.println("\n\nFriends: ");
		long[] arrayFriends = ReadingJson.friends(theChoice, theChoice);
		System.out.println("\n\nFriends of friends: ");
		HashMap<Long, Integer> hm = ReadingJson.friendsOfFriends(arrayFriends, theChoice);
		System.out.println("\n\nSuggested friends: ");
		ReadingJson.sugestedFriends(hm);
	}

}
