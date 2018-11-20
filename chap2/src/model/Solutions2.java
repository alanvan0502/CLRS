package model;

import utils.Utils;

public class Solutions2 {
    
    /** Exercise 2.2-2
     * Selection sort
     * @param A, array A to be sorted
     */
    public static void selectionSort(int[] A, int left, int right) {
        while (left + 1 < right) {
            // Loop invariant:
            // At the start of each loop, A[left..j] is the sorted portion of the array
            // Proof:
            // * Initialization: Loop invariant holds before loop iteration, at j = left
            //   an array of size 0 has been sorted
            // * Maintenance: the body of the loop finds the index of the minimum element in the un-sorted
            //   part of the array (A[j..right] and swap that element with the left-most element A[j]
            //   j is then incremented by 1 to signify that the sorted portion of the array is increased
            //   by 1 to the right.
            // * Termination: loop terminates when left + 1 == right, at which point, the sorted portion
            //   of the array is A[left..right-1]. The loop will yield the fully sorted array as the last
            //   element at A[right-1] must be the largest element
            // Time complexity: Theta(n^2) - worst case, when input array is sorted in reverse order
            //   and Theta(n) - best case, when input array is already sorted in correct order
            
            int i = findMin(A, left, right);
            int temp = A[left];
            A[left] = A[i];
            A[i] = temp;
            left ++;
        }
    }
    
    private static int findMin(int[] A, int left, int right) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = left; i < right; i++) {
            if (A[i] < min) {
                min = A[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] A = new int[] {6, 4, 1, 5, 7, 6, 9};
        selectionSort(A, 0, A.length);
        Utils.print(A);
    }

}
