package amazon.arrays;

import java.util.Arrays;

public class SmallestPositiveInteger {
    public static void main(String[] args) {
        int[] A = {-1,-3};//1,1,2,3,4,6
        System.out.println("Arr :" + solution(A));
    }

    static int solution(int[] A) {
        Arrays.sort(A);

        if(A[A.length-1] <=0){
            return 1;
        }

        if(A[0] !=1){
            return 1;
        }

        int i =1;
        while (i < A.length){

            if(A[i-1] == A[i] || A[i-1] == A[i]-1  ){
               i++;
               continue;
            }
           break;
        }

        if(i !=A.length){
            return A[i]-1;
        }else{
            return A[A.length-1]+1;
        }
    }
}
