package javaProblems.matrix;

public class MatrixDemo {
    public static void main(String[] args) {
        int m1[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int m2[][] = {
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18}};
        addTwoMatrix(m1, m2, m1.length, m1[0].length);
        System.out.println();
        addDiagonalMatrix(m1, m2, m1.length, m1[0].length);
        System.out.println();
        addDiagonalMatrixDigonal(m1, m2, m1.length, m1[0].length);
    }

    //Add Two Matrix
    private static void addTwoMatrix(int M1[][], int M2[][], int row, int column) {
        int M3[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                M3[i][j] = M1[i][j] + M2[i][j];
            }

        }
        printMatrix(M3);
    }

    //Add Two Matrix
    private static void addDiagonalMatrix(int M1[][], int M2[][], int row, int column) {
        int M3[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == j)
                    M3[i][j] = M1[i][j] + M2[i][j];
            }
        }
        printMatrix(M3);
    }

    //Add Two Matrix
    private static void addDiagonalMatrixDigonal(int M1[][], int M2[][], int row, int column) {
        int M3[][] = new int[row][column];

        for (int i = 0, j = column - 1; i < row && j >= 0; i++, j--) {
            M3[i][j] = M1[i][j];
        }
        for (int i = 0; i < row; i++) {
            M3[i][i] = M1[i][i];
        }

        printMatrix(M3);
    }

    private static void printMatrix(int M3[][]) {
        for (int a[] : M3) {
            for (int x : a) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}