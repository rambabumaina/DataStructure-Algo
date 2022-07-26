package geeksforgeeks.amazon.sorting;

import java.util.Arrays;

// O(nLogn)
public class HeapSort {

    public static void main(String[] args) {
//        int[] arr = {20, 50, 10, 25, 5, 15};
        int arr[] = {12, 5, 20,40,787, 1, 23};
         heapSort(arr);
    }

    public static void heapSort(int[] arr){
        buildHeap(arr, arr.length);

        for (int i = arr.length-1 ; i> 0 ;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

        Arrays.stream(arr).forEach(s-> System.out.print(s + " "));
    }

    public static void buildHeap(int[] arr, int size){
        int index = (size/2)-1;
        for (int i = index ; i>=0; i-- ){
            heapify(arr, i, size);
        }
    }

    //Heap should follow Complete binary tree or almost complete binary tree properties
    //Find a root node and compare left and right child should be less than(min heap)/greater than(maxheap) if not swap
    public static void heapify(int[] arr, int index, int size){

        int leftChild = index*2+1;
        int rightChild = index*2+2;

        int minIndex=index;

        if(leftChild < size && arr[minIndex] < arr[leftChild]){
            minIndex = leftChild;
        }

        if(rightChild < size && arr[minIndex] < arr[rightChild]){
            minIndex = rightChild;
        }

        if(minIndex != index){
            int temp = arr[minIndex];
            arr[minIndex] = arr[index];
            arr[index] = temp;
            heapify(arr,minIndex, size);
        }
    }
}
