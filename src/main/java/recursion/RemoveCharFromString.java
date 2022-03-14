package recursion;

public class RemoveCharFromString {
    public static void main(String[] args) {
        String str = "baccad";
        //Approach1
        System.out.println("Result : " + approach1(str, 0, ""));

        //Approach1
        System.out.println("Result : " + approach2(str, 0));

        //Approach3
        System.out.println("Result : " + approach3(str));
    }

    //1. Pass answer variable in the function body
    private static String approach1(String str, int index, String ans) {
        if (index == str.length()) {
            return ans;
        }

        if (str.charAt(index) != 'a') {
            ans += str.charAt(index);
        }

        return approach1(str, index + 1, ans);
    }


    private static String approach2(String str, int index) {
        String ans = "";

        if (index == str.length()) {
            return ans;
        }

        if (str.charAt(index) != 'a') {
            ans += str.charAt(index);
        }

        String rAns = approach2(str, index + 1);
        if (!ans.isEmpty()) {
            return ans + rAns;
        }
        return rAns;
    }

    //Using sub String
    private static String approach3(String str) {

        if (str.isEmpty()) {
            return "";
        }

        char ch = str.charAt(0);

        if (ch == 'a') {
            return approach3(str.substring(1));
        }
        return ch + approach3(str.substring(1));
    }
}
