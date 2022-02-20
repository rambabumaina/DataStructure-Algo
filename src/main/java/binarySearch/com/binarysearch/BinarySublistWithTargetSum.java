package binarySearch.com.binarysearch;

public class BinarySublistWithTargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int k = 2;
        System.out.println(solve(nums, k));
    }

    static int solve(int[] nums, int target) {
        int start = 0, end = 0, sum = 0, count = 0;

        while (end < nums.length) {
            sum += nums[end];
            if (sum == target) {
                count++;
                sum -= nums[start];
                start++;end++;
            } else if (sum < target) {
                end++;
            } else {
                start++;
            }
        }
        return count;
    }
}
