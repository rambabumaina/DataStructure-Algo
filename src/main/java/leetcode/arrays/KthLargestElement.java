package leetcode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
       int [] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(KthLargest(nums, k));
    }


    public static int KthLargest(int [] nums, int k){

        int[] heapArray = new int[k];
        int i = 0;
        while (i < k) {
            heapArray[i] = nums[i];
            i++;
        }
        buildHeap(heapArray,heapArray.length);

        Arrays.stream(heapArray).forEach(j -> System.out.print(j + " "));
        System.out.println();

        for (int j = k ; j < nums.length ; j++ ){
            if(heapArray[0] < nums[j]) {
                heapArray[0] = nums[j];
                heapify(heapArray, 0, heapArray.length);
            }
        }

        Arrays.stream(heapArray).forEach(j -> System.out.print(j + " "));
        System.out.println();

        return heapArray[0];
    }

    private static void buildHeap(int[] arr, int length) {
        int firstNonLeafElement = (arr.length / 2) - 1;

        for (int i = firstNonLeafElement; i >= 0; i--) {
            heapify(arr,i, arr.length);
        }
    }

    private static void heapify(int[] arr, int index, int size) {
        int leftNode = (index * 2) + 1;
        int rightNOde = (index * 2) + 2;

        int minIndex = index;

        if (leftNode < size && arr[leftNode] < arr[minIndex]) {
            minIndex = leftNode;
        }

        if (rightNOde < size && arr[rightNOde] < arr[minIndex]) {
            minIndex = rightNOde;
        }

        if (minIndex != index) {
            int temp = arr[minIndex];
            arr[minIndex] = arr[index];
            arr[index] =temp;
            heapify(arr, minIndex, size);
        }
    }


    public static int bySort(int [] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length -k];
    }

    public static int UsingPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int a : nums) {
            queue.add(a);
        }
        int i = 1;
        while (!queue.isEmpty() && i < k) {
            queue.poll();
            i++;
        }
        return queue.poll();
    }
}
