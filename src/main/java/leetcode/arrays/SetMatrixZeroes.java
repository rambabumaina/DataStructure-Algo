package leetcode.arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}};

        int[][] matrix = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        setZeroes(matrix);
    }

    static void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    //set row to zero
                    int row = 0;
                    while (row < matrix[i].length) {
                        if (matrix[i][row] != 0) {
                            matrix[i][row] = -1;
                        }
                        row++;
                    }

                    //set col to zero
                    int col = 0;
                    while (col < matrix.length) {
                        if (matrix[col][j] != 0) {
                            matrix[col][j] = -1;
                        }
                        col++;
                    }

                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
