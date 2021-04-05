package amazon.string;

public class WordReversInString {
    public static void main(String[] args) {
        String str = "Hello! world, this is new .era";
        //olleH! dlrow, siht si wen .are

        System.out.println(getReverseString(str));
    }

    private static String getReverseString(String str) {

        String[] arr = str.split(" ");
        String result = " ";

        for (String s : arr) {
            result += reverseStr(s) + " ";
        }
        return result;
    }

    private static String reverseStr(String s) {
        String ss = "";
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while (j > i) {
            if (isSpecialChar(ch[j])) {
                j--;
            } else if (isSpecialChar(ch[i])) {
                i++;
            } else {
                char temp = ch[j];
                ch[j] = ch[i];
                ch[i] = temp;
                i++;
                j--;
            }
        }

        for (char c : ch) {
            ss += c;
        }
        return ss;
    }

    private static boolean isSpecialChar(char charAt) {
        switch (charAt) {
            case '!': {
                return true;
            }
            case '.': {
                return true;
            }
            case ',': {
                return true;
            }
        }
        return false;
    }
}
