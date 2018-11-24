package model;

import utils.Utils;

public class Solutions3 {


	/**
	 * Merge sort algorithm - section 2.3.1
	 * @param A, array to be sorted
	 * @param p, left index of array portion to be sorted
	 * @param r, right index of array portion to be sorted, inclusive
	 */
	public static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (int)Math.floor((p + r)/2);
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			mergeNoSentinels(A, p, q, r);
		}
	}

	/** Modifies array A by merging 2 sorted portions of it A[p..q] and
	 *	A[q+1..r]
	 */
	private static void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];

		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = A[q + j + 1];
		}

		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;

		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
	}

	/**
	 * Exercise 2.3-2
	 * Merge procedure not using sentinels
	 */
	private static void mergeNoSentinels(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = A[q + j + 1];
		}

		int i = 0;
		int j = 0;

		for (int k = p; k <= r; k++) {
			if (i >= n1) {
				A[k] = R[j];
				j++;
			} else if (j >= n2) {
				A[k] = L[i];
				i++;
			} else if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
	}

	/**
	 * Exercise 2.3-6
	 */
	//	This function searches for the place in the sorted array where key can be correctly slotted in
	//	so that the array is still properly sorted. In Insertion Sort algorithm at Page 18, this can be used to
	//  find the position where the key = A[j] can be slotted into the sorted sequence A[1..j-1] in O(log n) time complexity.
	//  However, once this is inserted, the whole portion of the sequence A[1..j-1] that is larger than key value will need to be
	//  shifted by 1 to the right. This is a O(n) algorithm. Hence, the whole algorithm still has O(n^2) time complexity
	//  For more clarity, refer to page 18 of CLRS or Solutions1.java in this project.
	public static int binarySearchArray(int[] array, int low, int high, int key) {
		if (low > high) return - 1;
		else {
			int mid = (int) Math.floor(low + (high - low)/2);
			if (array[mid] <= key && key < array[mid + 1])
				return mid;
			else if (array[mid] > key)
				return binarySearchArray(array, low, mid - 1, key);
			else
				return binarySearchArray(array, mid + 1, high, key);
		}
	}

	/**
	 * Exercise 2.3-7
	 * @param A
	 * @param sum
	 * @return returns true if the input array has 2 elements whose sum is equal to input sum
	 */
	public static boolean twoSum(int[] A, int sum) {
		mergeSort(A, 0, A.length - 1);
		int[] B = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			B[i] = sum - A[i];
		}
		for (int i = 0; i < B.length; i++) {
			int j = Utils.binarySearch(A, B[i]);
			if (j != -1 && j != i)
				return true;
		}
		return false;
	}

	/**
	 * Problem 2-1
	 * Insertion sort on small arrays in merge sort
	 * A, p, r are the same as mergeSort, k is size of sub-array where insertion sort
	 * algorithm kicks in
	 */
	public static void mergeInsertSort(int[] A, int p, int r, int k) {
		if (p - r > k) {
			int q = (int)Math.floor((p + r)/2);
			mergeInsertSort(A, p, q, k);
			mergeInsertSort(A, q + 1, r, k);
			merge(A, p, q, r);
		} else {
			insertionSort(A, p, r);
		}
	}

	public static void insertionSort(int[] A, int left, int right) {
		for (int j = left; j <= right; j++) {
			int key = A[j];
			int i = j - 1;
			while (i >= 0 && (A[i] > key)) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = key;
		}
	}
	
	/** Driver */
	public static void main(String[] args) {
		int[] A = new int[] {4, 5, 2, 1, 6};
		mergeSort(A, 0, A.length-1);
		Utils.print(A);

		int[] B = new int[] {6, 2, 1, 5, 6, 7};
		mergeSort(B, 0, B.length-1);
		Utils.print(B);

		int[] C = new int[] {1, 4, 7, 8, 0, 2, 3};
		mergeNoSentinels(C, 0, 3, C.length - 1);
		Utils.print(C);

		// Driver for twoSum function
		int[] D = new int[] {7, 4, 6, 1, 9};
		System.out.println(twoSum(D, 16));
		System.out.println(twoSum(D, 14));
		System.out.println(twoSum(D, 10));
		System.out.println(twoSum(D, 12));
		
		// Driver for mergeInsert
		int[] E = new int[] {7, 4, 6, 1, 9, 100, 89, 17, 30};
		mergeInsertSort(E, 0, E.length - 1, 3);
		Utils.print(E);
	}
}
