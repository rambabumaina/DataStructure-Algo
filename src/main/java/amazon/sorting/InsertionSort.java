package amazon.sorting;

import java.util.Arrays;

//On2
public class InsertionSort {

    public static void main(String[] args) {
        int [] arr = {10,6,20,5,30,15,11};

        insertionSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));

    }

    public static void insertionSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            for (int j = i ; j> 0 ; j--){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }else{
                    break;
                }
            }
        }
    }

}
