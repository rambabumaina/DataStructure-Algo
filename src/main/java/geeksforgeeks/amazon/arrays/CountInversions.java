package geeksforgeeks.amazon.arrays;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
//Merge Sort o(n) solution
public class CountInversions {

    public static void main(String[] args) {
//        int[] arr = {2, 4, 1, 3, 5};
//        int[] arr = {8, 4, 2, 1};
        long[] arr = {8, 10, 11, 12, 1, 2, 7, 13, 15};

        System.out.println(inversionCount(arr,arr.length));

        Arrays.stream(arr).forEach(f -> System.out.print(f + " "));
    }

    static long inversionCount(long[] arr, long N)
    {

        return inversionCount_util(arr, 0, (int)N-1);
    }

    //Divide the array in tow part until it become non
    // call count to get the count
    static long inversionCount_util(long[] arr, int low, int high) {
        long count = 0;
        if (high > low) {
            int mid = low + (high - low) / 2;
            count += inversionCount_util(arr, low, mid);
            count += inversionCount_util(arr, mid + 1, high);
            count += count(arr, low, mid, high);
        }
        return count;
    }

    //take one temp array store sorted element
    //Consider two list are sorted if
    private static long count(long[] arr, int low, int mid, int high) {
        long count = 0;
        long[] brr = new long[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                brr[k++] = arr[i++];
            } else {
                brr[k++] = arr[j++];
                count += mid - i + 1;
            }
        }


        while (i <= mid) {
            brr[k++] = arr[i++];
        }

        while (j <= high) {
            brr[k++] = arr[j++];
        }

        i = 0;
        while (i < k) {
            arr[low++] = brr[i++];
        }
        return count;
    }
}
