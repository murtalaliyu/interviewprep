package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class msft {

	// Largest K such that both K and -K exist in array
	// O(n^2)
	public static int largestK(int[] A) {
		int largest = 0;
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] > largest && A[i] > 0) {
				for (int j = 0; j < A.length; j++) {
					if (i != j) {
						if (A[i] + A[j] == 0) {
							largest = A[i];
						}
					}
				}
			}
		}
		return largest;
	}
	
	// Count Visible Nodes in Binary Tree
	
	// Unique Integers That Sum Up To 0
	public int[] sumZero(int n) {
        int[] res = new int[n];
        int count = 0, index = 0;
        
        if (n % 2 != 0) {
            res[0] = 0;
            count = 1;
            index = 1;
        } 
        while (count <= n/2) {
            res[index] = count;
            index++;
            res[index] = -count;
            count++;
            index++;
        }
        
        return res;
    }
	
	// ------------------------------------------------------ Section 1: Arrays --------------------------------------------------------------------
	// Arrays 1
	// Sum of Two Values (1st solution: O(n) (note: my solution is different from original solution))
	public static boolean sumA(int[] A, int val) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// scan A, add to hashmap
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], 0);
		}
		
		// scan map, check if (v-k) exists & k != (v-k)
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			int key = val-e.getKey();
			if (map.containsKey(key) && e.getKey() != key) {
				return true;
			}
		}
		
		return false;
	}
	
	// Arrays 2
	// Make Columns and Rows Zero (1st solution: O(n*m) (note: my solution is different from original solution))
	public static void makeZero(int[][] matrix) {
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		
		// first pass. store zero cells
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		// second pass. if rows contains 0 || cols contains 0, matrix[row][col] = 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rows.contains(i) || cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	// ------------------------------------------------------ Section 2: LinkedLists ----------------------------------------------------------------
	// LinkedLists 1
	// Add Two Integers O(n)
	public static LinkedListNode addTwoInts(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode res = null;
		LinkedListNode last = null;
		
		int carry = 0;
		while (head1 != null || head2 != null || carry > 0) {
			int first = head1 == null ? 0 : head1.data;
			int second = head2 == null ? 0 : head2.data;
			
			int sum = first + second + carry;
			
			LinkedListNode curr = new LinkedListNode(sum % 10);
			
			carry = sum / 10;
			
			// not sure
			if (res == null) {
				res = curr;
			} else {
				last.next = curr;
			}
			
			last = curr;
			
			// increment head1 & head2
			if (head1 != null) head1 = head1.next;
			if (head2 != null) head2 = head2.next;
		}
		
		return res;
	}

	// LinkedList 2
	// Copy linked list with arbitrary pointer
	// ???

	// ------------------------------------------------------ Section 3: Trees ----------------------------------------------------------------
	// Trees 1
	// Level Order Traversal of Binary Tree (O(n) (note: my solution returns a hashmap of <depth,list<BSTnode>> instead of string)
	static HashMap<Integer,ArrayList<BSTNode>> binaryTreeMap = new HashMap<Integer,ArrayList<BSTNode>>();
	public static HashMap<Integer,ArrayList<BSTNode>> levelOrderTraversal(BSTNode root, int depth) {
		// base case
		if (root == null) {
			return binaryTreeMap;
		}
		
		// add new depth if it does not exist
		if (!binaryTreeMap.containsKey(depth)) {
			binaryTreeMap.put(depth, new ArrayList<BSTNode>());
		}

		// add node to depth
		binaryTreeMap.get(depth).add(root);
		
		// check children
		levelOrderTraversal(root.left, depth+1);
		levelOrderTraversal(root.right, depth+1);
		
		return binaryTreeMap;
	}
	
	// Convert from HashMap to String
	public static String level_order_traversal(BSTNode root) {
		String res = "";
		HashMap<Integer,ArrayList<BSTNode>> map = levelOrderTraversal(root, 0);
	
		for (Map.Entry<Integer,ArrayList<BSTNode>> e : map.entrySet()) {
			ArrayList<BSTNode> list = e.getValue();
			for (int i = 0; i < list.size(); i++) {
				res += list.get(i).data + ",";
			}
		}
		return res;
	}

	// Trees 2
	// Connect all siblings
	// ???

	// ------------------------------------------------------ Section 4: Strings ----------------------------------------------------------------
	// Strings 1
	// Reverse Words in a Sentence
	// ???
	
	// Strings 2
	// Find all Palindrome Substrings
	
	
	
}
