package test;

public class MergeSort {
	
	/**
	 * Main function that sorts arr[l..r] using merge()
	 */
	public static void sort(int arr[], int l, int r) {
		if (l < r) {
			// find the middle point
			int m = (l + r) / 2;
			
			// sort first and second halves
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			// merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/**
	 * Merges 2 sub-arrays of arr[]
	 * First sub-array is arr[1..m]
	 * Second sub-array is arr[m+1..r]
	 */
	private static void merge(int arr[], int l, int m, int r) {
		// find sizes of 2 sub-arrays to be merged
		int lSize = m - l + 1;
		int rSize = r - m;
		
		// create 2 temp arrays
		int L[] = new int[lSize];
		int R[] = new int[rSize];
		
		// copy data to temp arrays
		for (int i = 0; i < lSize; ++i) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < rSize; ++j) {
			R[j] = arr[m + 1 + j];
		}
		
		/* Merge the temp arrays */
		
		// initial indexes of first & second sub-arrays
		int i = 0, j = 0;
		
		// initial index of merged sub-array array
		int k = l;
		while (i < lSize && j < rSize) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		// copy remaining elements of L[] if any
		while (i < lSize) {
			arr[k] = L[i];
			i++;
			k++;
		}
		// copy remaining elements of R[] if any
		while (j < rSize) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	/**
	 * A utility function to print array of size n
	 */
	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
