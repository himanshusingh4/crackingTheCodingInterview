package main.java.recursion.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MagicIndex {

	public static void main(String args[]) {

		MagicIndex testObj = new MagicIndex();
		// System.out.println(testObj.getMagicIndex(new int[] { -40, -20, -10, 2, 4, 10,
		// 12 }));
		// System.out.println(testObj.getMagicIndexRecursive(new int[] { -40, -20, -10,
		// 2, 4, 10, 12 }, 0, 7));
		// testObj.minMaxElement(new int[] { 3, 2, 6, 8, 4, 5, 10, 11, 56, 43, 6, 1,
		// -41, 105 });
		// testObj.rotateArray(new int[] { 3, 2, 6, 8, 4, 5, 10, 11, 56, 43, 6, 1, -41,
		// 105 }, 1);
		// testObj.removeDuplicate(new int[] { 3, 2, 6, 3, 6, 10, -10, -10, 4, 3, 2, 12,
		// 12, 11, 10, 9, 8, 9, 7, 6 });
		// System.out
		// .println(testObj.smallestDifference(new int[] { 1, 3, 15, 11, 12 }, new int[]
		// { 23, 127, 235, 19, 8 }));
		// testObj.subSort(new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19});
		testObj.codility1();
		System.out.println(testObj.solution(3, new int[] {1,3}, new int[] {2,2}));
	}

	public boolean solution(int N, int[] A, int[] B) {

		HashMap<Integer, Integer> temp = new HashMap<>();
		temp.put(1, 1);
		temp.put(N, 1);

		for (int i = 2; i <= N - 1; i++) {

			temp.put(i, 2);
		}
		
		System.out.println(temp);

		int i = 0;

		while (i < A.length && i < B.length) {

			if (Math.abs(A[i] - B[i]) == 1) {

				temp.put(A[i], temp.get(A[i]) - 1);
				temp.put(B[i], temp.get(B[i]) - 1);
			}
			i++;
		}
		System.out.println(temp);

		for (int j = 1; i <= N ; j++) {

			System.out.println(temp.get(j));
			if(temp.get(j) != 0) {
				return false;
			}
		}
		
		return true;

	}

	public void codility1() {

		String s = "ccaaffddecee";

		int[] charCount = new int[26];

		for (int i = 0; i < s.length(); i++) {

			charCount[s.charAt(i) - 'a'] += 1;
		}

		List<Integer> temp = Arrays.stream(charCount).boxed().filter(c -> c != 0).sorted(Collections.reverseOrder())
				.collect(Collectors.toList());

		int deleteCount = 0;

		for (int i = 0; i < temp.size(); i++) {
			for (int j = i + 1; j < temp.size(); j++) {
				if (temp.get(i) > 0 && temp.get(i) == temp.get(j)) {
					int count = temp.get(j);
					temp.set(j, count - 1);
					deleteCount++;
				} else
					break;
			}
		}

		System.out.println(deleteCount);

	}

	public int getMagicIndex(int[] input) {

		int start = 0;
		int end = input.length;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (input[mid] == mid) {
				return mid;
			}

			if (input[mid] < mid) {
				start = mid + 1;
			}

			if (input[mid] > mid) {
				end = mid - 1;
			}

		}

		return -1;
	}

	public int getMagicIndexRecursive(int[] input, int start, int end) {

		if (end < start) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (input[mid] == mid) {

			return mid;
		} else if (input[mid] > mid) {

			end = mid - 1;
			return getMagicIndexRecursive(input, start, end);
		} else {

			start = mid + 1;
			return getMagicIndexRecursive(input, start, end);
		}

	}

	public void minMaxElement(int[] input) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++) {

			if (input[i] < min) {

				min = input[i];
			}

			if (input[i] > max) {

				max = input[i];
			}

		}

		System.out.println("Min = " + min);
		System.out.println("Max = " + max);

	}

	public void rotateArray(int[] a, int k) {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < k; i++) {

			list1.add(a[i]);
		}

		for (int i = k; i < a.length; i++) {

			list2.add(a[i]);
		}
		list2.addAll(list1);
		System.out.println(list2);

	}

	public void removeDuplicate(int[] a) {

		HashSet<Integer> temp = new HashSet<>();
		List<Integer> noDuplicateList = new ArrayList<>();

		for (int value : a) {

			if (!temp.contains(value)) {

				noDuplicateList.add(value);
				temp.add(value);

			}
		}

		System.out.println(noDuplicateList);
	}

	public int smallestDifference(int[] a, int[] b) {

		Arrays.sort(a);
		Arrays.sort(b);

		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;

		while (i < a.length && j < b.length) {

			int diff = Math.abs(a[i] - b[j]);

			if (diff < min) {

				min = diff;
			}

			if (a[i] > b[j]) {
				j++;
			} else {
				i++;
			}
		}

		return min;
	}

	public void subSort(int[] a) {

		System.out.println(Arrays.toString(a));
		int[] temp = Arrays.copyOf(a, a.length);

		int start = -1;
		int end = -1;

		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));

		for (int i = 0; i < temp.length; i++) {

			if (a[i] != temp[i]) {

				start = i;
				break;
			}
		}

		for (int i = temp.length - 1; i >= 0; i--) {

			if (a[i] != temp[i]) {

				end = i;
				System.out.println(end);
				break;
			}
		}

		System.out.println("Start = " + start);
		System.out.println("End = " + end);

	}

	public int contigousSequence(int[] a) {

		int maxSum = 0;
		int sum = 0;

		for (int i = 0; i < a.length; i++) {

			sum += a[i];

			if (maxSum < sum) {

				maxSum = sum;
			}

			if (sum < 0) {
				sum = 0;
			}

		}

		return maxSum;
	}
	
	 public int bulbs(ArrayList<Integer> A) {

	        int count = 0;

	        for(int i = 0; i < A.size(); i++) {

	            if(A.get(i) == 0 & count%2 == 0) {
	                count++;
	            }

	            if(A.get(i) == 1 & count%2 != 0) {
	                count++;
	            }   
	        }

	        return count;
	    }
	 
	 public int GreedyCodility(int K, int[] A) {
		 
		 int sum = 0;
		 int count = 0;
		 
		 	for(int i = 0; i < A.length; i++) {
		 		
		 		sum = sum + A[i];
		 		
		 		if(sum >= K) {
		 			count++;
		 			sum = 0;
		 		}
		 			
		 	}
		 	
		 	return count;
	        
	    }
}
