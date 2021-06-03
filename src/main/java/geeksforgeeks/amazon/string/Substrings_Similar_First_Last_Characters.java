package geeksforgeeks.amazon.string;

//https://practice.geeksforgeeks.org/problems/substrings-with-similar-first-and-last-characters3644/1
public class Substrings_Similar_First_Last_Characters {

    public static void main(String[] args) {
        String s = "aba";

        System.out.println(countSubstringWithEqualEnds(s));
    }

    static int countSubstringWithEqualEnds(String s) {
        int count = s.length();
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length()-i; j++) {
                int k = i + j;

                if (s.charAt(j) == s.charAt(k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
