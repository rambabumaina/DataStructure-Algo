package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IntersectionTwoArrays {

    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 2, 1};
//        int[] arr2 = {2, 2};
//
//        System.out.println(intersection(arr1,arr2));


    }


    public static void m1(Long i){
        System.out.println("Integer");
    }


    public static void m1(String s){
        System.out.println("String");
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i:nums1  ) {
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<Integer>();
        for (int i:nums2  ) {
            set2.add(i);
        }

        set1.stream().forEach(f-> System.out.print(f + " "));
        System.out.println();
        set2.stream().forEach(f-> System.out.print(f + " "));

        Set<Integer> result = new HashSet<>();

        return null;
    }
}
