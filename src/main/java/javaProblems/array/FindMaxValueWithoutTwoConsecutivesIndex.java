package javaProblems.array;

//https://practice.geeksforgeeks.org/problems/stickler-theif/0
public class FindMaxValueWithoutTwoConsecutivesIndex {
    public static void main(String[] args) {
        int arr[] = {2}; //14
        System.out.println(returnMaxLootingAmount(arr));
    }

    private static int returnMaxLootingAmount(int arr[]) {
        if (arr.length == 1) {
            return arr[0];
        }

        int brr[] = new int[arr.length];
        brr[0] = arr[0];
        brr[1] = arr[1];

        if (arr.length > 2) {
            brr[2] = arr[0] + arr[2];
            for (int i = 3; i < arr.length; i++) {
                brr[i] = arr[i] + Math.max(brr[i - 2], brr[i - 3]);
            }
        }

        return Math.max(brr[brr.length - 1], brr[brr.length - 2]);
    }
}
