package geeksforgeeks.mustdo.array;

//https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
public class EquilibriumPoint {
    public static void main(String[] args) {

        int[] arr = {1};//11
//        int i = equilibriumPoint_In(arr, arr.length - 1);

        int i = equilibriumPoint(arr, arr.length);
        System.out.println("I:" + i);

    }

    //13 = 6 -1 =12-3=9-5=3


    //O(n)2 solution
    public static int equilibriumPoint_In(int arr[], int n) {

        for (int i = 1; i < arr.length; i++) {

            int sum1 = findSum(arr, 0, i - 1);
            int sum2 = findSum(arr, i + 1, n);

            if (sum1 == sum2) {
                return i;
            }
        }
        return -1;
    }

    public static int findSum(int arr[], int startIndex, int endIndex) {
        int sum = 0;
        while (startIndex <= endIndex) {
            sum = sum + arr[startIndex++];
        }
        return sum;
    }


    //(on) solution
    public static int equilibriumPoint(int arr[], int n) {

        //First calculate the total sum
        int rightSum = 0;
        int leftSum = 0;

        for (int i = 0; i < n; i++)
            rightSum += arr[i];


        //subtract Each index and add in left sum if not equal
        int j = 0;
        while (j < n) {
            rightSum -= arr[j];

            if (leftSum == rightSum) {
                return j + 1;
            }
            leftSum += arr[j];
            j++;
        }

        return -1;
    }
}