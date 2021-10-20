   package main.java.arrays.strings;

import java.util.Arrays;

public class Permutation {
	
	public static void main(String args[]) {

		Permutation testObj = new Permutation();
		System.out.println(testObj.isPermutationPossible("abcd a", "adcb a"));
		System.out.println(testObj.isPermutationPossibleASCII("abcd a", "adcb a"));
	}
	
	public boolean isPermutationPossible(String input1, String input2) {
		
		if(input1.length() != input2.length()) {
			
			return false;
		}
		
		char[] input1Array = input1.toCharArray();
		char[] input2Array = input2.toCharArray();
		
		return sort(input1Array).equals(sort(input2Array));
		
	}
	
	public String sort(char[] input) {
		
		Arrays.sort(input);
		return new String(input);
	}
	
	public boolean isPermutationPossibleASCII(String input1, String input2) {
		
		if(input1.length() != input2.length()) {
			
			return false;
		}
		
		int[] temp = new int[128];
		
		for(int i = 0; i < input1.length(); i++) {
			
			temp[input1.charAt(i)] += 1;
		}
		
		for(int i =0; i < input2.length(); i++) {
			
			temp[input2.charAt(i)] -= 1;
		}
		
		for(int i =0; i< 128 ; i++) {
			
			if(Math.abs(temp[i]) > 0) {
				
				return false;
			}
		}
		
		return true;
	}
	

}
