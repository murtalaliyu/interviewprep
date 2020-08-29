package test;

public class BinarySearch {
	
	/**
	 * Using Comparison Tree
	 * Array MUST be sorted
	 * @param list
	 * @param target
	 * @return
	 */
	public static boolean binarySearch(int[] array, int target) {
		int lo = 0;
		int hi = array.length-1;
		
		while (lo <= hi) {
			//int mid = (lo+hi) / 2;
			int mid = lo + ((hi - lo) / 2);	// to account for extremely large arrays
			
			if (target == array[mid]) {
				return true; // return mid
			}
			if (target < array[mid]) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		
		return false;	// return -1
	}
}
