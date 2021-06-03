package geeksforgeeks.amazon.matrix;

//https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
public class Rotate90Degree {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3,    4},
//                {5, 6, 7,    8},
//                {9, 10, 11, 12},
//                {13,14, 15, 16}};
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(matrix);
        System.out.println();
        transposeMatrix(matrix);
        printMatrix(matrix);
        reverseMatrix(matrix);
        System.out.println();
        printMatrix(matrix);

    }

    //Print Matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0 ; i < matrix.length; i ++){
            for (int j = 0 ; j< matrix.length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Transpose Matrix
    public static void transposeMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    //Reverse Matrix
    public static void reverseMatrix(int matrix[][]){
        for (int i = 0 ; i <matrix.length; i++){
            for(int j =0 , k = matrix.length-1 ; j< k; j++, k--){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
    }


    //Print rotated Values
    static void rotateby90_print(int matrix[][], int n) {
        int[][] m = new int[n][n];
        for (int i = n - 1, x = 0; i >= 0; i--, x++) {
            for (int j = 0, y = 0; j < n; j++, y++) {
                m[x][y] = matrix[j][i];
            }
        }
        matrix = m;
        printMatrix(matrix);
    }


    // i=0,j=2
    // i=1,j=1
    static void rotateBy90_sameMatrix(int matrix[][], int n) {
        int v1 = 0;
        int v2 = 0;

        for (int i = 0, j = n - 1; i < n - 1 && j > 0; i++, j--) {
            System.out.println("i: " + i + ", j: " + j);
            int next_i = i;
            int next_j = 0;

            // 1 *******
            v1 = matrix[next_i][next_j]; //1 (0,0), ()
            v2 = matrix[0][j];         //3  (0,2) ,(1,1)
            matrix[next_i][next_j] = v2; //3
            v2 = v1;//1
            System.out.println(next_i + " " + next_j);
            // 2 ****************
            next_i = next_i + j;
            next_j = next_j + i;

            v1 = matrix[next_i][next_j];    //7  (2,0)
            matrix[next_i][next_j] = v2;//1
            v2 = v1; //7
            System.out.println(next_i + " " + next_j);
            // 3 ****************
            next_i = next_i - i;
            next_j = next_j + j;

            v1 = matrix[next_i][next_j];     //9 (2,2)
            matrix[next_i][next_j] = v2;//7
            v2 = v1;//9
            System.out.println(next_i + " " + next_j);
            // 4 *****************
            next_i = next_i - j;
            next_j = next_j - i;

            v1 = matrix[next_i][next_j]; //3
            matrix[next_i][next_j] = v2; //9
            System.out.println(next_i + " " + next_j);


            printMatrix(matrix);
        }
    }

}
