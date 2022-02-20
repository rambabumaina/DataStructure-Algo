package binarySearch.com.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=7nzwrX4N_A0
//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

public class OperationsToDecrementTargetZero {
    static int result;
    public static void main(String[] args) {

        int[] nums = {1,1,4,2,3};
        int target = 5;
       // System.out.println("Target :"+ solve(nums, target));
        System.out.println(optimizedSolution(nums,target));
    }

    static int solve(int[] nums, int target) {
        result=Integer.MAX_VALUE;
        recursive(nums, target, 0, nums.length - 1, 0);
        return result ==Integer.MAX_VALUE?-1:result;
    }

    //Recursive Solution
    static void recursive(int[] nums, int target, int left, int right, int count) {
        if (target == 0) {
            result = Math.min(result,count);
            return;
        }

        if(target < 0 || left > right){
            return;
        }

        recursive(nums, target - nums[left], left + 1, right, count + 1);
        recursive(nums, target - nums[right], left, right - 1, count + 1);
    }


    static int optimizedSolution(int[] nums, int target) {

        //Map to store prefix sum and their index
        Map<Integer, Integer> map = new HashMap<>();
        int sum =0;

        //Find Prefix sum and store in the map
        for (int i=0; i < nums.length; i++){
            sum +=nums[i];
            map.put(sum,i);
        }

        //If total sum is less than Target then return
        if(sum < target) return -1;

        //To handle corner case
        map.put(0, 0);

        int MaxRange=0, value=0;

        //Decrement Sum because we are going to search remaining sum
        sum -=target;

        //Dry run : 1,1,4,2,3
        // We are finding 6 here, because {prefixSum-target= rest sub_array sum}
        //1: 1- 6 = -5, is there in map = false
        //2: 2-6 = -4 is there in map = false
        //3: 6-6 =0 is there in map = true, MaxRange = 3 {2-0+1=3}
        //4: 8-6 = 2 is there in map= ture, MaxRange = 3 {ma(3, 2)}
        //5: 11-6 = 5 is there in map = false
        for(int i =0 ; i < nums.length ; i++){
            value +=nums[i];
            if(map.containsKey(value-sum)){

                if(value-sum== 0){
                    MaxRange = Math.max(MaxRange, i - map.get(value-sum)+1);
                }else{
                    MaxRange = Math.max(MaxRange, i- map.get(value-sum));
                }
            }
        }
        //if MaxRange ==0 , that means sum could be 0 if yes return num.length
        //if MaxRange !=0 , then return num length - MaxRange
        return MaxRange ==0 ? (sum == 0?nums.length:-1):nums.length-MaxRange ;
    }
}
