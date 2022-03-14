package backtracking;

import java.util.Enumeration;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if (solve(board)) {
            displayBoard(board);
        } else {
            System.out.println("Can't solve sudoku....");
        }
    }


    private static void displayBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] board) {

        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                }
            }

            //If you found some empty element in row , then break
            if (!emptyLeft) {
                break;
            }
        }

        if (emptyLeft) {
            return true;
            //sudoku is solved
        }

        //backtrack
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;

                if (solve(board)) {
                    //found answer
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check if the number is in the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][col] == num) {
                return false;
            }
        }

        // Check if the number is in the col
        for (int[] nums : board) {
            if (nums[col] == num) {
                return false;
            }
        }

        int sqroot = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqroot;
        int colStart = col - col % sqroot;

        for (int r = rowStart; r < rowStart + sqroot; r++) {
            for (int c = colStart; c < colStart + sqroot; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
