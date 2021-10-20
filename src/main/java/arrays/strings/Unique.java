package main.java.arrays.strings;

import java.util.HashMap;
import java.util.Map;

public class Unique {

	public static void main(String args[]) {

		Unique testObj = new Unique();
		testObj.isUniqueUsingMap("Abcd k sjf@3");
		testObj.isUniqueASCII("Abcd ksjf@3");
		testObj.isUniqueUsingArray("Aabcd"); // only for Lowercase a-z
	}

	public void isUniqueUsingMap(String input) {

		// String inputModified = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
		// System.out.println(inputModified);
		Map<Character, Integer> temp = new HashMap<>();
		boolean isUnique = true;

		for (int i = 0; i < input.length(); i++) {

			if (temp.containsKey(input.charAt(i))) {

				temp.put(input.charAt(i), temp.get(input.charAt(i)) + 1);

			} else {
				temp.put(input.charAt(i), 1);
			}

		}

		for (Map.Entry<Character, Integer> entry : temp.entrySet()) {

			if (entry.getValue() > 1) {
				isUnique = false;
				break;
			}
		}

		if (isUnique) {
			System.out.println("String is Unique");
		} else {
			System.out.println("String is not Unique");
		}

	}

	public void isUniqueUsingArray(String input) {

		int[] temp = new int[26];
		boolean result = false;

		String modified = input.toLowerCase();

		for (int i = 0; i < modified.length(); i++) {
			temp[modified.charAt(i) - 'a'] += 1;
		}

		for (int i : temp) {

			if (i > 1) {
				result = true;
			}
		}

		if (result) {
			System.out.println("Not unique");
		} else {
			System.out.println("Unique");
		}

	}

	public void isUniqueASCII(String input) {

		int[] temp = new int[128];
		boolean result = false;

		String modified = input.toLowerCase();

		for (int i = 0; i < modified.length(); i++) {
			temp[modified.charAt(i)] += 1;
		}

		for (int i : temp) {

			if (i > 1) {
				result = true;
			}
		}

		if (result) {
			System.out.println("Not unique");
		} else {
			System.out.println("Unique");
		}

	}

}
