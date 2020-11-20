package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class amazon_q {
	// LC
	public static int isWinner(List<List<String>> codeList, List<String> shoppingCart){
        //check zero length...
        if(codeList == null || codeList.size() == 0) {
        	return 1;
        }
        if(shoppingCart == null || shoppingCart.size() == 0) {
        	return 0;
        }
            
        int i = 0, j = 0;
        
        for(int k = 0; k < shoppingCart.size(); k++) {
            //when match success
            if (codeList.get(i).get(j).equals(shoppingCart.get(k)) || codeList.get(i).get(j).equals("anything")) {
                j++;
                if (j == codeList.get(i).size()) {
                    i++;
                    j = 0;
                }
                if (i == codeList.size()) {
                	return 1;
                } 
            //when match failed, k and j both go back.
            } else {
                k -= j;
                j = 0;
            }
        }
        return 0;
    }
	
	// Me
	public static List<String> substringsSizeKDistinctChars(String s, int k) {
		List<String> res = new ArrayList<String>();
		
		for (int start = 0; start < s.length(); start++) {
			int end = start+k;
			
			if (end <= s.length()) {
				String substring = s.substring(start, end);
				//System.out.println(substring);
				int count = 0;
				
				for (int j = 0; j < substring.length(); j++) {
					for (k = 0; k < substring.length(); k++) {
						if (j != k) {
							if (substring.charAt(j) == substring.charAt(k)) {
								count++;
							}
						}
					}
				}
				
				//System.out.println(count);
				count = (count % 2 == 0 ? count/2 : (count/2)+1);
				if (count == 1) {
					res.add(substring);
				}
			}
		}
		
		return res;
	}
	
	// Me
	public static int getSongPairCount(int n, int[] songs) {
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if ((songs[i] + songs[j]) % 60 == 0) {
						count++;
					}
				}
			}
		}
		
		if (count % 2 == 0) {
			count /= 2;
		} else {
			count /=2 + 1;
		}
		
		return count;
	}

	// Me
	public static List<Integer> numberOfItems(String s, int[] startIndices, int[] endIndices) {
		List<Integer> res = new ArrayList<>(); 
		
		if (startIndices.length != endIndices.length) {
			return res;
		}
		
		for (int i = 0; i < startIndices.length; i++) {
			int start = startIndices[i];
			int end = endIndices[i];
			
			boolean addStart = false;
			boolean addEnd = false;
			
			int count = 0;
			for (int j = start; j < end; j++) {
				if (s.charAt(j) == '|') {
					addStart = true;
				}
				if (s.charAt(j) == '*' && addStart) {
					count++;
				}
			}
			
			res.add(count);
		}
		
		return res;
	}
	
	// LC
	public static int[] turnstile(int numCustomers, int[] arrTime, int[] direction) {

		int[] result = new int[numCustomers];

		Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();

		ArrayDeque<int[]> entryQ = new ArrayDeque<int[]>();
		ArrayDeque<int[]> exitQ = new ArrayDeque<int[]>();

		int i = 0;

		int turnstileDirection = -1; // default unused-1

		for (int a : arrTime) {

			if (!map.containsKey(a)) {
				map.put(a, new ArrayList<int[]>());
			}

			map.get(a).add(new int[] { i, direction[i] });

			i++;
		}

		i = 0; // used to determine timeStamp, 
		while (numCustomers > 0) {

			if (map.containsKey(i)) {
				List<int[]> customers = map.get(i);

				for (int[] customer : customers) {
					if (customer[1] == 1) {
						exitQ.add(customer);
					} else {
						entryQ.add(customer);
					}
				}
			}

			if (entryQ.isEmpty() && exitQ.isEmpty()) {
				turnstileDirection = -1;
				i++;
				continue;
			}

			int[] current;
			if (!entryQ.isEmpty() && !exitQ.isEmpty()) {

				switch (turnstileDirection) {
				case -1: // unused
					current = exitQ.poll();
					result[current[0]] = i;
					numCustomers--;
					turnstileDirection = 1;
					i++;
					break;

				case 1: // used for exit
					current = exitQ.poll();
					result[current[0]] = i;
					numCustomers--;
					turnstileDirection = 1;
					i++;
					break;

				case 0: // used to entry
					current = entryQ.poll();
					result[current[0]] = i;
					numCustomers--;
					turnstileDirection = 0;
					i++;
					break;

				}
				continue;
			}

			if (!entryQ.isEmpty()) {
				current = entryQ.poll();
				result[current[0]] = i;
				numCustomers--;
				turnstileDirection = 0;
				i++;
				continue;
			}

			if (!exitQ.isEmpty()) {
				current = exitQ.poll();
				result[current[0]] = i;
				numCustomers--;
				turnstileDirection = 1;
				i++;
				continue;
			}
		}

		return result;
	}

	// Me
	public static int utilizationChecks(int instances, List<Integer> averageUtil) {
		int limit = 2 * 100000000;
		
	    for (int i = 0; i < averageUtil.size(); i++) {
	        int util = averageUtil.get(i);
	        if (util < 25) {
	            if (instances > 1) {
	                instances = instances / 2 + ((instances % 2 == 0) ? 0 : 1);
	                i += 10;
	            }
	        } else if (util > 60) {
	            int newInstances = 2 * instances;
	            if (newInstances <= limit) {
	                instances = newInstances;
	                i += 10;
	            }
	        }
	    }
	    return instances;
	}

	// Me
	public static List<String> topKFreq(List<String> reviews, List<String> keywords, int k) {
		List<String> res = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < reviews.size(); i++) {
			reviews.set(i, reviews.get(i).toLowerCase());
		}
		
		for (int i = 0; i < keywords.size(); i++) {
			keywords.set(i, keywords.get(i).toLowerCase());
		}
		
		for (int i = 0; i < keywords.size(); i++) {
			String keyword = keywords.get(i);
			int counter = 0;
			
			for (int j = 0; j < reviews.size(); j++) {
				String review = reviews.get(j);
				//System.out.println("keyword: " + keyword + ", review: " + reviews.get(j));
				if (review.contains(keyword)) {
					counter++;
				}
			}
			
			if (counter > 0) {
				map.put(keyword, counter);
			}
		}
		
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			res.add(e.getKey());
		}
		
		return res;
	}

	// Me
	public static int[] transactionLogs(String[] logData, int threshold) {
		ArrayList<Integer> tempRes = new ArrayList<>();
		HashMap<Integer, Integer> userNums = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < logData.length; i++) {
			String[] log = logData[i].split(" ");
			int user1 = Integer.parseInt(log[0]);
			int user2 = Integer.parseInt(log[1]);
			int numTrans = Integer.parseInt(log[2]);
			
			if (!userNums.containsKey(user1)) {
				userNums.put(user1, 1);
			} else {
				userNums.replace(user1, userNums.get(user1), userNums.get(user1)+1);
			}
			
			if (!userNums.containsKey(user2) && (user1 != user2)) {
				userNums.put(user2, 1);
			} else {
				userNums.replace(user2, userNums.get(user2), userNums.get(user2)+1);
			}
		}

		for (Map.Entry<Integer, Integer> e : userNums.entrySet()) {
			if (e.getValue() >= threshold) {
				tempRes.add(e.getKey());
			}
		}
		
		int[] res = new int[tempRes.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = tempRes.get(i);
		}
		
		return res;
	}

	// G4G
	public static int numIslands(char[][] grid, int ROW, int COL) {
		// make a boolean array to mark visited cells.
		// initially all cells are unvisited.
		boolean visited[][] = new boolean[ROW][COL];
		
		// initialize count as 0 and traverse through all the cells of the matrix.
		int count = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				// if a cell with value '1' is not yes visited, then new island is found.
				// visit all cells in this island and increment island count.
				if (grid[i][j] == '1' && !visited[i][j]) {
					DFS(grid, i, j, ROW, COL, visited);
					count++;
				}
			}
		}
		
		return count;
	}
	// utility function to do DFS for a 2D boolean matrix. it only considers the 8 neighbors as adjacent vertices.
	private static void DFS(char grid[][], int row, int col, int ROW, int COL, boolean visited[][]) {
		// these arrays are used to get row and column numbers of 8 neighbors of a given cell.
		int rowNum[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
		int colNum[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
		
		// mark this cell as visited
		visited[row][col] = true;
		
		// recur for all connected neighbors
		for (int i = 0; i < 8; i++) {
			if (isSafe(grid, row+rowNum[i], col+colNum[i], ROW, COL, visited)) {
				DFS(grid, row+rowNum[i], col+colNum[i], ROW, COL, visited);
			}
		}
	}
	// utility function to check if a given cell (row, col) can be included in DFS.
	private static boolean isSafe(char[][] grid, int row, int col, int ROW, int COL, boolean[][] visited) {
		// row number is in range, col number is in range and value is 1 and not yet visited.
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (grid[row][col] == '1' && !visited[row][col]);
	}
	
	// Me
	public static String mostCommonWord(String paragraph, String[] banned) {
		String res = "";
		// remove punctuation, convert to lower-case, split by space
		String[] paragraphArr = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
		
		int high = 0;
		
		for (int i = 0; i < paragraphArr.length; i++) {
			int sum = 0;
			
			for (int j = 0; j < paragraphArr.length; j++) {
				if (i != j) {
					if (paragraphArr[i].equals(paragraphArr[j]) && !isBannedWord(paragraphArr[j], banned)) {
						sum++;
					}
				}
			}
			
			if (sum > high) {
				high = sum;
				res = paragraphArr[i];
			}
		}
		
		return res;
	}
	// helper function to check if word is banned
	private static boolean isBannedWord(String word, String[] banned) {
		for (int i = 0; i < banned.length; i++) {
			if (word.equals(banned[i])) {
				return true;
			}
		}
		
		return false;
	}

	// Me
	public static int[][] kClosest(int[][] points, int k) {
		int[][] res = new int[k][2];
		int[] distances = new int[points.length];
		
		for (int i = 0; i < points.length; i++) {
			int[] point = points[i];
			distances[i] = (point[0]*point[0]) + (point[1]*point[1]);
		}
		
		Arrays.sort(distances);
		
		int kthDistance = distances[k-1];
		int j = 0;
		for (int[] point : points) {
			int distance = (point[0]*point[0]) + (point[1]*point[1]);
			
			if (distance <= kthDistance) {
				res[j] = point;
				j++;
			}
		}
		
		return res;
	}

	// Me
	/**
	 * 
	 * Assume blocks contains only Integers, X, +, Z as inputs.
	 */
	public static int roboticsChallenge(int num, ArrayList<String> blocks) {
		// base case
		if (blocks == null || blocks.size() == 0) {
			return 0;
		}
		
		// keep track of scores using a stack
		Stack<Integer> scores = new Stack<Integer>();
		
		// iterate through blocks
		for (int i = 0; i < blocks.size(); i++) {
			
			// 1. if "X", double last score
			if (blocks.get(i) == "X" && scores.size() != 0) {
				int doubledLastScore = scores.peek()*2;
				scores.push(doubledLastScore);
			} 
			// 2. if "+", sum last two scores
			else if (blocks.get(i) == "+" && scores.size() > 1) {
				int first = scores.pop();
				int second = scores.pop();
				int sumOfLastTwoScores = first + second;
				scores.push(second);
				scores.push(first);
				scores.push(sumOfLastTwoScores);
			}
			// 3. if "Z", remove last score
			else if (blocks.get(i) == "Z" && scores.size() > 0) {
				scores.pop();
			}
			// 4. if Integer
			else {
				int currentNum = Integer.parseInt(blocks.get(i));
				scores.push(currentNum);
			}
		}
		
		// iterate through scores and add them up
		int finalScore = 0;
		for (int i : scores) {
			finalScore += i;
		}
		
		return finalScore;
	}

	// Me
	/**
	 * Strategy: assume that each person is isolated (x = M.length).
	 * 			 for each M[i][i+1] that is 1, subtract from x.
	 */
	public static int findCircleNum(int[][] M) {
		// base cases
		if (M.length == 0 || M == null) {
			return 0;
		}
		if (M.length == 1) {
			return 1;
		}
		
		// assume no person has a direct/indirect friend
		int friendCircles = M.length;
		
		// for each M[i][i+1] index that is 1, reduce the friend circle
		for (int i = 0; i < M.length; i++) {
			if (i+1 < M.length) {
				if (M[i][i+1] == 1) {
					friendCircles--;
				}
			}
		}
		
		return friendCircles;
	}

	public static int getMinScore(int products_nodes, int products_edges, int[] products_from, int[] products_to) {
		
	}
}
