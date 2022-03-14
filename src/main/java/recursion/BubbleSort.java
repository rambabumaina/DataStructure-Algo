package recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        sortArray(arr, arr.length - 1, 0);
        System.out.println("******** After sorting ****");
        System.out.println(Arrays.toString(arr));
    }

    //Using row and column approach
    private static void sortArray(int[] arr, int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
                sortArray(arr, r, c + 1);
            }
            sortArray(arr, r, c + 1);
        }
        sortArray(arr, r - 1, 0);
    }
}
