package geeksforgeeks.mustdo.string;

public class RecursivelyRemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        String S = "geeksforgeek";
//        String S = "abccbccba";
//        String S = "acaaabbbacdddd"; //acac
        System.out.println(remove(S));
    }

    static String remove(String s) {
        int startIndex =0;
        int endIndex = 0;
        boolean flag = false;

        while (true){
            flag = false;
            for (int i=0  ; i< s.length()-1; i++ ){
                if(s.charAt(i) == s.charAt(i+1)){
                    flag =true;
                    startIndex =i;
                    endIndex = getEndIndex(s, startIndex);

                    String s1 = s.substring(0,startIndex);
                    String s2 = s.substring(endIndex+1);
                    s = s1+s2;
                    i = i -1;
                }
            }

            if(!flag){
                break;
            }

        }
        return s;
    }

    public static int getEndIndex(String s, int startIndex){
        int endIndex = s.length()-1;
        for (int i = startIndex; i < s.length()-1; i ++){
            if(s.charAt(i) != s.charAt(i+1)){
                endIndex = i;
                break;
            }
        }
        return endIndex;
    }
}
