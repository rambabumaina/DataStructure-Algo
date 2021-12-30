package leetcode.arrays;

import java.util.Arrays;

public class MergerTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 5, 6};
//        Arrays.stream(nums1).forEach(i-> System.out.print(i +" "));
        System.out.println();
        merge(nums1, nums1.length, nums2, nums2.length);
//        Arrays.stream(nums1).forEach(i-> System.out.print(i +" "));
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0, k=0;
        int [] brr = new int[m+n];

        while (i < m && j < n) {
            if(nums1[i] < nums2[j]){
                brr[k++] = nums1[i++];
            } else {
                brr[k++] = nums2[j++];
            }
        }

            while (i < m){
                brr[k++] = nums1[i++];
            }

            while (j < n){
                brr[k++] = nums2[j++];

        }

       nums1 =Arrays.copyOf(nums1,brr.length);
        Arrays.stream(nums1).forEach(a-> System.out.print(a +" "));

        System.out.println();
        Arrays.stream(brr).forEach(b-> System.out.print(b +" "));

        for (int a =0 ; a< brr.length; a++){
            nums1[a] = brr[a];
        }
    }
}
