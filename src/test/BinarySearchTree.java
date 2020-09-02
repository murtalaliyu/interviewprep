package test;

/**
 * BST: All left descendants <= n < all right descendants.
 * 		
 * 		No duplicate values.
 */
public class BinarySearchTree {

	public static BSTNode searchIter(BSTNode root, int target) {
		BSTNode ptr = root;
		
		while (ptr != null) {
			if (target == ptr.data) {
				return ptr;
			}
			if (target < ptr.data) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
		}
		return null;
	}
	
	public static BSTNode searchRecur(BSTNode root, int target) {
		if (root == null) {
			return null;
		}
		if (target == root.data) {
			return root;
		}
		if (target < root.data) {
			return searchRecur(root.left, target);
		}
		return searchRecur(root.right, target);
	}
	
	public static BSTNode insert(BSTNode root, int target) {
		BSTNode ptr = root;
		BSTNode prev = null;
		boolean left = false;
		
		while (ptr != null) {
			if (target == ptr.data) {
				throw new IllegalArgumentException();
			}
			
			prev = ptr;
			
			if (target < ptr.data) {
				ptr = ptr.left;
				left = true;
			} else {
				ptr = ptr.right;
				left = false;
			}
		}
		
		BSTNode temp = new BSTNode(target);
		
		if (root == null) {
			return temp;
		}
		
		if (left) {
			prev.left = temp;
		} else {
			prev.right = temp;
		}
		
		return root;
	}
	
	public static BSTNode delete(BSTNode root, int target) {
		BSTNode x = root;
		BSTNode p = null;
		
		// search
		while (x != null) {
			if (target == x.data) {
				break;
			}
			
			p = x;
			
			x = target < x.data ? x.left : x.right;
		}
		
		// no match found
		if (x == null) {
			throw new IllegalArgumentException();
		}
		
		// node with 2 children
		if (x.left != null && x.right != null) {
			BSTNode y = x.left;
			p = x;
			
			while (y.right != null) {
				p = y;
				y = y.right;
			}
			
			x.data = y.data;
			x = y;
		}
		
		// leaf and 1 child cases
		if (p == null) {
			return x.left != null ? x.left : x.right;
		}
		
		BSTNode tmp = x.left != null ? x.left : x.right;
		
		if (x == p.right) {
			p.right = tmp;
		} else {
			p.left = tmp;
		}
		
		return root;
	}
}
