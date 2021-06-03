package geeksforgeeks.mustdo.heap;


import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/heap-sort/1
public class HeapSort {

    public static void main(String[] args) {
        int[] input = {841,527,506,486,743,876,445,276,879,706,885,672,677,727,474,286,594,347,953,432,977,137,130,247,789,515,570,287,205,538,709,398,417,215,884,512,91,681,140,322,740,26,346,417,105,821,55,700,168,9,484,498,498,614,745,288,481,316,927,38,206,636,788,975,203,24,487,646,57,628};

        System.out.println(input.length);
        HeapSort hs = new HeapSort();

        hs.heapSort(input, input.length);

        Arrays.stream(input).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    //Function to build a Heap from array.
    //o(n)
    void buildHeap(int arr[], int n) {

        int firsNonLeafNode = (n / 2) - 1;
        for (int i = firsNonLeafNode; i >= 0; i--) {
            heapify(arr, n, i);
        }

    }

    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i) {

        int leftLeafNode = (i * 2) + 1;
        int rightLeafNode = (i * 2) + 2;

        int minIndex = i;

        if (leftLeafNode < n &&  arr[minIndex] < arr[leftLeafNode])
            minIndex = leftLeafNode;


        if (rightLeafNode < n && arr[minIndex] < arr[rightLeafNode])
            minIndex = rightLeafNode;


        if (minIndex != i) {
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            heapify(arr, n, minIndex);
        }
    }

    //Function to sort an array using Heap Sort.
    // O(n-k)logn+0(1)
    public void heapSort(int[] arr, int n) {
        buildHeap(arr, arr.length);
        for (int i = n - 1; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, i, 0);
        }
    }
}