package leetcode.string;

public class FindStringIsValid {

    public static void main(String[] args) {
        String str = "Orcle";
        System.out.println(findStringIsValid(str));
    }

   static boolean findStringIsValid(String str){
        char [] ch = str.toCharArray();
       return checkIfValid(ch);
    }

    private static boolean checkIfValid(char[] ch) {
        if (validate(ch, 0, 'a', 'z')
                || (ch[0] >= 'A' && ch[0] <= 'Z' && validate(ch, 1, 'a', 'z'))
                || validate(ch, 0, 'A', 'Z')
        ) {
            return true;
        } else {
            return false;
        }
    }

    static boolean validate(char[] c, int i, char lower, char high) {
        while (i < c.length) {
            if (c[i] >= lower && c[i] <= high) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
