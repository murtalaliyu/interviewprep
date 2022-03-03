package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Generic Node<T,S> with 2 generic fields (val,name), 2 Node<T,S> fields (left,right)
 * @author murta
 *
 * @param <T>
 * @param <S>
 */
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

/*
 * Using a queue:
 * if root is null, return
 * Init queue
 * push root to queue
 * While queue is not empty:
 * 	pop queue
 * 	print value
 * 	add left & right children if not null
 */
public static void BFS(Node root) {
	// edge case 1: empty root
	if (root == null) return;

	Queue<Node> q = new LinkedList<>();
	q.add(root);

	while (!q.isEmpty()) {
		Node n = q.poll();
		System.out.println(n.val);
		if (n.left != null) {
			q.add(n.left);
		}
		if (n.right != null) {
			q.add(n.right);
		}
	}
}

/**
 * Only has level-order traversal: Using a hashmap
 */
public class BFSTreeTraversals<T,S> {

	/**
	 * Returns a HashMap: {
	 * 						Keys: 	Integer
	 * 						Values: List[Node<T,S>]
	 * 					  }
	 * 
	 * Uses DFS pre-order to traverse this binary tree.
	 * 
	 * @param root
	 * @param data
	 * @param depth
	 * @return
	 */
	public HashMap<Integer, ArrayList<Node<T,S>>> levelorderUsingDFSPreorder(Node<T,S> root, HashMap<Integer, ArrayList<Node<T,S>>> data, int depth) {
		if (root == null) {
			return null;
		}
		
		if (!data.containsKey(depth)) {
			data.put(depth, new ArrayList<Node<T,S>>());
		}
		
		data.get(depth).add(root);
		
		levelorderUsingDFSPreorder(root.left, data, depth+1);
		levelorderUsingDFSPreorder(root.right, data, depth+1);
		
		return data;
	}
	
	/**
	 * NOT FUNCTIONAL 
	 * 
	 * Returns a List: [
	 * 					 List: [Node<T,S>] ...
	 * 				   ]
	 * 
	 * Uses level-order to traverse this binary tree.
	 * @param root
	 * @return
	 */
	public List<List<Node<T,S>>> levelorderUsingQueue(Node<T,S> root) {
		List<List<Node<T,S>>> result = new ArrayList<>();
		
		if (root == null) {
			return null;
		}
		
		Queue<Node<T,S>> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			List<Node<T,S>> currentLevel = new ArrayList<>();
			
			for (int i = 0; i < queue.size(); i++) {
				Node<T,S> current = queue.remove();
				currentLevel.add(current);
				
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
			
			result.add(currentLevel);
		}
		
		return result;
	}
	
	public void print(List<List<Node<T,S>>> data, String type) {
		for (int i = 0; i < data.size(); i++) {
			List<Node<T,S>> currList = data.get(i);
			
			for (int j = 0; j < currList.size(); j++) {
				Node<T,S> currNode = currList.get(j);
				
				if (type == "int") {
					System.out.print(currNode.val + " ");
				} else if (type == "str") {
					System.out.print(currNode.name + " ");
				}
			}
			
			System.out.println();
		}
	}
	
	public void print(HashMap<Integer,ArrayList<Node<T,S>>> data, String type) {
		Set<Integer> keys = data.keySet();
		
		for (Integer i : keys) {
			ArrayList<Node<T,S>> depthList = data.get(i);
			
			for (int j = 0; j < depthList.size(); j++) {
				Node<T,S> currNode = depthList.get(j);
				
				if (type == "int") {
					System.out.print(currNode.val + " ");
				} else if (type == "str") {
					System.out.print(currNode.name + " ");
				}
			}
			
			System.out.println();
		}
	}
}
