package geeksforgeeks.mustdo.math;

public class FindFirstSetBit {
    public static void main(String[] args) {

        int N = 18;

//        int c =0;
//        while (N > 0){
//            if((N & 1) !=0){
//                c++;
//            }
//            N =  N >> 1;
//        }
//
//        System.out.println(c);

        System.out.println(5 | 7);

//        System.out.println(getFirstSetBit(N));
    }

    public static int getFirstSetBit(int N) {
//        int x = 1, count = 1;
//        while ((n & x) == 0) {
//            x = x << 1;
//            count++;
//        }
//
//        return count;

        int c =1;
        while (N > 0){
            if((N & 1) !=0){
                break;
            }
            c++;
            N =  N >> 1;
        }
       return c;
    }
}
