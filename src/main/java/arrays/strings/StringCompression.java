package main.java.arrays.strings;

public class StringCompression {

	public static void main(String args[]) {

		StringCompression testObj = new StringCompression();
		testObj.getCompressedString("Himaaanshhuu");
	}

	public void getCompressedString(String input) {
		
		StringBuilder sb = new StringBuilder();
		int count = 0;

		for (int i = 0; i < input.length(); i++) {
			count++;
			if ((i + 1) >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
				sb.append(input.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		System.out.println(sb);
	}
}
