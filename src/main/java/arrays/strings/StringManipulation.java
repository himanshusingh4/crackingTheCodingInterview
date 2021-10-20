package main.java.arrays.strings;

public class StringManipulation {

	public static void main(String args[]) {

		StringManipulation testObj = new StringManipulation();
		System.out.println(testObj.isManipulate("acbcd", "abcdd"));
	}

	public boolean isManipulate(String input1, String input2) {

		boolean result = true;

		if (Math.abs(input1.length() - input2.length()) >= 2) {
			result = false;
			return result;
		}

		int[] temp1 = new int[26];
		int count = 0;

		for (int i = 0; i < input1.length(); i++) {

			temp1[input1.charAt(i) - 'a'] += 1;
		}

		for (int i = 0; i < input2.length(); i++) {

			temp1[input2.charAt(i) - 'a'] -= 1;
		}

		if (input1.length() == input2.length()) {

			for (int i = 0; i < 26; i++) {
				if (Math.abs(temp1[i]) > 1) {
					result = false;
				} else if (Math.abs(temp1[i]) == 1) {

					count++;
					if (count > 2) {
						result = false;
					}
				}

			}
		} else {

			for (int i = 0; i < 26; i++) {
				if (Math.abs(temp1[i]) > 1) {
					result = false;
				} else if (Math.abs(temp1[i]) == 1) {

					count++;
					if (count > 1) {
						result = false;
					}
				}

			}

		}
		return result;

	}
}
