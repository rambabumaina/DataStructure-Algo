package geeksforgeeks.mustdo.math;

import java.util.Arrays;

public class PalindromicPrime {

    public static void main(String[] args) {

        int start = 150;
        int end = 200;

        boolean[] result = new boolean[end - start];
        Arrays.fill(result, true);

        int count = 0;
        int i = start;
        if (i % 2 == 0) {
            i++;
        }

        for (; i <= end; i = i + 2) {
            if (isPrime(i) && isPalindrome(i)) {
                count++;
            }
        }
        System.out.println("Count : " + count);
    }

    private static boolean isPalindrome(int num) {
        int rev = 0, temp = num;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }

        return num == rev;
    }

    private static boolean isPrime(int num) {
        for (int j = 2; j < Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
