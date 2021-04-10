package geeksforgeeks.amazon.arrays;

import java.util.Arrays;

public class TrappingRaiWater_Optimized {
    public static void main(String[] args) {
       int  arr[] = {3,0,0,2,0,4};

        System.out.println(trappingWater(arr,arr.length));

    }

    static int trappingWater(int arr[], int n) {
        int sum = 0;

        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];



        leftMax[0]= arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }
        rightMax[arr.length-1]= arr[arr.length-1];
        for (int i = arr.length -2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }

        for(int i = 0 ; i<arr.length; i++){
            sum += Math.min(leftMax[i], rightMax[i])-arr[i];
        }

//        Arrays.stream(leftMax).forEach((s)-> System.out.print(s+ " "));
//        System.out.println();
//        Arrays.stream(rightMax).forEach((s)-> System.out.print(s +" "));

        return sum;
    }

}
