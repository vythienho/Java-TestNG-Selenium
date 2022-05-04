package algorithm.interviews;

// Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice.
// You can return the answer in any order.

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

// Input: nums = [3,2,4], target = 6
// Output: [1,2]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * __author__ = vyh@vmware.com
 */
public class AddUpToTarget {
	public List<Integer> findSolution(int[] arr, int target){
		int length = arr.length;
		List<Integer> li = new ArrayList<>();
		for( int i = 0; i < length - 1; i++){
			for( int j = i + 1; j < length; j++){
				if( arr[i] + arr[j] == target){
					li.add(i);
					li.add(j);
				}
			}
		}
		return li;
	}

	public static void main(String[] args){
		AddUpToTarget obj = new AddUpToTarget();

		int[] arr = new int[] {2,7,11,15};
		int target = 9;
		System.out.println("\nArray: " + Arrays.toString(arr) + ": target=" + target);
		System.out.println("Solution: " + obj.findSolution(arr, target));
		//System.out.println(obj.findSolution(new int[]{2,7,11,15}, 9));

		int[] arr2 = new int[] {3, 2, 4};
		int target2 = 6;
		//System.out.println(obj.findSolution(new int[]{3,2,4}, 6));
		System.out.println("\nArray: " + Arrays.toString(arr2) + ": target=" + target2);
		System.out.println("Solution: " + obj.findSolution(arr2, target2));
	}
}
