package geeksforgeeks.amazon.arrays;

import java.util.Arrays;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
public class RotateArrayKTimes {

    public static void main(String[] args) {
        int[] nums = {1, 2}; // output : 5,6,7,1,2,3,4
        //3,1,2
        //2,3,1
        //1,2,3
        //3,2,1
        int k = 5;

        rotate(nums, k);
    }

    //1. reverse array 0 to length-k th elements
    //2. reverse length-k  to length elements
    //3. reverse again 0 to length elements
    public static void rotate(int[] nums, int k) {
        while (k > nums.length) {
            k = k - nums.length;
        }
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::print);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
