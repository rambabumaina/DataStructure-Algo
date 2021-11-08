package leetcode.matrix;

import static geeksforgeeks.amazon.matrix.Rotate90Degree.transposeMatrix;

public class RotateImage {

    public static void main(String[] args) {

       int[][] matrix = {{5,1,9,11},
                         {2,4,8,10},
                         {13,3,6,7},
                         {15,14,12,16}};

       rotate(matrix);
    }

    static void rotate(int[][] matrix) {

        printMatrix(matrix);

        transposeMatrix(matrix);

        System.out.println();

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {

        for(int i =0 ; i < matrix.length; i++){
            for (int j =0 ; j < matrix[0].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
