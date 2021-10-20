package main.java.recursion.dynamicprogramming;

public class TripleStep {

	public static void main(String args[]) {

		TripleStep testObj = new TripleStep();
		System.out.println(testObj.countWays(9));
		System.out.println(testObj.countWays((9), new int[11]));
		
	}

	public int countWays(int n) {

		if (n < 0) {
			return 0;
		}
      
		if (n == 0) {
			return 1;
		}

		return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);

	}

	public int countWays(int n, int[] mem) {

		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}
		

		if (mem[n] == 0) {
			mem[n] = countWays(n - 1, mem) + countWays(n - 2, mem) + countWays(n - 3, mem);
		}

		return mem[n];

	}

}
