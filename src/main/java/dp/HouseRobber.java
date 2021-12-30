package dp;

import java.util.Arrays;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/
public class HouseRobber {
    public static void main(String[] args) {
        //int [] nums = {2,7,9,3,1};
//       int [] nums = {6, 7, 1, 3, 8, 2, 4};
        int[] nums = {5, 3, 4, 11, 2}; //5, and 11
        System.out.println(rob(nums));
    }

    //O(n) , O(1)
    static int rob1(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);


        int MAX_LOOT1 = nums[0];
        int MAX_LOOT2 = Math.max(MAX_LOOT1, nums[1]);
        int FInal_loot = 0;


        for (int i = 2; i < nums.length; i++) {
            FInal_loot = Math.max(MAX_LOOT1 + nums[i], MAX_LOOT2);
            MAX_LOOT1 = MAX_LOOT2;
            MAX_LOOT2 = FInal_loot;
        }

        return FInal_loot;
    }

    static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        Arrays.stream(dp).forEach(i -> System.out.print(i + " "));

        return dp[dp.length - 1];
    }
}
