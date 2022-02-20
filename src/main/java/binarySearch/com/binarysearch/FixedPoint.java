package binarySearch.com.binarysearch;

public class FixedPoint {
    public static void main(String[] args) {
//        int[] nums = {-5, -2, 0, 3, 4};
//        int[] nums ={0};
        int[] nums ={0,1,2};

        System.out.println(solve(nums));
    }

    static int solve(int[] nums) {
        if(nums.length == 0) return -1;
        int low = 0;
        int result = Integer.MAX_VALUE;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == nums[mid]){
                result = mid;
                high = mid -1;
            } else if (mid < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result == Integer.MAX_VALUE ?-1 :result;
    }
}
