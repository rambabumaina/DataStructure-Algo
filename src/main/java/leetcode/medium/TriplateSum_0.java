package leetcode.medium;

import java.util.*;

//https://www.youtube.com/watch?v=fj1g_-BwCMk
public class TriplateSum_0 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //threeSum_BruteForce(nums);
        System.out.println( threeSum(nums));
    }

    //O(n3) solution
    public static List<List<Integer>> threeSum_BruteForce(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[i = 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                        }
                    }
                }
            }

        }
        return result;
    }

    //Dry Run: -4,-1,-1,0,1,2
    //Two pointer approach a+B+c=0, we will fix first value and check in the array with the help of other two pointers

    // -4 : fixed and searching +4 with the help of left and right pointer in the array
    // there is
    static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        //run loop until -2
        List<Integer> pairs =null;
        for (int i = 0; i < nums.length - 2; i++) {
            int val = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = val + nums[left] + nums[right];
                if (sum == 0) {
                    pairs = new ArrayList<>();
                    pairs.add(val);
                    pairs.add(nums[left]);
                    pairs.add(nums[right]);
                    result.add(pairs);
                    //we found pair the move both pointer
                    left++;right--;
                } else if (sum < 0) left++;  //we found pair the move left pointer
                else right--;
            }
        }
        return new ArrayList<>(result);
    }
}
