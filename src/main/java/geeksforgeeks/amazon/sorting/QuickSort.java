package geeksforgeeks.amazon.sorting;

import java.util.Arrays;

/**
 *  O(nlogn) best case time complexcity
 *  O(n^2) in worst case
 */


/**
 * Quick sort follows devide and conquer technique
 * Quick sort is fast for small elements as compare to merger sort
 * Create boundary with pivot element where all left side elements are less than or equals with pivot and all the elements right side of list is grater then pivot
 *
 * The algorithm picks a pivot element, rearranges the array elements in such a way that
 * all elements smaller than the picked pivot element move to left side of pivot, and all greater elements move to right side.
 * Finally,the algorithm recursively sorts the sub arrays on left and right of pivot element.
 *
 */

public class QuickSort {
    public static void main(String[] args) {

        int arr[] = {50, 20};

        quicksort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    public static void quicksort(int[] arr) {
        quickSortUtil(arr, 0, arr.length - 1);

    }

    private static void quickSortUtil(int[] arr, int low, int high) {
        if (high > low) {
            int pivotIndex = getPivotIndex(arr, low, high);
            quickSortUtil(arr, low, pivotIndex - 1);
            quickSortUtil(arr, pivotIndex + 1, high);
        }
    }

    private static int getPivotIndex(int[] arr, int low, int high) {
        int i = low - 1;
        int j = low;

        while (j <= high) {
            if (arr[j] <= arr[high]) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }
        return i;
    }
}
