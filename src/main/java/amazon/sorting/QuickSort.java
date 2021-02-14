package amazon.sorting;

import java.util.Arrays;

//O(nlogn)
public class QuickSort {
    public static void main(String[] args) {

        int arr[] = {50,20};

        quicksort(arr);
        Arrays.stream(arr).forEach(s-> System.out.print(s + " "));
    }

    public static void quicksort(int[] arr) {
        quickSortUtil(arr, 0, arr.length - 1);

    }

    private static void quickSortUtil(int[] arr, int low, int high) {
        if (high > low) {
            int pivotIndex = getPivotIndex(arr, low, high);
            quickSortUtil(arr,low,pivotIndex-1);
            quickSortUtil(arr,pivotIndex+1,high);
        }
    }

    private static int getPivotIndex(int[] arr, int low, int high) {
        int i = low-1;
        int j = low;
        while (j<=high){
            if(arr[j]<=arr[high]){
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
