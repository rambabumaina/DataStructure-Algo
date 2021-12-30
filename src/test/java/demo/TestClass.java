package demo;

public class TestClass {
    public static void main(String[] args) {
        int A[] = {3,0,2,1,10,-1};
        maxIndex(A.length, A);
    }

    public static int maxIndex(int N, int[] A) {

        int MAX = Integer.MIN_VALUE, MAX_INDEX=-1;
        int MIN = Integer.MAX_VALUE, MIN_INDEX= -1;

        for (int i =0 ; i < A.length; i++){
            if(A[i] <= 3){
                if(A[i] < MIN){
                    MIN = A[i];
                    MIN_INDEX = i;
                }
            }
        }

        for (int i =0 ; i < A.length; i++){
            if(A[i] <= 3){
                if(A[i] > MAX){
                    MAX = A[i];
                    MAX_INDEX = i;
                }
            }
        }

        return 0;
    }
}
