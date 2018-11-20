package utils;

public class Utils {
    /** Print an array */
    public static void print(int[] a) {
        for (int i: a) {
            System.out.print(i + ", ");
        }
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
}
