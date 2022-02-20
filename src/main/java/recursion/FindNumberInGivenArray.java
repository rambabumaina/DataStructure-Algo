package recursion;


public class FindNumberInGivenArray {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int solve = solve(a, 0, a.length - 1, 1);
        System.out.println(solve);
    }

    private static int solve(int[] a, int low, int high, int k) {
        int mid = low + (high - low) / 2;

        if (low > high) {
            return -1;
        }

        if (a[mid] == k) {
            return mid;
        }

        if (a[mid] < k) {
            return solve(a, mid + 1, high, k);
        } else {
            return solve(a, low, mid - 1, k);
        }

    }
}