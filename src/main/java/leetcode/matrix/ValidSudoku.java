package leetcode.matrix;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board =
                         {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '6', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

//  char[][]board= {{'5','3','.','.','7','.','.','.','.'}
//,{'6','.','.','1','9','5','.','.','.'}
//,{'.','9','8','.','.','.','.','6','.'}
//,{'8','.','.','.','6','.','.','.','3'}
//,{'4','.','.','8','.','3','.','.','1'}
//,{'7','.','.','.','2','.','.','.','6'}
//,{'.','6','.','.','.','.','2','8','.'}
//,{'.','.','.','4','1','9','.','.','5'}
//,{'.','.','.','.','8','.','.','7','9'}};


        System.out.println(isValidSudoku(board));
    }

    static boolean isValidSudoku(char[][] board) {

        boolean flag = true;

        for (int i =0 ; i < board.length ;i++){
            for (int j =0; j< board[0].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }

                if(!(isRowValid(board,i, j) && isColumnValid(board, i, j) && is3X3MatrixValid(board,i, j))){
                    return false;
                }
            }
        }

        return flag;
    }

    private static boolean isRowValid(char[][] board, int i , int j) {
        for (int k = 0 ; k < board.length ;k++){
            if( k == j){
                continue;
            }else {
                if(board[i][j] == board[i][k]){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isColumnValid(char[][] board, int i , int j) {
        for (int k = 0 ; k < board.length ;k++){
            if( k == i){
                continue;
            }else {
                if(board[i][j] == board[k][j]){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean is3X3MatrixValid(char[][] board, int row , int col) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if(startRow +i == row && startCol + j ==col){
                    continue;
                }
                if (board[startRow +i][startCol + j] == board[row][col]) {
                    return false;
                }
            }
        return true;
    }
}
