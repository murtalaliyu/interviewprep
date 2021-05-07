package test;

public class InsertionSort {
	
	/**
	 * 1. go through array
	 * 2. for each index, swap if arr[i-1] < arr[i]
	 * 3. 
	 * @param arr
	 * 
	 * Time: O(n^2)
	 * Space: None
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			
			int j = i;
			
			while (j > 0 && arr[j-1] > arr[j]) {
				//swap
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				
				j--;
			}
		}
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}
}
