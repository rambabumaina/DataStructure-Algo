package binarySearch.com.lineSweep;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class MovieTheaters {
    public static void main(String[] args) {
        int[][] intervals = {{30, 75}, {0, 50}, {60, 150}};
        System.out.println(solve(intervals));
    }

    static int solve(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

           map.put(start, map.getOrDefault(start,0)+1);
           map.put(end, map.getOrDefault(end,0)-1);
        }

        int sum = 0;
        int MAX = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();

            if(MAX < sum){
                MAX =sum;
            }
        }

        return MAX;
    }
}