package recursion;

//Time:0(n)
//Space:0(n)
public class FindIfArraySortedOrNot {
    public static void main(String[] args) {
        int[] arr = {10, 20, 25, 35, 40, 50, 75};
        System.out.println("IsSorted : " + isSorted(arr));
        System.out.println("Approach 2 : " + approach2(arr,0));
    }

    private static boolean isSorted(int[] arr) {
        return helper(arr, 0, arr.length - 1);
    }

    private static boolean helper(int[] arr, int s, int e) {
        if (s >= e) {
            return true;
        }
        if (arr[s] > arr[s + 1]) {
            return false;
        }
        return helper(arr, s + 1, e);
    }


    private static boolean approach2(int[] arr, int index) {
        if (index == arr.length-1) {
            return true;
        }
        return arr[index] < arr[index+1] && approach2(arr,index+1);
    }
}
