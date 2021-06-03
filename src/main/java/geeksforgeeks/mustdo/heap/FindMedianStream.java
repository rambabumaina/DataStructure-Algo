package geeksforgeeks.mustdo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
//https://www.youtube.com/watch?v=EcNbRjEcb14
public class FindMedianStream {
    public static void main(String[] args) {
        int[] input = {5, 15, 1, 3};
//        int[] input = {5, 15, 10, 20, 3};

//    findMedian(input);

        findMedianUsingHeap(input);
    }

    //Approach : Median using heap sort
    //
    public static void findMedianUsingHeap(int[] input) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < input.length; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() > input[i]) {
                maxHeap.add(input[i]);
            } else {
                minHeap.add(input[i]);
            }

            // if max heap has more then 2 element then remove from max heap and add it to the min heap
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.remove());
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.remove());
            }

            // if both heap has same element then take both heap top value and calculate
            if (maxHeap.size() == minHeap.size()) {
                double median = (maxHeap.peek() + minHeap.peek()) / 2;
                System.out.println(median);
            } else {
                // if max heap has more element then return maxheap top
                if (maxHeap.size() > minHeap.size()) {
                    System.out.println(maxHeap.peek());
                } else {
                    System.out.println(minHeap.peek());
                }
            }
        }
    }



    //Approach : Median using insertion sort
    public static void findMedian(int[] input) {
        int[] resultArray = new int[input.length];
        int k = 0;
        resultArray[k++] = input[0];

        for (int j = 1; j < input.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i + 1];
                    input[i + 1] = input[i];
                    input[i] = temp;
                } else {
                    break;
                }
            }
            int m = getTheMedian(input, j + 1);
            resultArray[k++] = m;
        }

        Arrays.stream(resultArray).forEach(i -> {
            System.out.print(i + " ");
        });
    }

    private static int getTheMedian(int[] input, int j) {
        int mid = j / 2;
        if (j % 2 != 0) {
            return input[mid];
        } else {
            return (input[mid - 1] + input[mid]) / 2;
        }
    }
}
