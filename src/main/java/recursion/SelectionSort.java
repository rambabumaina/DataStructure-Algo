package recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));

        selectionSortArr(arr,arr.length-1, 0);

        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSortArr(int[] arr, int r, int c) {

        if (r == 0) return;

        if (c < r) {
            if (arr[c] > arr[r]) {
                int temp = arr[c];
                arr[c] = arr[r];
                arr[r] = temp;
                selectionSortArr(arr, r, c + 1);
            }
            selectionSortArr(arr, r, c + 1);
        }
        selectionSortArr(arr, r -1, 0);
    }
}
