package geeksforgeeks.amazon.string;

public class SubSequence {
    public static void main(String[] args) {
        String A = "AXY";
        String B = "YADXCP";
        System.out.println(isSubSequence(A, B));

    }


     public static boolean isSubSequence(String A, String B){
        int i = 0 , j = 0;
        while (j<B.length()){

            if(A.charAt(i) == B.charAt(j)){
                i++;
            }
            j++;
        }
        if(i == A.length()){
            return true;
        }
        return false;
    }
}
