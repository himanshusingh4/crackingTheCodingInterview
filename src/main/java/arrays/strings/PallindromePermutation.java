package main.java.arrays.strings;

public class PallindromePermutation {

	public static void main(String args[]) {

		PallindromePermutation testObj = new PallindromePermutation();
		System.out.println(testObj.isPallindromePermutation("tact coa"));
		System.out.println(testObj.isPallindromePermutation("fan naaf f"));
	}

	public boolean isPallindromePermutation(String input) {

		input = input.replaceAll(" ", "");
		int[] temp = new int[26];
		int count = 0;

		for (int i = 0; i < input.length(); i++) {

			temp[input.charAt(i) - 'a'] += 1;
		}

		for (int i = 0; i < temp.length; i++) {

			if (temp[i] % 2 == 1) {
				count++;
				if (count > 1) {
					return false;

				}
			}
		}

		return true;
	}

}
