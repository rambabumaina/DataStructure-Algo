package demo;

import java.util.Arrays;


public class Test {

    public static void main(String[] args) {
      int [] arr = {1,2,3,4,5,6,7};

      int i =0;
      int j = arr.length-1;
      while(i< j){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
          i++;
          j--;
      }

      Arrays.stream(arr).forEach(System.out::println);
    }
}

