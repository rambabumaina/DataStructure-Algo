package geeksforgeeks.microsoft.arrays;

public class Maximum_Diff_Bw_2_elem {
    public static void main(String[] args) {
        int [] arr = {2, 3, 10, 6, 4, 8, 1};

        System.out.println(maxDiff(arr, arr.length));

        System.out.println(maxDiff_efficient(arr, arr.length));
    }


    //On^2
    static int maxDiff(int[] arr, int n) {
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n) {
                if ((arr[j] - arr[i]) > maxDiff) {
                    maxDiff = arr[j] - arr[i];
                }
                j++;
            }
        }
        return maxDiff;
    }

    //{1, 2, 90, 10, 110}
    static int maxDiff_efficient(int[] arr, int n) {

        int maxDiff = arr[1] - arr[0];
        int minEle = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - minEle > maxDiff) {
                maxDiff = arr[i] - minEle;
            }
            if (arr[i] < minEle) {
                minEle = arr[i];
            }
        }
        return maxDiff;
    }
}
