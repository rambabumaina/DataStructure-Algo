package demo;

import com.sun.javafx.fxml.builder.URLBuilder;

public class FindSubArray {
    public static void main(String[] args) {
//        int []arr = {7,1,2,4,6,5,3,8,9,10};
//
//        int max=0, start =0, end=0;
//
//        for (int i = 1 ; i < arr.length; i++){
//            if(arr[i-1] >= arr[i]){
//
//            }
//        }


        String str = "khokharnikunj";
        char [] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
           for (int j =1 ; j < ch.length ; j++){
               if(ch[i] > ch[j] ){
                   char temp = ch[i];
                   ch[i] = ch[j];
                   ch[j] = temp;
               }
           }
        }

        for(char c : ch){
            System.out.print(c + " ");
        }


    }



}
