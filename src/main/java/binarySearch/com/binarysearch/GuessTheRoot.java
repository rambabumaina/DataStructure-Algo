package binarySearch.com.binarysearch;

//https://binarysearch.com/problems/Guess-the-Root
public class GuessTheRoot {
    public static void main(String[] args) {
        //n = 73029069
        int n = 73029069;
        System.out.println(solve(n));
    }

    static int solve(int n) {
        if(n < 1) return n;
        int low = 1, high = n/2 , result=0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int quotient = n / mid;

            result = quotient;
            if (mid == quotient) {
                result= quotient;break;
            }

           if (mid < quotient) {
                low = mid + 1;
            } else {
                result = Math.max(mid, result);
                high = mid - 1;
            }
        }
        return result;
    }
}
