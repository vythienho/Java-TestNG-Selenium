package algorithm.interviews;

/**
 * __author__ = vyh@vmware.com
 */

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 Determine if any 3 integers in an array sum to 0. (MEDIUM)
 Find all triplets with zero sum
 Example: int[] arr = {1, 4, 8, 7, 2, -3, -5, -10, -1, -7};
 Sample solution: List<List<Integer>> solution = [[-10, 2, 8], [-7, -1, 8], [-5, -3, 8], [-5, 1, 4], [-3, -1, 4], [-3, 1, 2]]
 https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 */

public class SumToK_set {
	public List<List<Integer>> solution(int[] arr){
		List<List<Integer>> solution = new ArrayList<>();

		for( int i = 0; i < arr.length - 2; i++){
			Set<Integer> s = new HashSet<>();
			for(int j = i + 1; j < arr.length - 1; j++){
				int x = -(arr[i] + arr[j]);
				if( s.contains(x)){
					solution.add(Arrays.asList(arr[i], arr[j], x));
				} else {
					s.add(arr[j]);
				}
			}

		}

		return solution;
	}

	public static void main(String[] args){
		int[] arr = {1, 4, 8, 7, 2, -3, -5, -10, -1, -7};

		SumToK_set sumToK = new SumToK_set();
		System.out.println(sumToK.solution(arr));
	}
}
