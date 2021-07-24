package test;

public class QuickSort {

	public static <T extends Comparable<T>> void sort(T[] list) {
		if (list.length <= 1) {
			return;
		}
		sort(list,0,list.length-1);
	}
	
	private static <T extends Comparable<T>> void sort(T[] list, int lo, int hi) {
		if ((hi-lo) <= 0) {	// fewer than 2 items
			return;
		}
		
		int splitPoint = split(list,lo,hi);
		
		sort(list,lo,splitPoint-1);	// left sub-array recursion
		sort(list,splitPoint+1,hi);	// right sub-array recursion
	}
	
	private static <T extends Comparable<T>> int split(T[] list, int lo, int hi) {
		int left = lo+1;
		int right = hi;
		T pivot = list[lo];
		
		while (true) {
			while (left <= right) {
				if (list[left].compareTo(pivot) < 0) {
					left++;
				} else {
					break;
				}
			}
			
			while (right > left) {
				if (list[right].compareTo(pivot) < 0) {
					break;
				} else {
					right--;
				}
			}
			
			if (left >= right) {
				break;
			}
			
			// swap left and right items
			T temp = list[left];
			list[left] = list[right];
			list[right] = temp;
			
			// advance each one step
			left++;	right--;
		}
		
		// swap pivot with left-1 position
		list[lo] = list[left-1];
		list[left-1] = pivot;
		
		// return the split point
		return left-1;
	}
	
	public static void print(Integer[] list) {
		System.out.print("[");
		if (list.length > 0) {
			System.out.print(list[0]);
		}
		for (int i=1; i < list.length; i++) {
			System.out.print("," + list[i]);
		}
		System.out.println("]");
	}
}

/*
 * pseudo-code: https://www.youtube.com/watch?v=COk73cpQbFQ&t=1077s
 * 
 * void quickSort(int[] array, int start, int end) {
 * 		if (start < end) {
 * 			int partitionIndex = partition(array, start, end);
 * 			quickSort(array, start, partitionIndex-1);
 * 			quickSort(array, partitionIndex+1, end);
 * 		}
 * }
 * 
 * int partition(int[] array, int start, int end) {
 * 		pivot = array[end];
 * 		partitionIndex = start;
 * 		
 * 		// end-1 because we picked the last element as pivot
 * 		for (i : start to end-1) {
 * 			if (array[i] <= pivot) {
 * 				swap(array[i], array[partitionIndex]);
 * 				partitionIndex++;
 * 			}
 * 		}
 * 
 * 		swap(array[partitioinIndex], array[pivot]);
 * 		return partitionIndex;
 * }
 */
