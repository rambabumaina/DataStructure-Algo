package backtracking;


public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nKnights(board, 0, 0, n);
    }

    private static void nKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            displayBoard(board);
            System.out.println();
            return;
        }

        // row and column goes out of bound then return it
        if(row ==board.length-1 && col == board.length ){
            return;
        }

        //Check every row , once col reach at the end increase row and reset column
        if (col == board.length) {
            nKnights(board, row + 1, 0, knights);
            return;
        }

        //Place it in every row and column, check if it is safe
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            nKnights(board, row, col + 1, knights - 1);
            //Backtracking
            board[row][col] = false;
        }

        // IF not safe we will have to move ahead
        nKnights(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        if (isValid(board, row-2, col-1)){
            if (board[row-2][col-1]){
                return false;
            }
        }

        if (isValid(board, row-1, col-2)){
            if (board[row-1][col-2]){
                return false;
            }
        }


        if (isValid(board, row-2, col+1)){
            if (board[row-2][col+1]){
                return false;
            }
        }


        if (isValid(board, row-1, col+2)){
            if (board[row-1][col+2]){
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if(row>=0 && row < board.length && col >=0 && col < board.length){
            return true;
        }
        return false;
    }

    private static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print(" K ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }
}
