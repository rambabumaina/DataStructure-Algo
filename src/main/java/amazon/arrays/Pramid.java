package amazon.arrays;

import java.util.Arrays;

public class Pramid {

    public static void main(String[] args) {

        int[] A = {4, 3, 3, 4, 1, 2, 2, 3, 6, 5, 4, 5};

        Pramid p = new Pramid();
        System.out.println(p.solution(A));
    }

    public String solution(int[] A) {
        Arrays.sort(A);
        boolean result = true;

        int j =1;
        for(int i= 2; i <= 3; i++){
           result = result && compare(A, j,i);
           j= j+i;
        }

        for(int i= 3; i >= 2; i--){
            result = result && compare(A, j,i);
            j=j+i;
        }

        return result?"YES":"No";
    }

    private boolean compare(int[] A, int index, int count){
        int value = A[index];
        for(int i = index+1; i< index+count; i++){
            if(value != A[i]){
                return false;
            }
        }
        return true;
    }
}
