package binarySearch.com.binarysearch;

public class NumIsPerfectSquare {
    public static void main(String[] args) {
        int n = 3610000;
        System.out.println(solve(n));
    }

    static boolean solve(int n) {
        if (n <= 1) return true;

        int low = 1;
        int high = n / 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            //n/mid will handle the integer out of bound case,
            // because mid*mid will go out of range and it will rotate the values

            int quotient = n / mid;

            if (n % mid == 0 && quotient == mid) return true;


            if (mid < quotient)
                low = mid + 1;
            else {
                high = mid - 1;
            }
        }
        return false;
    }


    static boolean solve1(int n) {
        if (n <= 1) return true;

        int start = 1;
        int end = n / 2;

        while (start <= end) {
            int m = start + (end - start) / 2;
            if (m * m == n) return true;

            if (m * m < n)
                start = m + 1;
            else {
                end = m - 1;
            }
        }
        return false;
    }
}
