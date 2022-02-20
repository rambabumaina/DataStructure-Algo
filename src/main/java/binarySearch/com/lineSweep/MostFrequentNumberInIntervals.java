package binarySearch.com.lineSweep;

import java.util.Map;
import java.util.TreeMap;

//https://binarysearch.com/problems/Most-Frequent-Number-in-Intervals
/**
 *Logic : Which values came most on the intervals, if count same return minimum
 * 1) Storing in sorted order ->using tree map
 * 2) When start time add 1 in tree map
 * 3) When end time, then add one in end time and add -1 value to end time
 * 4) Read values from map and add them
 * 5) Maintain MAX variable
 */
public class MostFrequentNumberInIntervals {
    public static void main(String[] args) {
//        int [][] intervals = {
//                {1, 4},
//                {3, 5},
//                {6, 9},
//                {7, 9}
//        };

        int [][] intervals = {{2,2},{0,0}};

        System.out.println(solve(intervals));
    }

    static int solve(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
            treeMap.put(end + 1, treeMap.getOrDefault(end+1, 0)  - 1);
        }

        int MAX = 0, key =0, count = 0;

        System.out.println(treeMap);
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {

           count = entry.getValue();

            if(MAX < count){
                MAX = count;
                key = entry.getKey();
            }

        }
        return key;
    }
}
