package recursion;

public class PermutationsOfString {
    public static void main(String[] args) {
        String str = "abc";
        solve_print(str, "");

        System.out.println("Count : " + solve_count("abc", ""));
    }

    private static void solve_print(String str, String ans) {

        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);

        for (int i = 0; i <= ans.length() ; i++) {

            // _a_/bc ====> ba/c, ab/c
            // _b_a_/c =====> cba, bca, bac
            String first = ans.substring(0,i);
            String second = ans.substring(i);
            solve_print(str.substring(1), first+ch+second);
        }
    }


    private static int solve_count(String str, String ans) {

        if(str.isEmpty()){
            return 1;
        }

        int count =0;
        char ch = str.charAt(0);

        for (int i = 0; i <= ans.length() ; i++) {
            // _a_/bc ====> ba/c, ab/c
            // _b_a_/c =====> cba, bca, bac
            String first = ans.substring(0,i);
            String second = ans.substring(i);
            count = count + solve_count(str.substring(1), first+ch+second);
        }
        return count;
    }
}