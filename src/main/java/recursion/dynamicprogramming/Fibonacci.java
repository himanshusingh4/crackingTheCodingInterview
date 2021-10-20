package main.java.recursion.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String args[]) {

		Fibonacci testObj = new Fibonacci();
		System.out.println(testObj.fibonacciNumber(9, new int[10]));
		System.out.println(testObj.fibonacciNumber(9));
		testObj.fibonacciSeries(9);
	}

	public int fibonacciNumber(int input, int[] mem) {

		if (input == 1) {
			return 0;
		}

		if (input == 2) {
			return 1;
		}

		if (mem[input] == 0) {
			mem[input] = fibonacciNumber(input - 1, mem) + fibonacciNumber(input - 2, mem);
		}
		
		return mem[input];
	}

	public int fibonacciNumber(int input) {

		int result = 0;

		if (input == 1) {
			return 0;
		}

		if (input == 2) {
			return 1;
		}

		result = fibonacciNumber(input - 1) + fibonacciNumber(input - 2);
		return result;
	}
	
	
	public void fibonacciSeries(int input) {
		
		int[] fibo = new int[input];
		
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i =2; i < input ; i++) {
			
			fibo[i] =  fibo[i-1] + fibo[i-2];
		}
		
		System.out.println(Arrays.toString(fibo));
		
	}

}
