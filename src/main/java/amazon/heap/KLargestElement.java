package amazon.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1
public class KLargestElement {
    public static void main(String[] args) {

        int[] arr = {100, 23, 12, 9, 30, 200, 50};
        int k = 3;
//        ArrayList<Integer> list = kLargestUsingPriority(arr, arr.length, k);

        kLargestUsingMinHeap(arr, arr.length, k);
    }



    private static void kLargestUsingMinHeap(int[] arr, int size, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
        }

        buildHeap(heap, k);

        for (int i = k; i < size; i++) {
            if (heap[0] < arr[i]) {
                heap[0] = arr[i];
                heapify(heap, 0, k);
            }
        }

    }

    private static void buildHeap(int[] arr, int size) {
        int index = (size / 2) - 1;

        for (int i = index; i >= 0; i--) {
            heapify(arr, i, size);
        }
    }


    private static void heapify(int[] arr, int index, int size) {
        int leftNode = index * 2 + 1;
        int rightNode = index * 2 + 2;

        int minIndex = index;

        if (leftNode < size && arr[minIndex] > arr[leftNode]) {
            minIndex = leftNode;
        }

        if (rightNode < size && arr[minIndex] > arr[rightNode]) {
            minIndex = rightNode;
        }

        if (minIndex != index) {
            int temp = arr[minIndex];
            arr[minIndex] = arr[index];
            arr[index] = temp;
            heapify(arr, minIndex, size);
        }
    }


    private static ArrayList<Integer> kLargestUsingPriority(int[] arr, int length, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i = 0; i < length; i++) {
            queue.offer(arr[i]);
        }

        int i = 0;
        while (i < k) {
            list.add(queue.poll());
            i++;
        }
        return list;
    }
}
