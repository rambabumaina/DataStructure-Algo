package leetcode.string;


public class RecursiveReverse {

    public static void main(String[] args) {
        String str = "rambabu";

//        char [] ch = str.toCharArray();
        String s = "r";

//        System.out.println(s.substring(1));

        System.out.println( reverse(str) );

    }

    private static String reverse(String str) {

        if(str.equals("")){
            return "";
        }

        char ch  = str.charAt(0);
        return reverse(str.substring(1))+ch;
    }
}
