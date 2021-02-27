package amazon.arrays;

import java.util.Arrays;

public class MoveAllZeroesEnd {
    public static void main(String[] args) {
        int Arr[] = { 3, 5, 0, 0, 4};
        Arrays.stream(Arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
        pushZerosToEnd(Arr, Arr.length);
        Arrays.stream(Arr).forEach(i -> System.out.print(i + " "));
    }

    static void pushZerosToEnd(int[] arr, int n) {

        int i = 0, j = 0;
        while(i< n){
            if(arr[i] == 0 ){
                i++;
            }else{
                swap(arr,i,j);
                j++;
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
