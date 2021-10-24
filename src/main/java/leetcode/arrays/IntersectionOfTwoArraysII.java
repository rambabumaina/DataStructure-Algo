package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {

//       int[] nums1 = {4,9,5};
//       int [] nums2 = {9,4,9,8,4};

       int [] nums1 = {1,2,2,1};
       int [] nums2 = {2,2};

        Arrays.stream(intersect(nums1, nums2)).forEach(n -> System.out.print(n + " "));
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums1).forEach(f->{
            map.putIfAbsent(f,0);
            map.put(f,map.get(f)+1);
        });

        Arrays.stream(nums2).forEach(n->{
            if (map.containsKey(n) && map.get(n) >0){
               result.add(n);
               map.put(n, map.get(n)-1);
            }
        });

        return result.stream().mapToInt(i->i).toArray();
    }
}
