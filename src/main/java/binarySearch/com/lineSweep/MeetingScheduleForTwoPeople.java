package binarySearch.com.lineSweep;

import java.util.Arrays;

/**
 * Logic : Considering given free times are in sorted order
 * 1. Run two pointers like merge sort check the overlap times
 * 2) Max of start times: and MIN of end times for both persons
 * 3) run loop and check if e
 */
public class MeetingScheduleForTwoPeople {

    public static void main(String[] args) {
//        int[][] a = {{1, 2}, {3, 7}, {8, 100}};
//         int[][] b = {{0, 1}, {3, 8}};
//        int duration = 4;

//        int [][] a = {};
//        int [][] b = {{2, 3}};
//        int duration = 2;

        int[][] a = {{3, 9}};
        int[][] b = {{1, 2}};
        int duration = 5;

        Arrays.stream(solve(a, b, duration)).forEach(System.out::println);
    }

    static int[] solve(int[][] a, int[][] b, int duration) {
        int[] result;
        if (a.length == 0 || b.length == 0) {
            return new int[0];
        }

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int a_start = a[i][0];
            int a_end = a[i][1];

            int b_start = b[j][0];
            int b_end = b[j][1];

            int start_overLap = Math.max(a_start, b_start);
            int end_overLap = Math.min(a_end, b_end);

            if (end_overLap - start_overLap >= duration) {
                result = new int[2];
                result[0] = start_overLap;
                result[1] = start_overLap + duration;
                return result;
            } else if (a_end < b_end) {
                i++;
            } else {
                j++;
            }
        }

        return new int[0];
    }
}
