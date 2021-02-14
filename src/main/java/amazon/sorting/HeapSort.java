package amazon.sorting;

import java.util.Arrays;

// O(nLogn)
public class HeapSort {

    public static void main(String[] args) {
        int arr[]= {7,5,15,3,10,6,4,2};

         heapSort(arr);
//         Arrays.stream(arr).forEach(System.out::println);
    }

    public static void heapSort(int[] arr){

        buildHeap(arr, arr.length);

        for (int i = arr.length ; i> 0 ;i--){
            int temp = arr[0];
            arr[0] = arr[i-1];
            arr[i-1] = temp;
            heapify(arr, 0, i-1);
        }

        Arrays.stream(arr).forEach(s-> System.out.print(s + " "));
    }

    public static void buildHeap(int[] arr, int size){
        int index = (size/2)-1;
        for (int i = index ; i>=0; i-- ){
            heapify(arr, i, size);
        }
    }

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
