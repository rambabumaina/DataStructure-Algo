package sapient;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = {5, 10, 4, 8, 3, 9, 7};

        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();

//      mergeSort(arr, 0, arr.length - 1);
//        heapSort(arr);
        quickSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    private static void quickSort(int[] arr) {
        quickSortUtil(arr, 0, arr.length);
    }

    private static void quickSortUtil(int [] arr, int left , int right){
        if(right > left){
            int pivotIndex = partitionAlgo(arr, left, right);
            quickSortUtil(arr,left, pivotIndex);
            quickSortUtil(arr,pivotIndex+1, right);
        }
    }

    private static int partitionAlgo(int[] arr, int left, int right) {
        int j = 0;
        int i = j-1;

        int pivotElement = arr[right-1];

        while (j <= right - 1) {
            if (arr[j] <= pivotElement) {
                i++;
                swap(arr , i , j);
                j++;
            }else {
                j++;
            }
        }
        return i;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void heapSort(int[] arr) {
        buildHeap(arr, arr.length);

        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }


    public static void buildHeap(int[] arr, int size) {
        int firstNonLeafNode = (size / 2) - 1;

        for (int i = firstNonLeafNode; i >= 0; i--) {
            heapify(arr, i, size);
        }
    }

    private static void heapify(int[] arr, int index, int size) {

        int leftNode = index * 2 + 1;
        int rightNode = index * 2 + 2;
        int minIndex = index;

        if (leftNode < size && arr[minIndex] < arr[leftNode]) {
            minIndex = leftNode;
        }

        if (rightNode < size && arr[minIndex] < arr[rightNode]) {
            minIndex = rightNode;
        }

        if (minIndex != index) {
            swap(arr, minIndex, index);
            heapify(arr, minIndex, size);
        }

    }


    private static void mergeSort(int[] arr, int l, int h) {

        if (h > l) {
            int m = l + (h - l) / 2;

            mergeSort(arr, l, m - 1);
            mergeSort(arr, m + 1, h);

            merge(arr, l, m - 1, m + 1, h);
        }
    }

    private static void merge(int[] arr, int l1, int h1, int l2, int h2) {

        int[] brr = new int[h2 - l1 + 1];
        int i = l1;
        int j = l2;
        int k = 0;

        while (i <= h1 && j <= h2) {
            if (arr[i] < arr[j]) {
                brr[k++] = arr[i++];
            } else {
                brr[k++] = arr[j++];
            }
        }


        if (i == h1 + 1) {
            while (j <= h2) {
                brr[k++] = arr[j++];
            }
        } else {
            while (i <= h1) {
                brr[k++] = arr[i++];
            }
        }

        int l = 0;
        while (l < k) {
            arr[l1++] = brr[l++];
        }

    }
}



