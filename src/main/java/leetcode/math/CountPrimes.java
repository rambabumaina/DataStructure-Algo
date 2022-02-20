package leetcode.math;

public class CountPrimes {
    public static void main(String[] args) {
        countPrimes(10);
    }

    static int countPrimes(int n) {

        if(n < 2) return 0;
        int counter=1;

        for(int i = 3 ; i < n ; i++) {
                if(isPrime(i)){
                    counter++;
                }
            }
        return counter;
        }

        static boolean isPrime(int n){
            for (int i = 2; i*i <= n; i++) {
                if ( n % i ==0){
                    return false;
                }
        }
            return true;
    }

}
