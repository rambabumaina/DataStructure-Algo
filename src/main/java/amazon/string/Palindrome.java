package amazon.string;

import javax.sound.midi.Soundbank;

public class Palindrome {
    public static void main(String[] args) {
//        String str = "levels";
        String str ="A car, a man, a maraca";

        String replace = str.replace(" ", "").replace(",","");
        System.out.println("Palindrome : " + isPalindrome(replace.toLowerCase()));
    }

    static boolean isPalindrome(String str ){
        System.out.print(str);
        System.out.println();

        int i =0;
        int j = str.length()-1;

        while(i<=j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }

        return true;
    }
}
