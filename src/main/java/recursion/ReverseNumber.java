package recursion;

//For N digits: 12345, time o(n) => space also O(n)
public class ReverseNumber {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Reverse : " + reverseNumber(n));
    }

    public static int reverseNumber(int n) {
        //total number of digits
        int digits = (int) Math.log10(n) + 1;
        System.out.println("Digits :" + digits);
        return helper(n, digits);
    }

    private static int helper(int n, int i) {
        if (n % 10 == n) {
            return n;
        }
        int d = n / 10;
        int r = n % 10;
        return r * (int) Math.pow(10, i - 1) + helper(d, i - 1);
    }
}
