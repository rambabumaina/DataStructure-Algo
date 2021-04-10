package geeksforgeeks.amazon.arrays;

public class LocalMiniMa {
    public static void main(String[] args) {
        int arr[] = {9, 8, 7, 6, 5, 4, 3};
        System.out.println(localMinima(arr, arr.length));
    }

    private static int localMinima(int[] arr, int length) {

        if (length == 1) {
            return 0;
        } else if(length == 2){
            if(arr[0] <= arr[1]){
                return 0;
            }else {
                return 1;
            }
        } else {
            int i = 1;
            for (; i < length-1; i++) {
                if (arr[i] <= arr[i-1] && arr[i] <= arr[i+1]){
                    return i;
                }
            }
            if(arr[length-1] <= arr[i]){
                return arr.length-1;
            }
        }
        return -1;
    }
}
