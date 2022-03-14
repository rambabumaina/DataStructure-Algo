package recursion;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class OldPhonePad {
    public static void main(String[] args) {

        String digit = "12";
        solve(digit, "");
    }

    //1=>abc, 2=>def,3=>ghi,4=>klm
    //Range Formula =>From [{(digit-1)*3}  To {digit*3} ] =>(1-1)*3
    private static void solve(String digit, String ans) {
        
        if (digit.isEmpty()){
            System.out.println(ans);
            return;
        }
        
        int d = digit.charAt(0) -'0'; //This will convert '2' to 2 in integer

        for (int i = (d-1)*3; i < d*3; i++) {

            //Add number 'a' to every
            char ch = (char)(i+'a');
            solve(digit.substring(1), ans+ch);
        }
    }


}
