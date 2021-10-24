package leetcode.arrays.twoPointer;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0};
        int[] nums = {1,2,3,4,5};
        moveZeroes(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }

    static void moveZeroes(int[] nums) {
        int i = -1, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0 ) {
                i++;
                int temp = nums[j];
                nums[j]= nums[i];
                nums[i] = temp;
            }
            j++;
        }
    }
}
