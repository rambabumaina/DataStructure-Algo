package recursion;

//0,1,1,2,3,5
public class fibonacciNumber {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("fib :" + fibo(n));
    }

    //Time complexity o(n)2 and space complexity :o(n)2
    private static int fibo(int n) {
        // Base condition
        if (n < 2) {
            return n;
        }

        //Break big problem to smaller problem
        return fibo(n - 1) + fibo(n - 2);
    }
}
