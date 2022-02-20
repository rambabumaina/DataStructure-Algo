package recursion;

public class PrintPattern {
    public static void main(String[] args) {
        int r = 4;
        int c = 0;
//        printPattern(r, c);
        printPattern2(r, c);
    }
    /*
        * * * *
        * * *
        * *
        *
     */
    private static void printPattern(int r, int c) {
        if (r == 0) {
            return;
        }

        if(r > c){
            System.out.print("*" + " ");
           printPattern(r, c+1);
        }else {
            System.out.println();
            printPattern(r-1, 0);
        }
    }

    /*

         *
         * *
         * * *
         * * * *

     */
    private static void printPattern2(int r, int c) {
        if (r == 0) {
            return;
        }

        if(r > c){
            printPattern2(r, c+1);
            System.out.print("*" + " ");
        }else {
            printPattern2(r-1, 0);
            System.out.println();
        }
    }
}
