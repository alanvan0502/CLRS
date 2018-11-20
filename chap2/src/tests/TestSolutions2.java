package tests;

import java.util.Random;

import org.junit.jupiter.api.Test;

import model.Solutions1;
import model.Solutions2;
import utils.Utils;

public class TestSolutions2 {
    
    @Test
    public void stressTestExer2_2_2() {
        Random rand = new Random();
        int size = 100;
        
        while (true) {
            int[] A = new int[size];
            int[] B = new int[size];
            for (int i = 0; i < size; i++) {
                A[i] = rand.nextInt();
                B[i] = A[i];
            }
            
            Solutions2.selectionSort(A, 0, A.length);
            Solutions1.insertionSort(B, true);
            
            System.out.println("Selection sort: ");
            Utils.print(A);
            
            System.out.println();
            System.out.println("Insertion sort: ");
            Utils.print(B);
            System.out.println();
            
            if (!Utils.checkEqual(A, B)) break;
        }

    }
}
