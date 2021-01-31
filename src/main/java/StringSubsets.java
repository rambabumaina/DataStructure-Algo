import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/amazon-interview-set-27/?ref=lbp
public class StringSubsets {


    public static void main(String[] args) {
        String s = "aaabaa" ; //a,a,a,aa,aaa,a,a,aa
      findSubset(s,'a');
    }

    private static void findSubset(String s, char ch) {

        List<Character> list = new ArrayList<>();
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i) == ch){
                list.add(s.charAt(i));
            } else{
            }
        }
    }
}
