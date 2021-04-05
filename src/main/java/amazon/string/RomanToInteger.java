package amazon.string;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
//        System.out.println(convert(s));
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int result = 0;
        for (int i = cs.length - 1; i > -1; i--) {
            switch (cs[i]) {
                case 'I':
                    result += (result >= 5 ? -1 : 1);
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += (result >= 50 ? -10 : 10);
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += (result >= 500 ? -100 : 100);
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
