package javaProblems.matrix;

public class MatrixAddDiagonal {
    public static void main(String[] args) {
        int Max[][] = {
                {7, 10, 8 , 9},
                {1, 0,  3 , 5},
                {0, 15, 4 , 3},
                {0, 15, 4 , 1},
        };

        int Sum_left = 0;
        int Sum_right = 0;

        for (int i = 0, j = 0; i < Max.length && j < Max.length; i++, j++) {
                Sum_left = Sum_left + Max[i][j];
        }

        for (int i = 0, j = Max[0].length-1; i < Max.length && j > 0; i++, j--) {
                Sum_right = Sum_right + Max[i][j];
        }

        System.out.println("Sum Left = " + Sum_left);
        System.out.println("Sum Left = " + Sum_right);
    }

}
