package recursion;

//time O(n) , space o(n)
public class SumOfDigits {
    public static void main(String[] args) {
        int n = 505;//10
        System.out.println("sumOfDigits :" + sumOfDigits(n));
        System.out.println("productOfDigits :" + productOfDigits(n));
    }

    public static int sumOfDigits(int n) {
        if (n <= 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static int productOfDigits(int n) {
        if(n < 10){
            return n;
        }
        return (n % 10) * productOfDigits(n / 10);
    }
}

/* Recursion Tree
    2 + return sumOfDigits(134)
        4 + return sumOfDigits(13)
            3 + return sumOfDigits(1)
                1 + return sumOfDigits(0)
                    if(n <=0) return 0;
 */



