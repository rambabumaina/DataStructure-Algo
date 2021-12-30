package dp;

public class CountWaysToClaimStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    static int climbStairs(int n) {
        int[] arr = new int[45];
        int count = 2;
        arr[0] = 1;
        arr[1] = 2;

        return climbStairs(n, count, arr);
    }

    public static int climbStairs(int n, int count, int[] arr) {
        if (arr[n - 1] != 0) {
            return arr[n - 1];
        }

        for (int i = count; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
