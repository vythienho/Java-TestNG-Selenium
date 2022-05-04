package algorithm.interviews;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * __author__ = vyh@vmware.com
 */

/**
 Determine if any 3 integers in an array sum to 0. (MEDIUM)
 Find all triplets with zero sum
 Example: int[] arr = {1, 4, 8, 7, 2, -3, -5, -10, -1, -7};
 Sample solution: List<List<Integer>> solution = [[-10, 2, 8], [-7, -1, 8], [-5, -3, 8], [-5, 1, 4], [-3, -1, 4], [-3, 1, 2]]
 https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 */
public class SumToK {
	//O(n2), using Arrays.sort()
	public List<List<Integer>> sum(int[] arr, int k){
		List<List<Integer>> solution = new ArrayList<>();
		Arrays.sort(arr);
		int len = arr.length;
		for( int i = 0; i < len - 2; i++){
			int left = i + 1;
			int right = len - 1;
			while (left < right){
				if( arr[i] + arr[left] + arr[right] == k){
					//List<Integer> aGroup = new ArrayList<>();
					//aGroup.add(arr[i]);
					//aGroup.add(arr[left]);
					//aGroup.add(arr[right]);
					List<Integer> aGroup = new ArrayList<>(Arrays.asList(arr[i], arr[left], arr[right]));
					solution.add(aGroup);
					left++;
					right--;
				} else if (arr[i] + arr[left] + arr[right] > k){
					right--;
				}else {
					left++;
				}
			}
		}
		return solution;
	}

	public static void main(String[] args){
		int[] arr = {1, 4, 8, 7, 2, -3, -5, -10, -1, -7};
		int k = 0;
		SumToK sumToK = new SumToK();
		List<List<Integer>> result = sumToK.sum(arr, k);
		System.out.println(result);
	}
}
