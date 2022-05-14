package algorithm.interviews;


/**
 * __author__ = vyh@vmware.com
 *
 * https://www.geeksforgeeks.org/program-to-add-two-binary-strings/
 */
public class AddBinaryStrings {

	public String addBinary(String a, String b){
		if (a.length() == 0) return b;
		if (b.length() == 0) return a;

		int i = a.length() - 1;
		int j = b.length() - 1;
		int s = 0;
		StringBuilder result = new StringBuilder("");

		while (i >= 0 || j >= 0 || s == 1){
			//System.out.println("a.charAt(i) = " + a.charAt(i) + ", b.charAt(j) = " + b.charAt(j));
			s += (i >= 0)? a.charAt(i) - '0': 0;
			s += (j >= 0)? b.charAt(j) - '0': 0;

			// if result is 1 or 3, add '1'
			//              0 or 2, add '0'
			result.append((char)(s % 2 + '0'));

			// compute carry over
			System.out.print("s = " + s + ", ");
			s /= 2;
			System.out.println("carry = " + s);

			i--;
			j--;
		}

		return result.reverse().toString();
	}

	public static void main(String[] args){
		addBinaryStrings ab = new addBinaryStrings();
		//expect "110"
		System.out.println(ab.addBinary("11", "1"));

		//expect "10011"
		System.out.println(ab.addBinary("1010", "1001"));
	}
}