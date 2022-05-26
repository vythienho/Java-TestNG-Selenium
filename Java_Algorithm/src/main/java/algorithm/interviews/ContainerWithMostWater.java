package algorithm.interviews;

import java.util.Arrays;
import java.util.List;

import java.lang.Math;

/**
 * __author__ = vyh@vmware.com
 *
 * https://www.geeksforgeeks.org/container-with-most-water/
 *
 */
public class ContainerWithMostWater {

	private int calculateVolume(int[] arr, int index1, int index2){
		int x = Math.abs(index1 - index2);
		int y = arr[index1] < arr[index2]? arr[index1]: arr[index2];
		return x * y;
	}

	public void findMaxVolume(int[] arr){
		int maxVolume = 0;
//		for (int i = 0; i < arr.length - 1; i++){
//			for( int j = i + 1; j < arr.length; j++){
//				int volume = calculateVolume(arr, i, j);
//				maxVolume = (volume > maxVolume)? volume: maxVolume;
//			}
//		}

		// can simplify into few lines
		for (int i = 0; i < arr.length - 1; i++){
			for( int j = i + 1; j < arr.length; j++){
				maxVolume = Math.max(maxVolume, Math.min(arr[i], arr[j]) * (j - i));
			}
		}


		System.out.println("\nArray: " + Arrays.toString(arr));
		System.out.println("Max volume: " + maxVolume);
	}

	public static void main(String[] args){
		ContainerWithMostWater container = new ContainerWithMostWater();

		int[] arr = {1, 5, 4, 3};       // 6
		container.findMaxVolume(arr);

		int b[] = { 3, 1, 2, 4, 5 };    // 12
		container.findMaxVolume(b);

		int c[] = {1, 3, 2, 1, 1, 1, 1, 1, 1, 1}; //9 = 1 * 9
		container.findMaxVolume(c);
	}

}
