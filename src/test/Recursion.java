package test;

public class Recursion {
	
	public static void sayHi(int n) {
		if (n == 0) {
			System.out.println("Done");
		} else {
			System.out.println("hi");
			sayHi(n-1);
		}
	}
	
	public static void countBackwards(int n) {
		if (n == 0) {
			System.out.println("Done");
		} else {
			System.out.println(n);
			countBackwards(n-1);
		}
	}
	
	public static void countdown(int i) {
		// print i
		System.out.println("i: " + i);

		// base case
		if (i <= 1) {
			return;
		} else {
			// recursive case
			countdown(i-1);
		}
	}
	
	public static int fact(int x) {
		// base cases
		if (x < 1) {
			return 0;
		} else if (x == 1) {
			return 1;
		} else {
			// recursive case
			return x * fact(x-1);
		}
	}
	
	/**
	 * Functional
	 */
	static int count = 0, max = -1;
	public static int higherNodes(BSTNode root) {
		// base case
		if (root == null) {
			return count;
		}
		
		// increment count if the current node is greater than the maximum value of its anc
		if (root.data > max) {
			count++;
		}
		
		// update max
		max = Math.max(max, root.data);
		
		// check children
		higherNodes(root.left);
		higherNodes(root.right);
		
		return count;
	}
	
	/**
	 * Don't forget to convert to lower case
	 * Functional
	 */
	public static boolean isPalindrome(String s) {
		// base case
		if (s.length() < 2) {
			return true;
		}
		
		// compare first and last
		if (s.charAt(0) != s.charAt(s.length()-1)) {
			return false;
		}
		
		// recursive case
		isPalindrome(s.substring(1, s.length()-1));
		
		return true;
	}
	
	/**
	 * Works when x >= 0
	 * Functional
	 */
	public static int recursivePowers(int x, int n) {
		// base case
		if (n == 0) {
			return 1;
		}
		
		// recursive case
		return x * recursivePowers(x, n-1);
	}
}
