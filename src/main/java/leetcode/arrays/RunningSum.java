package leetcode.arrays;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {

        int [] arr = {1,2,3,4};

        RunningSum r  = new RunningSum();
        int [] brr = r.runningSum(arr);
        Arrays.stream(brr).forEach(b -> System.out.print(b+ " "));
    }

    public int[] runningSum(int[] nums) {
        int [] arr = new int[nums.length];
        int sum = 0;
        for (int i =0 ; i < nums.length ; i++){
            sum += nums[i];
            arr[i] =sum;
        }
        return arr;
    }
}
