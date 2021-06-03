package leetcode.math;

public class ReverseInteger {
    public static void main(String[] args) {
//        int x = 1534236469;
//          int x = 2147483647;
        int x = -2147483412;
//        int x = -123;



        System.out.println("x >" + x);

        int result = reverse(x);
        System.out.println("Result : " + result);
    }

    static int reverse(int x) {
        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }

        int sign = x > 0 ? 1 : -1;
        int num = Math.abs(x);
        int re = 0;
        while (num > 0) {
            int remind = num % 10;
            re = re * 10 + remind;
            num = num / 10;
        }
        re = re * sign;
        int maxInt = Integer.MAX_VALUE / 10;
        if (re > maxInt) {
            return 0;
        } else {
            return re;
        }
    }
}


