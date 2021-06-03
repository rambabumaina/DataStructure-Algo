package leetcode.string;

public class RomanToInteger {
    public static void main(String[] args) {
//        String str = "III";
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }

    static int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'I': {
                    sum += sum >= 5 ? -1 : 1;
                    break;
                }
                case 'V': {
                    sum += 5;
                    break;
                }
                case 'X': {
                    sum += sum >= 50 ? -10 : 10;
                    break;
                }
                case 'L': {
                    sum += 50;
                    break;
                }
                case 'C': {
                    sum += sum >= 500 ? -100 : 100;
                    break;
                }
                case 'D': {
                    sum += 500;
                    break;
                }
                case 'M': {
                    sum += 1000;
                    break;
                }
            }
        }
        return sum;
    }
}
