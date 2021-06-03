package leetcode.arrays;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length ==1){
            return 1;
        }

        Arrays.sort(nums);

        int midIndex = searchValue(nums, 0, nums.length - 1, val);
        int i = midIndex;
        for (; i > 0; i--) {
            if (nums[i - 1] != nums[i]) {
                break;
            }
        }

        int j = i;
        int length = nums.length - 1;
        while (nums[j] == val) {
                nums[j] = nums[length];
                nums[length] = 0;
                j++;
                length--;
        }
        Arrays.stream(nums).forEach(f -> System.out.print(f + " "));
        System.out.println();
        return j-1;
    }

    private static int searchValue(int[] nums, int low, int high, int val) {
        if (high >= low) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == val) {
                return mid;
            } else if (val < nums[mid]) {
                return searchValue(nums, low, mid - 1, val);
            } else {
                return searchValue(nums, mid + 1, high, val);
            }
        }
        return -1;
    }
}
