package recursion;

public class FindTargetInSortedAndRotatedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        int key = 8;
        System.out.println("<> :" + findKey(arr, key, 0, arr.length - 1));
    }

    static int findKey(int[] arr, int key, int s, int e) {
        if (s > e) return -1;

        int m = s + (e - s) / 2;

        if (arr[m] == key) return m;

        //when key is in sorted array only
        if (arr[s] <= arr[m]) {
            if (arr[s] <= key && key <= arr[m]) {
                return findKey(arr, key, s, m - 1);
            }else{
                return findKey(arr, key, m + 1, e);
            }
        }

        //when key is not in sorted array
        if (key >= arr[m] && key <= arr[e])
            return findKey(arr, key, m + 1, e);
        else
            return findKey(arr, key, s, m - 1);
    }
}
