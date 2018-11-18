package model;

public class Solutions {
    /** Algorithm 2.1
     * Sort the given array using insertion sort
     * @param A
     * @param asc - true if array is to be sorted in ascending order, false otherwise
     */
    public static void insertionSort(int[] A, boolean asc) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            // Insert A[j] into the sorted sequence A[0...j-1]
            // Loop invariant:
            //   At the start of each iteration of the for loop at line 9,
            //   A[0...j-1] is the sorted portion of the array up to element A[j-1]
            // Proof:
            //  * Initialization: Loop invariants holds before loop iteration,
            //    j = 1, A[0...j-1] consists of A[0] only, this single element array is sorted
            //  * Maintenance: the body of the loop works by moving A[j-1], A[j-2], ...
            //    one position to the right until the proper position of A[j] is found
            //    at which point A[j] is inserted back into the array
            //  * Termination: condition that causes the for loop to terminate is j >= A.length = n
            //    at this point j = n -> A[0...j-1] = A[0...n-1] -> whole array is sorted
            if (asc) {
                while (i >= 0 && (A[i] > key)) {
                    A[i+1] = A[i];
                    i--;
                }
                A[i+1] = key;
            } else {
                while (i >= 0 && (A[i] <= key)) {
                    A[i+1] = A[i];
                    i--;
                }
                A[i+1] = key;
            }
        }
    }
    
    private static void print(int[] a) {
        for (int i: a) {
            System.out.print(i + ", ");
        }
        
    }
    
    /** Exercise 2.1-3
     * Search for the index of a key using linear search
     * @param A, array to be searched
     * @param key
     * @return index of key in array A, -1 if not found
     */
    public static int linearSearch(int[] A, int key) {
        for (int i = 0; i < A.length; i++) {
            // Loop invariant:
            //   At the start of each loop, A[0...i-1] is the searched portion of the array
            // Proof:
            // * Initialization: Loop invariant holds before loop iteration, at i = 0,
            //   an array of size 0 has been searched
            // * Maintenance: the body of the loop looks for the element A[i] which is the same
            //   as they key, if not the same, increase searched array by 1
            // * Termination: if key is found, loop immediate terminates to return the index, if not,
            //   it will terminate when i = A.length, at which point, the whole array has been searched
            if (A[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    /** Exercise 2.1.4
     * Add two n-bit binary integers
     * @param A, array A storing n-bit binary integer where n is array length
     * @param B, array B storing n-bit binary integer where n is array length
     * @return C, result array storing the sum of A and B
     * Note: all elements of arrays A, B and C are 0 and 1
     * Adding rules: 0 + 0 → 0
                     0 + 1 → 1
                     1 + 0 → 1
                     1 + 1 → 0, carry 1 (since 1 + 1 = 2 = 0 + (1 × 2^1) )
     */
    public static int[] addBInteger(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n+1];
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = A[i] + B[i] + carry;
            C[i+1] = sum % 2;
            carry = sum/2;
        }
        C[0] = carry;
        return C;
    }
    
    public static void main(String[] args) {
        // Driver for insertion-sort
        int[] A = new int[] {5, 2, 4, 6, 1, 3};
        insertionSort(A, true);
        print(A);
        
        System.out.println();
        
        int[] B = new int[] {5, 2, 4, 6, 1, 3};
        insertionSort(B, false);
        print(B);
        
        System.out.println();
        
        // Driver for linear search
        int[] C = new int[] {1, 4, 5, 2, 0, 19};
        int key1 = 2;
        System.out.println(linearSearch(C, key1));
        int key2 = 3;
        System.out.println(linearSearch(C, key2));
        
        // Driver for binary addition
        int[] E = new int[] {1,1,1,0,1,1,1};
        int[] F = new int[] {1,0,1,1,0,1,0};
        int[] G = addBInteger(E, F);
        print(G);
    }
}
