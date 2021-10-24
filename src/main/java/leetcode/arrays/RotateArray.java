package leetcode.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int input[] = {1,2,3,4,5,6,7};
        int k =3;

        rotate(input, k);
    }

    public static void rotate(int[] nums, int k) {
        int i =0;

        while(i <k){
          rotateKTimes(nums,0);
            Arrays.stream(nums).forEach(v-> System.out.print(v));
            System.out.println();
        }
    }

    private static void rotateKTimes(int[] nums, int i) {

        int len = nums.length;
        while (i%len < len){
            nums[(i+1)%len] = nums[i];
            i++;
        }
    }

}
