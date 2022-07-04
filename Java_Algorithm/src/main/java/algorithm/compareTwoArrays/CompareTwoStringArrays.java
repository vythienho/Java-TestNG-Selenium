package algorithm.compareTwoArrays;

import java.util.stream.IntStream;
import java.util.Arrays;

/**
 * __author__ = vyh@vmware.com
 */
public class CompareTwoStringArrays {

	//v1
	public static boolean checkEquality(String[] s1, String[] s2)
	{
		if (s1 == s2) {
			System.out.println("\ns1 == s2, test case of String[] s2 = s1;");
			return true;
		}

		if (s1 == null || s2 == null) {
			return false;
		}

		int n = s1.length;
		if (n != s2.length) {
			return false;
		}

		System.out.println("\n s1, s2 are two separate arrays");
		for (int i = 0; i < n; i++)
		{
			if (!s1[i].equals(s2[i])) {
				return false;
			}
		}

		return true;
	}

	// v2, using Stream api
	public static boolean checkEquality_stream(String[] s1, String[] s2)
	{
		if (s1 == s2) {
			return true;
		}

		if (s1 == null || s2 == null || s1.length != s2.length) {
			return false;
		}

		return IntStream.range(0, s1.length).allMatch(i -> s1[i].equals(s2[i]));
	}

	public static void main(String[] args)
	{
		String[] s1 = { "A", "B", "C" };
		String[] s2 = { "A", "B", "C" };

		System.out.println("Arrays.equals(): " + Arrays.equals(s1, s2));

		String[] s3 = s1;
		System.out.println("Arrays.equals(): " + Arrays.equals(s1, s3));
		String[] s4 = s2;
		System.out.println("Arrays.equals(): " + Arrays.equals(s1, s4));
		// deepEquals() for multi dimentional arrays
		System.out.println("deepEquals(): " + Arrays.deepEquals(s3, s4));

		if (checkEquality(s1, s3)) {
			System.out.println("s1 vs s3: Both arrays are equal");
		}
		else {
			System.out.println("Both arrays are not equal");
		}

		if (checkEquality(s1, s2)) {
			System.out.println("Both arrays are equal");
		}
		else {
			System.out.println("Both arrays are not equal");
		}

		if (checkEquality_stream(s1, s2)){
			System.out.println("\ncheckEquality_stream: equal");
		} else {
			System.out.println("\ncheckEquality_stream: not equal");
		}
	}
}
