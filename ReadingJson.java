package internship;

import java.io.*;
import java.util.HashMap;

import org.json.simple.*;
import org.json.simple.parser.*;

public class ReadingJson {

	public static int readingJson(String name) {
		JSONParser parser = new JSONParser();
		try {
			FileReader fr = new FileReader("ORG.json");
			JSONArray array = (JSONArray) parser.parse(fr);
			for (Object o : array) {
				JSONObject obj = (JSONObject) o;
				long id = (long) obj.get("id");
				String firstName = (String) obj.get("firstName");
				String firstNameLC = firstName.toLowerCase();
				String nameLC = name.toLowerCase();
				if (firstNameLC.equals(nameLC)) {
					return (int) id;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	};

	public static void jsonToString(long br) {
		JSONParser parser = new JSONParser();
		try {
			FileReader fr = new FileReader("ORG.json");
			JSONArray array = (JSONArray) parser.parse(fr);
			for (Object o : array) {
				JSONObject obj = (JSONObject) o;
				long id = (long) obj.get("id");
				if (id == br) {
					String firstName = (String) obj.get("firstName");
					String surname = (String) obj.get("surname");
					String gender = (String) obj.get("gender");
					System.out.print(
							"\nName: " + firstName + " " + surname + " Id: " + id + " Gender: " + gender + " Age: ");
					try {
						long age = (long) obj.get("age");
						System.out.print(age);
					} catch (Exception e) {
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	public static long[] friends(long num, long num1) {
		JSONParser parser = new JSONParser();
		try {
			FileReader fr = new FileReader("ORG.json");
			JSONArray array = (JSONArray) parser.parse(fr);
			for (Object o : array) {
				JSONObject obj = (JSONObject) o;
				long id = (long) obj.get("id");
				if (id == num) {
					JSONArray friends = (JSONArray) obj.get("friends");
					long[] arrayFriends = new long[friends.size()];
					for (int i = 0; i < friends.size(); i++) {
						long j = (long) friends.get(i);
						if (j != num1) {
							jsonToString(j);
							arrayFriends[i] = j;
						}
					}
					return arrayFriends;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};

	public static HashMap<Long, Integer> friendsOfFriends(long[] arrayFriends, long num) {
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		for (int i = 0; i < arrayFriends.length; i++) {
			long[] arrayFriends1 = friends(arrayFriends[i], num);
			for (int j = 0; j < arrayFriends1.length; j++) {
				if (hm.containsKey(arrayFriends1[j])) {
					hm.put(arrayFriends1[j], hm.get(arrayFriends1[j]) + 1);
				} else {
					hm.put(arrayFriends1[j], 1);
				}
			}
		}
		return hm;
	};

	public static void sugestedFriends(HashMap<Long, Integer> hm) {
		for (long l : hm.keySet()) {
			if (hm.get(l) >= 2) {
				jsonToString(l);
			}
		}

	};
}
