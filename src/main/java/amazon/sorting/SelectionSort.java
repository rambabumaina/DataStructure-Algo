package amazon.sorting;

import java.util.Arrays;


//Pick first index and search with rest of the elements
public class SelectionSort {
    public static void main(String[] args) {

        int [] arr = {10,6,20,5,30,15,11};
        selectionSort(arr);
    }

    public static void selectionSort(int [] arr){

        for (int i = 0 ; i< arr.length ; i++){
            for (int j = i+1; j< arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("After sorting := ");
        Arrays.stream(arr).forEach(System.out::println);
    }
}