package recursion;


import java.util.Arrays;

/**
 * Pivot: After First pass all the elements < p will be on the LHS of the pivot & all the > p will be RHS of the pivot
 * <p>
 * You can choose any element as pivot from the array it completely up to us
 * <p>
 * In quicksort we are putting pivot at its correct position
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int hi) {

        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;

        int pivot = s + (e - s) / 2;

        while (s <= e) {

            //If start less than pivot
            while (arr[s] < arr[pivot]) {
                s++;
            }

            //If End greater than pivot
            while (arr[e] > arr[pivot]) {
                e--;
            }

            //Swap start and end index
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        //sort first halves
        quickSort(arr, s, pivot);

        //sort second halves
        quickSort(arr, pivot, e);
    }

}
