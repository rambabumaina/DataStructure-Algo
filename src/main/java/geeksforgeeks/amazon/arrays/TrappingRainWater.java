package geeksforgeeks.amazon.arrays;

//https://www.geeksforgeeks.org/trapping-rain-water/
//o(n)2
public class TrappingRainWater {
    public static void main(String[] args) {
       int  arr[] = {8, 8, 2, 4, 5, 5, 1};

        System.out.println(trappingWater(arr,arr.length));

    }

    static int trappingWater(int arr[], int n) {
        int sum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
                int left = getLeftMax(arr, i);
                int right = getRightMax(arr, i);

                int min = Math.min(left, right);

                if(min > arr[i]){
                    sum += min-arr[i];
                }
        }

        return sum;
    }

    public static int getLeftMax(int[] arr, int index){
        int max = 0;
        for (int i = index-1; i >= 0; i--){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int getRightMax(int[] arr, int index){
        int max = 0;
        for (int i = index+1; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
