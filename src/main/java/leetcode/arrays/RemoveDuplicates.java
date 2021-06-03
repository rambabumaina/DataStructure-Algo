package leetcode.arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {
    public static void main(String[] args) {
       int [] nums = {0,0,1,1,1,2,2,3,3,4};

//        System.out.println(onlyCount(nums));
        System.out.println(removeDuplicates(nums));
    }

    //Logic : if j < i , then copy i value to j+1 and increment j
    public static int removeDuplicates(int [] nums){
        int j =0;
        for (int i =1; i < nums.length; i++){
            if(nums[j] < nums[i]){
                nums[j+1] = nums[i];
                j++;
            }
        }
        return j+1;
    }

    public static int onlyCount(int[] nums) {

        int j =1 ;
        for(int i =1 ; i < nums.length ;i++){
            if(nums[i-1] != nums[i]){
                j++;
            }
        }
        return j;
    }
}
