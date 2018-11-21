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
//  find the position where the key = A[j] can be slotted into the sorted sequence A[1..j-1]. However, once
//  this is inserted, the whole portion of the sequence A[1..j-1] that is larger than key value will need to be
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
	}
}
