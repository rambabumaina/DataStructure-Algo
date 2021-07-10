package geeksforgeeks.mustdo.array;

public class MissingNumberInArray {
    public static void main(String[] args) {
        int A[] = {1, 2, 3, 5};
//        int A[] = {1,2,3,4,5,6,7,8,10};


        System.out.println(MissingNumber(A, A.length));
    }

    //Make sure loop should run less than n-1 times
    static int MissingNumber(int array[], int n) {
        int formula = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            sum += array[i];
        }

        return formula - sum;
    }
}
