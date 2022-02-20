package leetcode.arrays;

//Formula: totalSum = n*(n+1)/2, 3*4/2 =6

public class MissingNumber {
    public static void main(String[] args) {
        int [] nums = {3,0,1};
        missingNumber(nums);
    }

    static int missingNumber(int[] nums) {
        //Formula: sum = n*(n+1)/2, 3*4/2 =6
        int sum = (nums.length * (nums.length+1))/2;
        //subtract the all numbers from sum
        for(int n : nums){
            sum -=n;
        }
        return sum;
    }
}
