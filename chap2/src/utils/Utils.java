package utils;

public class Utils {
    /** Print an array */
    public static void print(int[] a) {
        for (int i: a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    
    /** Compare two int array */
    public static boolean checkEqual(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        else
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i])
                    return false;
            }
        return true;
    }
    
    /** Binary search algorithm for an int array */
	public static int binarySearch(int[] array, int low, int high, int key) {
	    if (low > high) return - 1;
	    else {
	        int mid = (int) Math.floor(low + (high - low)/2);
	        if (array[mid] == key)
	            return mid;
	        else if (array[mid] > key)
	            return binarySearch(array, low, mid - 1, key);
	        else
	            return binarySearch(array, mid + 1, high, key);
	    }
	}
	
	public static int binarySearch(int[] a, int x) {
	    int left = 0, right = a.length - 1;
	    return binarySearch(a, left, right, x);
	}
	
	/** Linear search algorithm for an int array */
	public static int linearSearch(int[] a, int x) {
	    for (int i = 0; i < a.length; i++) {
	        if (a[i] == x) return i;
	    }
	    return -1;
	}
}
