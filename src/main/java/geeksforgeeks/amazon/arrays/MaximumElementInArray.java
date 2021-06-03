package geeksforgeeks.amazon.arrays;

public class MaximumElementInArray {
    public static void main(String[] args) {

        int arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 350, 250, 150};
//        int arr[] = {500, 350, 250, 150};
       // int arr[] = {8, 10, 20, 80, 100, 200, 400, 500};
        System.out.println( maximumElementInArray(arr, 0, arr.length-1));
    }

    private static int maximumElementInArray(int[] arr, int low, int high) {
        if(high >= low){
            int mid = low+(high-low)/2;

            if(mid+1 <=high && arr[mid] > arr[mid+1] && mid-1 >=low && arr[mid-1] < arr[mid] || low==high){
                return arr[mid];
            }
            if(arr[mid] < arr[mid+1]){
                return maximumElementInArray(arr,mid+1, high);
            }else{
                return maximumElementInArray(arr,low, mid-1);
            }
        }
        return -1;
    }
}
