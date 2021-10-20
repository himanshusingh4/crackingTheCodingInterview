package main.java.arrays.strings;

import java.util.Arrays;

public class ZeroMatrix {

	public static void main(String args[]) {

		ZeroMatrix testObj = new ZeroMatrix();
		int[][] input = { { 1, 2, 5, 4 }, { 5, 6, 7, 0 }, { 9, 1, 1, 1 }, { 1, 4, 5, 6 } };
		testObj.getZeroMatrix(input);
	}

	public void getZeroMatrix(int[][] input) {

		int row = 0;
		int column = 0;

		for (int i = 0; i < input.length; i++) {

			for (int j = 0; j < input[i].length; j++) {

				if (input[i][j] == 0) {

					row = i;
					column = j;
					break;
				}

			}

		}

		for (int i = 0; i < input.length; i++) {

			input[i][column] = 0;

		}

		for (int i = 0; i < input[0].length; i++) {

			input[row][i] = 0;
		}

		for (int i = 0; i < input.length; i++) {

			System.out.println(Arrays.toString(input[i]));

		}

	}

}
