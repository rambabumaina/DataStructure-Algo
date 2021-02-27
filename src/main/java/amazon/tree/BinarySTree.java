package amazon.tree;

//O(logn)
public class BinarySTree {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = binarySearch(arr, 0, arr.length - 1, 4);

        for (int i=0 ; i< arr.length; i++){
            System.out.println(binarySearchIterative(arr,0, arr.length-1, arr[i]));
        }

    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        if (high < low) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (arr[mid] == key) {
            return mid;
        }

        if(arr[mid] < key){
            return binarySearch(arr, mid + 1, high, key);
        }else {
            return binarySearch(arr, low, mid - 1, key);
        }
    }

    private static int binarySearchIterative(int[] arr, int low, int high, int key) {
           while (low<= high){
           int mid = low + (high-low)/2;

            if (key == arr[mid]){
                return mid;
            }

            if (key > arr[mid]){
                low = mid+1;
            }else {
                high = mid -1;
            }

        }
        return -1;
    }
}
