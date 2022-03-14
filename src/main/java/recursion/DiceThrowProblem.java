package recursion;

public class DiceThrowProblem {
    public static void main(String[] args) {
        int target = 4;
        solvePrint(target, "");
        System.out.println("Count : " + solveCount(4, ""));

    }

    private static void solvePrint(int target, String ans) {

        if (target == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            solvePrint(target - i, ans + i);
        }
    }


    private static int solveCount(int target, String ans) {

        if (target == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= 6 && i <= target; i++) {
            count = count + solveCount(target - i, ans + i);
        }
        return count;
    }
}
