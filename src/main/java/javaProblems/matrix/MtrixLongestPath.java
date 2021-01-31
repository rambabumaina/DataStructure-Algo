package javaProblems.matrix;

public class MtrixLongestPath {

    static int  maxSum=0;
    public static void main(String[] args) {
        int mat[][] = {
                { 7, 10,  8 },
                { 1,  0,  3 },
                { 0,  15, 4 },
                { 1,  0,  2 }
        };
        longestPath(mat);
        System.out.println(">>"+maxSum);

    }

    private static void longestPath(int mat[][]) {
        for (int i = 0; i < mat[0].length; i++) {
            longestPathUtil(mat, 0, i, mat.length, mat[0].length, 0,"");
        }
    }


    private static void longestPathUtil(int arr[][], int i, int j, int row, int column, int currentSum, String path) {
        if (i < 0 || i >= row || j < 0 || j >= column) {
            if (maxSum < currentSum){
                System.out.println("Path:"+ path);
                maxSum = currentSum;
                System.out.println("maxSum:"+maxSum);
                System.out.println("CurrentSum:"+currentSum);
            }
            return;
        }

        longestPathUtil(arr, i + 1, j - 1, row, column, currentSum + arr[i][j],path+"-->"+arr[i][j]);
        longestPathUtil(arr, i + 1, j, row, column, currentSum + arr[i][j],path+"-->"+arr[i][j]);
        longestPathUtil(arr, i + 1, j + 1, row, column, currentSum + arr[i][j],path+"-->"+arr[i][j]);
    }
}