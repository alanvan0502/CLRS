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
		int l = 0;

		while (i != n1 && j != n2) {
			if (L[i] <= R[j]) {
				A[l] = L[i];
				i++;
				l++;
			} else {
				A[l] = R[j];
				j++;
				l++;
			}
		}

		while (l <= r) {
			if (i < n1) {
				A[l] = L[i];
				i++;
				l++;
			}
			if (j < n2) {
				A[l] = R[j];
				j++;
				l++;
			}
		}

	}

	/** Driver */
	public static void main(String[] args) {
		//		int[] A = new int[] {4, 5, 2, 1, 6};
		//		mergeSort(A, 0, A.length-1);
		//		Utils.print(A);
		//
		//		int[] B = new int[] {6, 2, 1, 5, 6, 7};
		//		mergeSort(B, 0, B.length-1);
		//		Utils.print(B);
		//
		int[] C = new int[] {1, 4, 7, 8, 0, 2, 3};
		mergeNoSentinels(C, 0, 3, C.length - 1);
		Utils.print(C);
	}
}
