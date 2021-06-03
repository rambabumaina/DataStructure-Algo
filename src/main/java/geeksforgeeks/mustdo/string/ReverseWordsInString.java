package geeksforgeeks.mustdo.string;

//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "i.like.this.program.very.much";//much.very.program.this.like.i

        System.out.println("Out: " + reverseWords(str));
    }

    static String reverseWords(String S) {
        String[] strArray = S.split("\\.");
        String result = "";

        for (int i = strArray.length - 1; i >= 0; i--) {
            if (i != 0) {
                result = result + strArray[i] + ".";
            } else {
                result = result + strArray[i];
            }
        }
        return result;
    }
}