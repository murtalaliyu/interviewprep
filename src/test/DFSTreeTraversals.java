package test;

public class DFSTreeTraversals {

	public static void preorder(TreeNode n) {
		if (n == null) {
			return;
		}
		
		// print first, then check children
		System.out.println(n.value + " ");
		
		preorder(n.left);
		preorder(n.right);
	}
	
	public static void postorder(TreeNode n) {
		if (n == null) {
			return;
		}
		
		postorder(n.left);
		postorder(n.right);
		
		// check all children, then print
		System.out.println(n.value + " ");
	}
	
	public static void inorder(TreeNode n) {
		if (n == null) {
			return;
		}
		
		inorder(n.left);
		
		// check left children first, then print
		System.out.println(n.value + " ");
		
		inorder(n.right);
	}
}
