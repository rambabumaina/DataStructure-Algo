package geeksforgeeks.amazon.arrays;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1

/**
 * Approach 1: Run three loops i,j ,k , check the A+b=c or a+c=b or c+b=a this needs o(n)3
 *
 * Approach 2: Sort the array
 * Run Two loops, keep one pointer k at the last element and i at 0 and j at k-1
 * take square and check if i+j =k if yes return true else run for k-1 and so on...
 */
public class PythagoreanTriplet {
    public static void main(String[] args) {

        int Arr[] = {3, 2, 4, 6, 5};
//        int Arr[] = {3, 8, 5};
        PythagoreanTriplet p = new PythagoreanTriplet();
        System.out.println(p.checkTriplet(Arr, Arr.length));
    }

    boolean checkTriplet(int[] arr, int n) {

        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i--) {
            int c = arr[i] * arr[i];
            for (int j = 0, k = i - 1; j < k; ) {
                int a = arr[j] * arr[j];
                int b = arr[k] * arr[k];
                if (a + b == c) {
                    return true;
                } else if (a + b < c) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return false;
    }
}
