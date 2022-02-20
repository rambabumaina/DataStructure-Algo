package leetcode.binarySearch;

public class SearchInsertPosition_35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
//        int target = 2;
        int res = searchInsert(nums, target);
        System.out.println(res);

    }

    public static int searchInsert(int[] nums, int target) {
        return searchInsertUtil(nums, 0, nums.length, target);
    }

    public static int searchInsertUtil(int[] nums, int low, int high, int target) {
        if (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                return searchInsertUtil(nums, low, mid-1, target);
            } else {
                return searchInsertUtil(nums, mid + 1, high, target);
            }

        }
        return -1;
    }
}
