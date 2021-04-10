package geeksforgeeks.amazon.arrays;

import java.util.Arrays;

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
