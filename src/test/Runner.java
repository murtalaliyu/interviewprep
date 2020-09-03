package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.LinkedList;

public class Runner {
	public static void main(String[] args) throws IOException {
		//RunLinkedList();
		//RunStack();
		//RunDStack();
		//RunQueue();
		//RunHashMap();
		//RunGraph();
		//RunBinarySearch();
		//RunHeap();
		//RunQuickSort();
		//RunBinarySearchTree();
		//RunDFSTreeTraversals();
		//RunBFSTreeTraversals();
		RunMergeSort();
	}
	
	public static void RunDStack() {
		DStack nums = new DStack();
		System.out.println("Size: " + nums.size());
		nums.push(15);
		nums.push(34);
		System.out.println("Size: " + nums.size());
		nums.push(65);
		nums.push(12);
		nums.push(79);
		nums.push(120);
		nums.push(143);
		System.out.println("Size: " + nums.size());
		nums.show();
		nums.push(48);
		System.out.println("Pop: " + nums.pop());
		nums.push(66);
		System.out.println("Size: " + nums.size());
		nums.show();
		System.out.println("Pop: " + nums.pop());
		System.out.println("Pop: " + nums.pop());
		System.out.println("Pop: " + nums.pop());
		System.out.println("Pop: " + nums.pop());
		System.out.println("Pop: " + nums.pop());
		System.out.println("Pop: " + nums.pop());
		System.out.println("Pop: " + nums.pop());
		nums.show();
	}
	
	public static void RunStack() {
		Stack nums = new Stack();
		
		System.out.println("Empty: " + nums.isEmpty());
		
		nums.show();
		nums.push(15);
		nums.push(8);
		
		System.out.println("peak: " + nums.peek());
		
		nums.push(10);
		nums.push(7);
		nums.push(17);
		nums.push(50);
		
		System.out.println("size is: " + nums.size());
		
		nums.show();
		
		//System.out.println("Pop: " + nums.pop());
		nums.show();
		
		System.out.println("size is: " + nums.size());
		
		System.out.println("Empty: " + nums.isEmpty());
	}
	
	public static void RunLinkedList() {

		test.LinkedList list = new test.LinkedList();
		System.out.println("Size: " + list.size());
		list.insert(18);
		System.out.println("Size: " + list.size());
		list.insert(45);
		list.insert(12);
		
		list.insertAtStart(25);
		System.out.println("Size: " + list.size());
		
		list.insertAt(4, 55);
		
		list.show(); 
		System.out.println();
		
		list.deleteAt(2);
		list.deleteAt(2);
		
		list.show();
		System.out.println("Size: " + list.size());
	}

	public static void RunQueue() {
		Queue q = new Queue();
		System.out.println(q.isEmpty());
		q.deQeueu();
		q.enQueue(5);
		q.enQueue(2);
		q.enQueue(7);
		q.enQueue(3);
		
		q.show();
		
		//System.out.println("dequeue: " + q.deQeueu());
		q.show();  

		q.enQueue(57);
		q.enQueue(36);
		q.enQueue(63);
		q.enQueue(29);q.enQueue(36);
		q.enQueue(63);
		q.enQueue(29);q.enQueue(36);
		q.enQueue(63);
		q.enQueue(29);
		System.out.println("dequeue: " + q.deQeueu());
		System.out.println("dequeue: " + q.deQeueu());
		System.out.println("dequeue: " + q.deQeueu());
		System.out.println("dequeue: " + q.deQeueu());
		System.out.println("dequeue: " + q.deQeueu());
		System.out.println("dequeue: " + q.deQeueu());
		System.out.println("dequeue: " + q.deQeueu());
		System.out.println("dequeue: " + q.deQeueu());
		System.out.println("dequeue: " + q.deQeueu());
		
		System.out.println("Size: " + q.size());
		q.show();
	}

	public static void RunHashMap() {
		Map<Integer, String> map1 = new HashMap<>();
		Map<String, String> map2 = new Hashtable<>();
		Map<String, String> map3 = new TreeMap<>();
		Map<String, String> map4 = new LinkedHashMap<>();
		
		map1.put(1, "Navin");
		map1.put(2, "Ken");
		map1.put(3, "Emma");
		map1.put(4,  "John");
		
		//get value from key
		System.out.println("key 2 has value:" + map1.get(2));
		
		//get entire map 1
		Set<Integer> keys = map1.keySet();
		for (Integer i : keys) {
			System.out.println(i + ": " + map1.get(i));
		}
		
		System.out.println();
		
		//get entire map 2
		Set<Map.Entry<Integer, String>> map11 = map1.entrySet();
		for (Map.Entry<Integer, String> e : map11) {
			e.setValue(e.getValue() + "_" + e.getKey());
			
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}

	public static void RunGraph() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter graph input file name: ");
		String file = sc.nextLine();
		Graph graph = new Graph("C:/Users/murta/eclipse-workspace-java/test/" + file);
		
		//graph.print();
		
		System.out.print("BFS Graph traversal: ");
		graph.bfs();
		
		System.out.println("\n\nDFS Graph traversal: ");
		graph.dfs();
	}

	public static void RunBinarySearch() {
		int[] arr = new int[] {11,12,17,19,26,38,45};
		System.out.println(BinarySearch.binarySearch(arr, 46));
	}

	public static void RunHeap() {
		Heap<Integer> heap = new Heap<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter next int, 'done' to stop: ");
		String line = sc.next();
		
		while (!line.equals("done")) {
			heap.insert(Integer.parseInt(line));
			System.out.println(heap);
			System.out.println("Enter next int, 'done' to stop: ");
			line = sc.next();
		}
		
		while (!heap.isEmpty()) {
			int max = heap.delete();
			System.out.println(max + " " + heap);
		}
	}

	public static void RunQuickSort() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter list of integers, comma separated: ");
		String liststr = sc.next();
		String[] items = liststr.split(",");
		Integer[] list = new Integer[items.length];
		
		for (int i=0; i <list.length; i++) {
			list[i] = Integer.parseInt(items[i]);
		}
		
		System.out.print("Before: ");
		QuickSort.print(list);
		QuickSort.sort(list);
		System.out.print("After: ");
		QuickSort.print(list);
	}

	public static void RunBinarySearchTree() {
		BSTNode root = new BSTNode(5);
		
		BinarySearchTree.insert(root, 4);
		BinarySearchTree.insert(root, 6);
		System.out.println(root.left.data + ", " + root.right.data);
		BinarySearchTree.delete(root, 5);
		System.out.println(root.left + ", " + root.right.data);
	}

	public static void RunDFSTreeTraversals() {
		TreeNode a = new TreeNode("a");
		TreeNode b = new TreeNode("b");
		TreeNode c = new TreeNode("c");
		TreeNode d = new TreeNode("d");
		TreeNode e = new TreeNode("e");
		TreeNode f = new TreeNode("f");
		TreeNode g = new TreeNode("g");
		
		a.left = b;
		a.right = g;
		b.left = c;
		b.right = d;
		c.left = e;
		e.right = f;
		
		System.out.println("Preorder:");
		DFSTreeTraversals.preorder(a);
		
		System.out.println("\nPostorder:");
		DFSTreeTraversals.postorder(a);

		System.out.println("\nInorder:");
		DFSTreeTraversals.inorder(a);
	}

	public static void RunBFSTreeTraversals() {
		Node<Integer, String> a4 = new Node(4, "Four");
		Node<Integer, String> b7 = new Node(7, "Seven");
		Node<Integer, String> c9 = new Node(9, "Nine");
		Node<Integer, String> d10 = new Node(10, "Ten");
		Node<Integer, String> e2 = new Node(2, "Two");
		Node<Integer, String> f6 = new Node(6, "Six");
		Node<Integer, String> g6 = new Node(3, "Three");
		Node<Integer, String> h2 = new Node(5, "Five");
		
		a4.left = b7;
		a4.right = c9;
		b7.left = d10;
		b7.right = e2;
		c9.right = f6;
		e2.right = g6;
		g6.left = h2;
		
		HashMap<Integer, ArrayList<Node<Integer,String>>> data = new HashMap<Integer, ArrayList<Node<Integer,String>>>();
		
		BFSTreeTraversals<Integer, String> trav = new BFSTreeTraversals<Integer, String>();
		data = trav.levelorderUsingDFSPreorder(a4, data, 0);
		
		System.out.println("data values using DFS preorder: ");
		trav.print(data, "int");
		System.out.println("\n\ndata names using DFS preorder: ");
		trav.print(data, "str");
		
		System.out.println("\n\n---------------------------------------------------\n\n");
		
		List<List<Node<Integer,String>>> result = new ArrayList<>();
		result = trav.levelorderUsingQueue(a4);
		
		System.out.println("data values using Queue: ");
		trav.print(result, "int");
	}

	public static void RunMergeSort() {
		
	}
}
