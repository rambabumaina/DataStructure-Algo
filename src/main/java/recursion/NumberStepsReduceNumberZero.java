package recursion;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberStepsReduceNumberZero {
    public static void main(String[] args) {
        int n = 8;
        System.out.println("Steps : " + numberOfSteps(n));
    }

    static int numberOfSteps(int num) {
        return helper(num, 0);
    }

    private static int helper(int num, int steps) {
        if(num == 0){
            return steps;
        }

        if(num %2 == 0){
            num = num/2;
        }else {
            num = num -1;
        }

        return helper(num, steps+1);
    }
}
