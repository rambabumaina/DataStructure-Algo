package geeksforgeeks.mustdo.array;

import java.util.Arrays;

//Logic merge sort wala
public class MinNumberOfPlatform {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Num Of Platform: " + findPlatform(arr, dep, arr.length));
    }

    public static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0, result = 1, platform = 1;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            } else {
                platform--;
                j++;
            }

            if (platform > result)
                result = platform;
        }

        return result;
    }
}
