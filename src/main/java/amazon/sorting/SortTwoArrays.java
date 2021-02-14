package amazon.sorting;

import java.util.Arrays;

//O(m+n)
public class SortTwoArrays {
    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2 = {5, 15, 25, 35, 45, 55, 65};

        int arr[] =mergeSortedArrays(arr1, arr2);

        Arrays.stream(arr).forEach(s-> System.out.print(s + " "));
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int brr[] = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                brr[k++] = arr1[i++];
            } else {
                brr[k++] = arr2[j++];
            }
        }
        if (i == arr1.length) {
            while (j < arr2.length) {
                brr[k++] = arr2[j++];
            }
        } else {
            while (i < arr1.length) {
                brr[k++] = arr1[i++];
            }
        }
        return brr;
    }

}
