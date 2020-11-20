package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bg_q {
	// Not functional
	public static String removeAdjDuplicates(String s) {
		String res = "";
		
		if (s.length() == 0) {
			return res;
		}
		
		int pointer = 0, start = -1, end = -1;
		char prev = '0';
		
		while (start < s.length()) {
			start = -1; end = -1; pointer = 0;
			prev = '0';
			
			while (end < s.length()) {
				if (pointer == s.length()) {
					return s;
				}
				if (s.charAt(pointer) == prev) {
					end++;
				} else {
					start++; end++;
				}
								
				if (start != end) {
					s = s.replace(s.substring(start, end+1), "");
					break;
				}

				prev = s.charAt(pointer);
				pointer++;
			}
			
			if (pointer+1 == s.length()) {
				break;
			}
		}
		
		return res;
	}

	// Me
	public static void reverseLinkedList() {
		// see linked list class
	}
	
	// Me
	public static boolean validAnagram(String s, String t) {
		
		if (s.length() != s.length()) {
			return false;
		}
		if (s.length() == 0 || t.length() == 0) {
			return false;
		}
		
		int[] sList = new int[s.length()];
		int[] tList = new int[t.length()];
		
		// get char codes for s
		for (int i = 0; i < s.length(); i++) {
			sList[i] = (int)s.charAt(i);
		}
		
		// get char codes for t
		for (int i = 0; i < t.length(); i++) {
			tList[i] = (int)t.charAt(i);
		}
		
		// sort both lists
		MergeSort.sort(sList, 0, sList.length-1);
		MergeSort.sort(tList, 0, tList.length-1);
		
		// compare for indifference
		for (int i = 0; i < sList.length; i++) {
			if (sList[i] != tList[i]) {
				return false;
			}
		}
		
		return true;
	}

	// Me
	public static int firstUniqChar(String s) {
		
		if (s.length() == 0 || s == null) {
			return -1;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			int count = 1;
			
			for (int j = 0; j < s.length(); j++) {
				if (i != j) {
					if (curr == s.charAt(j)) {
						count++;
					}
				}
			}
			
			if (count == 1) {
				return i;
			}
		}
		
		return -1;
	}

	// Me
	public static boolean isPalindrome(int x) {
		String s = "";
		s += x;
		
		// base case
		if (x < 0) {
			return false;
		}
		if (s.length() < 2) {
			return false;
		}
		
		int mid = 0;
		for (int i = 0; i < s.length(); i++) {
			mid = s.length() / 2;
			
			if (s.charAt(i) != s.charAt(s.length()-i-1)) {
				return false;
			}
			if (i == mid) {
				return true;
			}
		}
		
		return false;
	}

	// YT
	public static String addStrings(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		int i = num1.length()-1;
		int j = num2.length()-1;
		int carry = 0;
		
		while (i >= 0 && j >= 0) {
			int sum = carry;
			
			if (i >= 0) {
				sum += num1.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += num2.charAt(j--) - '0';
			}
			
			res.append(sum % 10);
			carry = sum / 10;
		}
		
		if (carry != 0) {
			res.append(carry);
		}
		
		return res.reverse().toString();
	}

	// Me
	public static void MinStack() {
		// see stack class
	}
	
	// Not functional
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		return null;
	}

	// G4G
	public static int minAddToMakeValid(String s) {
		// base case
		if (s.length() == 0 || s == null) {
			return 0;
		} 
		
		// maintain balance of string
		int bal = 0;
		int ans = 0;
		 
		for (int i = 0; i < s.length(); i++) {
			bal += s.charAt(i) == '(' ? 1 : -1;
			
			if (bal == -1) {
				ans += 1;
				bal += 1;
			}
		}
		
		return bal + ans;
	}

	// Not functional
	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		// base case
		if (s.length() == 0 || s == null) {
			return s;
		}
		
		// map each unique char to # times it appears
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else {
				map.replace(s.charAt(i), map.get(s.charAt(i)), map.get(s.charAt(i))+1);
			}
		}
		
		map.entrySet().stream()
        .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed());
		
		System.out.println(map);
		
		return null;
	}
	
	/**
	 * Incomplete: Not adding last word to temp
	 */
	static List<String> res = new ArrayList<>();
	static String temp = "";
	public static List<String> wordBreak(String s, List<String> wordDict) {
		// base case
		if (s.length() == 0 || wordDict.size() == 0 || wordDict == null) {
			return res;
		}
		
		for (int i = 1; i <= s.length(); i++) {
			// consider all prefixes of current string
			String prefix = s.substring(0, i);
			
			// if the prefix is present in the dict, add prefix to the output
			// string and recur for remaining string
			if (wordDict.contains(prefix)) {
				
				if (i != s.length()) {
					temp += prefix + " ";
					System.out.println("prefix: " + prefix);
				} else {
					res.add(temp);
					temp = "";
				}
				//System.out.println("next: " + s.substring(i));
				wordBreak(s.substring(i), wordDict);
			}
		}
		
		return res;
	}

	/**
	 * Incomplete
	 * LFU
	 * Hint: Use 2 hashmaps - 1 for K,V and 1 for K,C (where C = count)
	 */
	public static void LFU() {
		
	}

	/**
	 * Not Attempted
	 * Zuma Game
	 * 
	 */
	public static int findMinStep(String board, String hand) {
		// base case
		if (board.length() == 0 || hand.length() == 0) {
			return -1;
		}
		
		// create board hashmap with {color,#occurrences}
		HashMap<Character,Integer> boardMap = new HashMap<>();
		for (int i = 0; i < board.length(); i++) {
			char currentKey = board.charAt(i);
			
			if (!boardMap.containsKey(currentKey)) {
				boardMap.put(currentKey, 1);
			} else {
				int oldValue = boardMap.get(currentKey);
				boardMap.replace(currentKey, oldValue, oldValue+1);
			}
		}
		
		// create hand hashmap with {color,#occurrences}
		HashMap<Character,Integer> handMap = new HashMap<>();
		for (int i = 0; i < hand.length(); i++) {
			char currentKey = hand.charAt(i);
			
			if (!handMap.containsKey(currentKey)) {
				handMap.put(currentKey, 1);
			} else {
				int oldValue = handMap.get(currentKey);
				handMap.replace(currentKey, oldValue, oldValue+1);
			}
		}
		
		// temp vars
		int count = 0;
		HashMap resultMap = new HashMap<>();
		
		for (Map.Entry<Character, Integer> b : boardMap.entrySet()) {
			char boardColor = b.getKey();
			int boardColorOccurs = b.getValue();
			
			for (Map.Entry<Character, Integer> h : handMap.entrySet()) {
				char handColor = h.getKey();
				int handColorOccurs = h.getValue();
				
				// do comparisons
				if (boardColor == handColor) {
					
				}
			}
		}
		
	}

}
