package demo;

public class Monkey {
    public static void main(String[] args) {
        distribute(17);
    }

    public static boolean distribute(int N) {
        if (N < 3) return false;

        int max = (int) Math.sqrt(N);
        for (int i = 2; i <= max; i++) {
            if (N % i == 0) return true;
        }
        return false;
    }
}
