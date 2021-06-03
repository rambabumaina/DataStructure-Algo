//package geeksforgeeks.test;
//
//public class MergeSort {
//    public static void main(String[] args) {
////        int[] arr = {2, 1, 6, 5, 7, 0, 9, 8, 3};
////
////        mergeSort(arr, 0, arr.length - 1);
////        Arrays.stream(arr).forEach(d -> System.out.print(d + ","));
//        for(int i =0 ; i < 10; i ++){
//            System.out.print(fib(i)+ " ");
//        }
//
//    }
//
//    public static int fib(int n){
////        if (n <= 1) {
////            return n;
////        }
////
////        return fib(n - 1) + fib(n - 2);
//
//        int [] f = new int[n+2];
//        f[0] =0;
//        f[1] =1;
//
//        for (int i = 2 ; i < n ; i++){
//            f[i] = f[i-2]+ f[i -1];
//        }
//        return f[i];
//
//    }
//
//    private static void mergeSort(int[] arr, int low, int high) {
//        if (low < high) {
//            int mid = low + (high - low) / 2;
//            mergeSort(arr, low, mid);
//            mergeSort(arr, mid + 1, high);
//            merge(arr, low, mid, high);
//        }
//    }
//
//    private static void merge(int[] arr, int low, int mid, int high) {
//
//        //size of array
//        int n1 = mid - low + 1;
//        int n2 = high - mid;
//
//        //temp arr
//        int[] l1 = new int[n1];
//        int[] l2 = new int[n2];
//
//        for (int i = 0; i < n1; i++) {
//            l1[i] = arr[low + i];
//        }
//        for (int j = 0; j < n2; j++) {
//            l2[j] = arr[mid + 1 + j];
//        }
//
//        int i = 0;
//        int j = 0;
//        int k = low;
//
//        while (i < n1 && j < n2) {
//            if (l1[i] <= l2[j]) {
//                arr[k++] = l1[i++];
//            } else {
//                arr[k++] = l2[j++];
//            }
//        }
//
//        while (i < n1) {
//            arr[k++] = l1[i++];
//        }
//
//        while (j < n2) {
//            arr[k++] = l2[j++];
//        }
//    }
//}
