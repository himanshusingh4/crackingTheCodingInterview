package main.java.arrays.strings;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayTest {
	
	public static void main(String args[]) {

		ArrayTest testObj = new ArrayTest();
		
		List<Integer> input = IntStream.of(1,4,5,7,3,4,6,2).boxed().collect(Collectors.toList());
		
		testObj.sumEqual(input, 10);
		testObj.sumHashSet(input, 10);
	}
	
	
	public void sumEqual(List<Integer> input , int value) {
		
		
		Collections.sort(input);
		int start = 0;
		int end = input.size()-1;
		boolean result = false;
		
		while(start < end) {
			
			int sum = input.get(start) + input.get(end);
			
			if(sum == value) {
				result = true;
				break;
			}
			
			if(sum < value) {
				start++;
			}
			
			if(sum > value) {
				end--;
			}
			
		}
		
		System.out.println(result);
		
	}
	
	public void sumHashSet(List<Integer> input , int value) {
		
		Set<Integer> temp = new HashSet<>();
		
		for(int i : input) {
			
			if(temp.contains(value - i)) {
				
				System.out.println(i + "," + (value-i));
			} else {
				temp.add(i);
			}
		}
	}
	
	

}
