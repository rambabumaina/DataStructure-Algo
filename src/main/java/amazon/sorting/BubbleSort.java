package amazon.sorting;

import java.util.Arrays;

//Pick adjacent element and swap if they are not in order
public class BubbleSort {
    public static void main(String[] args) {

        int [] arr = {10,6,20,5,30,15,11};

        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        bubbleSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    //(On2)
    public static void bubbleSort(int[] arr){
        for(int i = arr.length ; i > 0 ; i --){
            boolean flag = false;

           for(int j = 0; j < i-1 ; j++){

               if(arr[j] > arr[j+1]){
                   int temp = arr[j+1];
                   arr[j+1] = arr[j];
                   arr[j] = temp;
                   flag = true;
               }
           }

           if(!flag){
              break;
           }
        }
    }
}
