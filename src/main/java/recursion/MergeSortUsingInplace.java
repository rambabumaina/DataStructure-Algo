package recursion;

import java.util.Arrays;

public class MergeSortUsingInplace {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4};
        System.out.println(Arrays.toString(arr));
        mergeSortInplace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortInplace(int[] arr, int s, int e) {
        //when array size become then 1 return
        if (e-s == 1) {
            return;
        }

        int m = (s + e) / 2;

        mergeSortInplace(arr, s, m);
        mergeSortInplace(arr, m, e);

        merge(arr, s, m, e);
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] mix = new int[e-s];
        int i = s, j = m, k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }

        while(i < m){
            mix[k++] = arr[i++];
        }

        while (j< e){
            mix[k++] = arr[j++];
        }

        //Copy elements from mix to original array
        for (int l = 0; l < mix.length; l++) {
            arr[l+s] = mix[l];
        }
    }
}
