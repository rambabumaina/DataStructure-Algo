package geeksforgeeks.amazon.matrix;

public class PrintMatrixDiagonalPattern {
    //1,2,5,9,3,4,7,10,13,14,11,8,12,15,16
    public static void main(String[] args) {

                int mat[][] = {{1, 2,   3,  4,  40},
                               {5, 6,   7,  8,  80},
                               {9, 10,  11 ,12, 90},
                               {13,14,  15, 16 ,100},
                               {130,140,150,160,200}};

//        int mat[][] = {{1, 2, 3,4},
//                       {5, 6, 7,8},
//                       {9, 10,11 ,12},
//                       {13,14,15, 16 }};

//        int mat[][] = {{1, 2, 3},
//                       {5, 6, 7},
//                       {9, 10,11}};

//        int mat[][] = {{1, 2},
//                       {5, 6}};

        matrixDiagonally(mat);
    }

    public static int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] result = new int[n*n];
//        System.out.println(mat[0][0]);
        int r =0;
        result[r++] = mat[0][0];

        boolean isup = false;
        int i = 0, j = 1;


        for (int k = 2; k <= n; k++) {
            for (int l = 1; l <= k; l++) {
                if (!isup) {
//                    System.out.println(mat[i++][j--]);
                    result[r++] = mat[i++][j--];
                } else {
//                    System.out.println(mat[i--][j++]);
                    result[r++] = mat[i--][j++];
                }
            }
            isup = !isup;
            i = i == -1 ? 0 : i;
            j = j == -1 ? 0 : j;
        }

        if (!isup) {
            i = 1;
            j = n - 1;
        } else {
            i = n - 1;
            j = 1;
        }

        for (int k = n - 1; k >= 1; k--) {
            for (int l = 1; l <= k; l++) {
                if (!isup) {
//                    System.out.println(mat[i++][j--]);
                    result[r++] = mat[i++][j--];
                } else {
//                    System.out.println(mat[i--][j++]);
                    result[r++] = mat[i--][j++];
                }
            }

            isup = !isup;
            i = i == n ? n - 1 : i + 2;
            j = j == n ? n - 1 : j + 2;
        }
        return result;
    }
}
