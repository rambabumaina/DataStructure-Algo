package geeksforgeeks.mustdo.array;

import java.util.Arrays;

public class NumberOfPairs {
    public static void main(String[] args) {

        int X[] = {2, 3, 4, 5};
        int Y[] = {1, 2, 3};

//        int X[] = {2, 3, 4, 5};
//        int Y[] = {2, 3, 4,6,9,12,20,50};

//        System.out.println(FindELement(Y,0, Y.length-1,1 ));


        System.out.println(countPairs(X, Y, X.length, Y.length));

//        System.out.println(countPairsUtil(Y,0 , Y.length-1, 50));
    }

    static long countPairs(int x[], int y[], int M, int N) {
        Arrays.sort(y);
        int finalCount = 0;


        boolean find1 = FindELement(y, 0, N - 1, 1) != -1;

        System.out.println(find1);

        for (int i = 0; i < M; i++) {
            if (x[i] == 1) {
                continue;
            }

            int index = countPairsUtil(y, 0, N - 1, x[i]);

            if (index != -1) {
                finalCount = finalCount + (N - index);
            }
            finalCount = finalCount + (find1 ? 1 : 0);

        }

        return finalCount;
    }

    private static int FindELement(int[] arr, int low, int high, int key) {
        if (high >= low) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                return FindELement(arr, low, mid - 1, key);
            } else {
                return FindELement(arr, mid + 1, high, key);
            }
        }
        return -1;
    }

    private static int countPairsUtil(int[] y, int low, int high, int key) {
        if (high > low) {

            int mid = low + (high - low) / 2;

            if (mid - 1 >= low && (y[mid] > key && y[mid - 1] <= key)) {
                return mid;
            }

            if (mid + 1 <= high && (y[mid + 1] > key && y[mid] < key)) {
                return mid + 1;
            }

            if (y[mid] > key) {
                return countPairsUtil(y, low, mid - 1, key);
            } else {
                return countPairsUtil(y, mid + 1, high, key);
            }
        } else if (low == high && y[low] > key) {
            return low;
        }
        return -1;
    }


    public static void pairCount(int[] X, int[] Y) {
        int count = 0;
        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < Y.length; j++) {
                double n1 = Math.pow(X[i], Y[j]);
                double n2 = Math.pow(Y[j], X[i]);

                if (n1 > n2) count++;
            }
        }

        System.out.println("Count : " + count);
    }

}
