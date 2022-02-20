package recursion;

public class CountNumberOfZerosInANumber {
    public static int counter = 0;

    public static void main(String[] args) {
        int n = 3002;

        count(n);
        System.out.println("Zeros : " + counter);

        System.out.println("Zeros : "+ approach2(n,0));
    }

    private static void count(int n) {
        if (n % 10 == n) {
            return;
        }
        if (n % 10 == 0) {
            counter++;
        }
        count(n / 10);
    }

    private static int approach2(int n, int c) {
        if (n == 0) {
            return c;
        }

        if (n % 10 == 0) {
            return approach2(n / 10, c+1);
        }
        return approach2(n / 10, c);
    }
}
