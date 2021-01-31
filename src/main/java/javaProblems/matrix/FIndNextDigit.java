package javaProblems.matrix;

import java.util.Arrays;

public class FIndNextDigit {

    public static void main(String[] args) {
        String num = "1572";  // 14235 13452
        System.out.println(nextGreaterNumber(num.toCharArray()));
    }

    private static String nextGreaterNumber(char[] number) {
        for (int i = number.length - 1; i > 0; i--) {
            if (number[i - 1] < number[i]) {

                int minIndex = getMinValue(number, i);

                char temp = number[i - 1];
                number[i - 1] = number[minIndex];
                number[minIndex] = temp;
                sortFunction(number, i);
                return new String(number);
            }
        }
        return "Not Possible";
    }

    private static int getMinValue(char[] number, int i){
        int min = Integer.MAX_VALUE;
        int minIndex =0;

        for (int j = i ; j<number.length;j++){
            if(number[j] > number[i-1] && min> number[j]){
                minIndex = j;
                min=number[j];
            }
        }
        return minIndex;
    }

    private static void sortFunction(char c[], int i) {
        Arrays.sort(c,i,c.length);
    }
}
