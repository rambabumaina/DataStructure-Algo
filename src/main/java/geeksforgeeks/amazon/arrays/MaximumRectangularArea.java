package geeksforgeeks.amazon.arrays;

//https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
public class MaximumRectangularArea {
    public static void main(String[] args) {
        long arr[] = {6, 2, 5, 4, 5, 1, 6};

        System.out.println(getMaxArea(arr, arr.length));
    }

    public static long getMaxArea(long[] hist, long n) {
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < hist.length; i++) {
            max = Math.max((getLeftCount(hist, i) + getRightCount(hist, i) + 1) * hist[i], max);
        }
        return max;
    }

    private static int getLeftCount(long[] arr, int i) {
        int j = i - 1;
        int counter = 0;
        while (j >= 0 && arr[j] > arr[i]) {
            counter++;
            j--;
        }
        return counter;
    }

    private static int getRightCount(long[] arr, int i) {
        int j = i + 1;
        int counter = 0;
        while (j < arr.length && arr[j] > arr[i]) {
            counter++;
            j++;
        }
        return counter;
    }
}
