package geeksforgeeks.amazon.matrix;

import java.util.Arrays;

public class FindSumOfElementsExceptGivenRowAndColumn {
    public static void main(String[] args) {
        int mat[][] = {{1, 1, 2},
                       {3, 4, 6},
                       {5, 3, 2}};

        int remove[][] = {
                {0, 0},
                {1, 1},
                {0, 1}};

        int[] result = matrixSum(mat, remove, mat.length);
        Arrays.stream(result).forEach(s -> System.out.println(s));
        System.out.println();
        matrixSum(mat, remove);
    }

    //O(n)^2
    private static void matrixSum(int[][] mat, int[][] exclude) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sum += mat[i][j];
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            int r = exclude[i][0];
            int c = exclude[i][1];
            System.out.println(sum - row[r] - col[c] + mat[r][c]);
        }
    }


    //O(N^3)
    private static int[] matrixSum(int[][] mat, int[][] exclude, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int row = exclude[i][0];
            int column = exclude[i][1];
            int result = calculateSum(mat, n, row, column);
            arr[i] = result;
        }
        return arr;
    }

    private static int calculateSum(int[][] mat, int n, int row, int column) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (row == i) {
                    break;
                }
                if (column == j) {
                    continue;
                }
                sum += mat[i][j];
            }
        }
        return sum;
    }
}
