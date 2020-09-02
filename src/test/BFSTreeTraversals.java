package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Only has level-order traversal
 */
public class BFSTreeTraversals<T,S> {

	public HashMap<Integer, ArrayList<Node<T,S>>> levelorderTraversalUsingDFSPreorderTraversal(Node<T,S> root, HashMap<Integer, ArrayList<Node<T,S>>> data, int depth) {
		if (root == null) {
			return null;
		}
		
		if (!data.containsKey(depth)) {
			data.put(depth, new ArrayList<Node<T,S>>());
		}
		
		data.get(depth).add(root);
		
		levelorderTraversalUsingDFSPreorderTraversal(root.left, data, depth+1);
		levelorderTraversalUsingDFSPreorderTraversal(root.right, data, depth+1);
		
		return data;
	}
	
	public void levelorder() {
		
	}
	
	public void print(HashMap<Integer,ArrayList<Node<Integer,String>>> data, String type) {
		Set<Integer> keys = data.keySet();
		for (Integer i : keys) {
			ArrayList<Node<Integer,String>> depthList = data.get(i);
			for (int j = 0; j < depthList.size(); j++) {
				if (type == "int") {
					System.out.print(depthList.get(j).val + " ");
				} else if (type == "str") {
					System.out.print(depthList.get(j).name + " ");
				}
			}
			System.out.println();
		}
	}
}

class Node<T,S> {
	T val;
	S name;
	Node<T,S> left;
	Node<T,S> right;
	
	Node(T val, S name) {
		this.val = val;
		this.name = name;
		this.left = null;
		this.right = null;
	}
}