package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
//import java.util.LinkedList;

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
		//RunMergeSort();
		//RunAmazonQ();
		//RunBloombergQ();
		RunLinkedListQ();
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
		
		list.print(); 
		System.out.println();
		
		list.deleteAt(2);
		list.deleteAt(2);
		
		list.print();
		System.out.println("Size: " + list.size());
		//list.reverse(list.head);
		//list.show();
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
		int[] array = {5,6,4,3,2,7,8,17,5,9,0,1,4,-4};
		//int[] array = {9,8,7,6,5,4,3,2,1,0};
				
		System.out.print("Given array: ");
		MergeSort.printArray(array);
		
		System.out.print("Sorted array: ");
		MergeSort.sort(array, 0, array.length-1);
		MergeSort.printArray(array);
	}
	
	/* --------------------------------------------------------------------------------------- */
	
	public static void RunAmazonQ() {
		// Amazon Fresh Promotion
		/*
		List<List<String>> codeList = new ArrayList();
		
		List<String> cL1 = new ArrayList();
		cL1.add("a");
		cL1.add("b");
		cL1.add("c");
		List<String> cL2 = new ArrayList();
		cL1.add("d");
		cL1.add("e");
		cL1.add("f");
		List<String> cL3 = new ArrayList();
		cL1.add("g");
		cL1.add("h");
		cL1.add("i");
		
		codeList.add(cL1);
		codeList.add(cL2);
		codeList.add(cL3);
		
		
		List<String> shoppingCart = new ArrayList();
		shoppingCart.add("a");
		shoppingCart.add("b");
		shoppingCart.add("c");
		
		System.out.println(q1.amazon_fresh_promotion(codeList, shoppingCart));
		*/
		
		// Amazon Mushic Pairs
		/*
		int[] songs = {60, 60, 60};
		System.out.println(amazon_q.getSongPairCount(songs.length, songs));
		*/
		
		// Items in Containers
		/*
		String s = "*|*|*|*";
		int[] startIndices = {0};
		int[] endIndices = {7};
		
		List<Integer> res = amazon_q.numberOfItems(s, startIndices, endIndices);
		
		for (int i : res) {
			System.out.print(i + ", ");
		}
		*/
		
		// Turnstile
		/*
		//int[] result = amazon_q.getTimes(4, new int[] { 0, 0, 1, 5 }, new int[] { 0, 1, 1, 0 });
		int[] result = amazon_q.getTimes(5, new int[] { 0, 1, 1, 3, 3 }, new int[] { 0, 1, 0, 0, 1 });
		System.out.println(Arrays.toString(result));
		*/
		
		// Utilization Checks
		/*
		List<Integer> averageUtil = new ArrayList<>();
		averageUtil.add(25);averageUtil.add(23);averageUtil.add(1);averageUtil.add(2);averageUtil.add(3);averageUtil.add(4);
		averageUtil.add(5);averageUtil.add(6);averageUtil.add(7);averageUtil.add(8);averageUtil.add(9);averageUtil.add(10);
		averageUtil.add(76);averageUtil.add(80);
		System.out.println(amazon_q.utilizationChecks(2, averageUtil));
		*/
		
		// Top K Frequently Mentioned Keywords
		/*
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("zetacellular Anacell provides the best services in the city");
		reviews.add("zetacellular has awesome services");
		reviews.add("Best services provided by anacell, everyone should use anacell");
		
		ArrayList<String> keywords = new ArrayList<String>();
		keywords.add("anacell"); keywords.add("cetracular"); keywords.add("zetacellular");
		
		System.out.println(amazon_q.topKFreq(reviews, keywords, 3));
		*/
		
		// Transaction Logs
		/*
		String[] logData = {"345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77", "345366 38239 23", "029323 345366 13", "38239 38239 23"};
		int threshold = 3;
		
		int[] res = amazon_q.transactionLogs(logData, threshold);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		*/
		
		// Substrings of Size K with K-1 Distinct Chars
		/*
		System.out.println(amazon_q.substringsSizeKDistinctChars("wawaglknagagwunagkwkwagl", 4));
		*/
		
		// Number of Islands
		/*
		char[][] grid1 = new char[][] { { '1', '1', '0', '0', '0' }, 
            { '0', '1', '0', '0', '1' }, 
            { '1', '0', '0', '1', '1' }, 
            { '0', '0', '0', '0', '0' }, 
            { '1', '0', '1', '0', '1' } };
            
		char[][] grid2 = new char[][] {
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}
		};
		
		char[][] grid3 = new char[][] {
			{'1','0','1','0','1'},
			{'0','0','0','0','0'},
			{'1','0','0','0','0'},
			{'0','0','1','0','1'}
		};
            
        System.out.println(amazon_q.numIslands(grid3, 4, 5));
        */
		
		// Most Common Word
		/*
		System.out.println(amazon_q.mostCommonWord("the Bob hit the a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
		*/
		
		// K Closest
		/*
		int[][] points = new int[][] {{3,3}, {5,-1}, {-2,4}};
		int[][] res = amazon_q.kClosest(points, 2);
		
		for (int i = 0; i < res.length; i++) {
			int[] point = res[i];
			System.out.println("[" + point[0] + "," + point[1] + "]");
		}
		*/
		
		// Robotics Challenge
		/*
		ArrayList<String> l = new ArrayList<>();
		
		//test 1
		//l.add("5"); l.add("-2"); l.add("4"); l.add("Z"); l.add("X"); l.add("9"); l.add("+"); l.add("+");
		
		//test 2
		l.add("1"); l.add("2"); l.add("+"); l.add("Z");
		
		System.out.println(amazon_q.roboticsChallenge(4, l));
		*/
		
		// Friend Circles
		/*
		// test 1
		//int[][] M = new int[][] {{1,1,0}, {1,1,0}, {0,0,1}};
		
		// test 2
		//int[][] M = new int[][] {{1,1,0}, {1,1,1}, {0,1,1}};
		
		// test 3
		int[][] M = new int[][] {{1,0,0}, {0,1,0}, {0,0,1}};
		
		System.out.println(amazon_q.findCircleNum(M));
		*/
		
		
	}

	/* --------------------------------------------------------------------------------------- */
	
	public static void RunBloombergQ() {
		// Remove Adjacent Duplicates
		/*
		System.out.println("res: " + bg_q.removeAdjDuplicates("geeksforgeeg"));
		*/
		
		// Valid anagram
		/*
		System.out.println(bg_q.validAnagram("art!@", "@t!ar"));
		System.out.println((int)' ');
		*/
		
		// First Unique Char
		/*
		System.out.println(bg_q.firstUniqChar("abcdefag"));
		*/
		
		// Palindrome Number
		/*
		System.out.println(bg_q.isPalindrome(123454321));
		*/
		
		// Add Strings
		/*
		System.out.println(bg_q.addStrings("123", "123"));
		*/
		
		// Minimum Add to Make Parentheses Valid
		/*
		System.out.println(bg_q.minAddToMakeValid("()))(("));
		*/
		
		// Sort Characters By Frequency
		//System.out.println(bg_q.frequencySort("Aabb"));
		
		// Word Break
		
		List<String> wordDict = new ArrayList<>();
		/*
		//wordDict.add("cat"); wordDict.add("cats"); wordDict.add("and"); wordDict.add("sand"); wordDict.add("dog"); 
		//wordDict.add("apple"); wordDict.add("pen"); wordDict.add("applepen"); wordDict.add("pine"); wordDict.add("pineapple"); 
		wordDict.add("bloom"); wordDict.add("bloomberg"); wordDict.add("is"); wordDict.add("fun"); 
		List<String> res = bg_q.wordBreak("bloombergisfun", wordDict);
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		*/
		
		// Zuma Game
		//bg_q.findMinStep("WRRBBW", "RB");
	}

	/* --------------------------------------------------------------------------------------- */
	
	public static void RunLinkedListQ() {
		LinkedList ll = new LinkedList();
		ll.head = new LinkedListNode(1);
		
		// populate linked list
		for (int i = 2; i <= 3; i++) {
			ll.insert(i);
		}
		
		// create a loop
		//ll.head.next.next.next = ll.head.next.next;
		
		// print linked list
		//System.out.print("List: ");
		//ll.print();
		
		// print middle
		//System.out.println("Middle: " + linked_list_q.getMiddle(ll.head).data);
		
		// detect loop
		System.out.println(linked_list_q.detectLoop(ll.head, true));
		System.out.println("loop length: " + linked_list_q.loopLength);
		System.out.println("node at removal: " + linked_list_q.nodeAtRemoval);
	}
}
