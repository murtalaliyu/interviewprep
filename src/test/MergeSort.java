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

/*
	pseudo-code: https://www.youtube.com/watch?v=TzeBrDU-JaY
	
	void mergeSort(int[] array) {
		// edge case 1: empty or size of array < 2
		if (array.length() < 2) {
			return;
		}
		
		int arraySize = array.length();
		int mid = arraySize/2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[arraySize-mid];
		
		// fill left & right with content of array
		for (i : 0 to mid-1) {
			leftArray[i] = array[i];
		}
		for (i : mid to arraySize-1) {
			rightArray[i] = array[i];
		}
		
		mergeSort(left);
		mergeSort(right);
		merge(left, right, array);
	}
	
	void merge(int[] left, int[] right, int[] array) {
		int leftSize = left.length();
		int rightSize = right.length();
		int i, j, k = 0;
		
		// compare smaller of left and right and update array[k]
		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		
		// updated array[k] with remainder of either left or right
		while (i < leftSize) {
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			array[k] = right[j];
			j++;
			k++;
		}
	}
*/
