package leetcode.arrays;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum_map(nums, target);
        Arrays.stream(result).forEach(s -> System.out.print(s));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
                j++;
            }
        }
        return result;
    }

    public static int[] twoSum_map(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if(map.containsKey(complement)){
                result[0] = map.get(complement);
                result[1] = i;
                break;
            }else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
