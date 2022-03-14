package recursion;

/**
 * Here question can be anything
 */
public class SkipCharacters {

    public static void main(String[] args) {
        String str = "bccdsapplehjnb";

        System.out.println("Result :" + skip(str));
    }

    private static String skip(String str) {

        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("apple")){
            return skip(str.substring(5));
        }

        return str.charAt(0) + skip(str.substring(1));
    }

}
