package amazon.arrays;

public class MergeKSortedArrayUsingHeap {

    public static void main(String[] args) {
        int arr[][] = {

                {1, 2, 3, 4},//(0,1)
                {2, 2, 3, 4},
                {5, 5, 6, 6},
                {7, 8, 9, 9}
        };

        mergeKArraysUsingPriorityQueue(arr, arr.length);

    }

    private static void mergeKArraysUsingPriorityQueue(int[][] arr, int length) {

    }

    static class Node {
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}