package leetcode.arrays;

public class FindSingleNumber {

    public static void main(String[] args) {
       int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    //XOR same1-1 =0 and 0-0 =0 will become zero different 1
    public static int singleNumber(int[] nums) {
        int i =1;
        int num =nums[0];

        while( i < nums.length){
            num = num ^ nums[i];
            i++;
        }

        return num;
    }
}
