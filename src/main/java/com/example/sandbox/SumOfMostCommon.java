package com.example.sandbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SumOfMostCommon {

	public static void main(String[] args) {
		int[] input = { 5, 7, 9, 2, 3, 5, 0, 5, 3, 3, 3 };
		spaceOptimized(input);
		timeOptimized(input);
	}

	public static int spaceTimeOptimized(int... input) {
		for (int element : input) {

		}
		return 0;
	}

	/**
	 * Time Complexity: O(n^2) Space: only two variables are used
	 */
	public static int spaceOptimized(int... input) {
		int commonNumber = 0;
		int countOfCommonNumber = 0;
		for (int i = 0; i < input.length; i++) {
			int count = 1;
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] == input[j]) {
					count++;
				}
			}
			if (count > countOfCommonNumber) {
				commonNumber = input[i];
				countOfCommonNumber = count;
			}
		}
		int sum = commonNumber * countOfCommonNumber;
		System.out.println(
				"common Number: " + commonNumber + " countOfCommonNumber: " + countOfCommonNumber + " output: " + sum);
		return sum;
	}

	/**
	 * Time Complexity: O(n) + O(less then n) <-- this depends on how many
	 * numbers are repeating Space Complexity: O(2n) + O(less then n)
	 */
	public static int timeOptimized(int... input) {
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int element : input) {
			if (!set.add(element)) {
				Integer count = map.get(element);
				if (count == null) {
					count = 1;
				}
				count++;
				map.put(element, count);
			}
		}
		int commonNumber = 0;
		int countOfCommonNumber = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > countOfCommonNumber) {
				commonNumber = entry.getKey();
				countOfCommonNumber = entry.getValue();
			}
		}
		int sum = commonNumber * countOfCommonNumber;
		System.out.println(
				"common Number: " + commonNumber + " countOfCommonNumber: " + countOfCommonNumber + " output: " + sum);
		return sum;
	}

}
