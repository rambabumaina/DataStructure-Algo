package binarySearch.com.binarysearch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteSublistToMakeSumDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 4, 5};
        int k = 7;

//        int[] nums = {2,3,2};
//        int k = 4;


        System.out.println(solve(nums, k));
    }


    static int solve(int[] nums, int k) {

        //Find total sum of array
        int sum = Arrays.stream(nums).sum();

        // if whole array is divisible by k then nothing can be removed
        if (sum % k == 0) return 0;

        //if sum is not divisible by k then, we have to remove some elements, take remaining reminder for that
        int remainingReminder = sum % k;

        sum = 0;

        int result = nums.length;

        //map will contain current reminders and their index
        Map<Integer, Integer> map = new HashMap<>();

        //for corner case, let suppose we have to remove first element from array in that case
        // first index ((0) -(-1))=1
        map.put(0, -1);

        for(int i =0 ; i < nums.length ; i++){
            sum += nums[i];
            int currentReminder = sum % k;
            int needReminder = currentReminder-remainingReminder;

            //Handle negative reminder case
            needReminder = needReminder < 0 ? (needReminder+k)%k :needReminder;

            if(map.containsKey(needReminder)){
                result = Math.min(result, i-map.get(needReminder));
            }

            //store current reminder and index
            map.put(currentReminder, i);
        }
        // if there is no element found re turn -1 else return result
        return result == nums.length? -1:result;

    }

}
