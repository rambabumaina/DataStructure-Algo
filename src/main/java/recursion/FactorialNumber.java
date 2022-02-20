package recursion;

//5!=5*4*3*2*1=120
//Time o(n), space o(n)
public class FactorialNumber {
    public static void main(String[] args) {
        int n=5;
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if(n<=1) return 1;
        return n * factorial(n-1);
    }
}

//recursion tree
/**
 *  5 * factorial(4)=120
 *      4 * factorial(3)=24
 *          3 * factorial(2)=6
 *              2 * factorial(1)=2
 *                  1, return 1
 */
