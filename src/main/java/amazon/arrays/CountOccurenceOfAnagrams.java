package amazon.arrays;

import java.util.stream.IntStream;

public class CountOccurenceOfAnagrams {
    public static void main(String[] args) {

//      String  txt = "aabaabaa";
//      String  pat = "aaba";

      String txt = "forxxorfxdofr";
      String pat = "for";

        System.out.println(search(txt,pat));
    }

    static int search(String txt, String pat) {
        int result = 0;

        int[] txtCount = new int[26];
        int[] patCount = new int[26];

        IntStream.range(0, pat.length()).forEach(i -> patCount[pat.charAt(i) - 97]++);
        IntStream.range(0, pat.length()).forEach(i -> txtCount[txt.charAt(i) - 97]++);

        if (checkIfSameCount(txtCount, patCount)) {
            result++;
        }

        for (int i = pat.length(); i < txt.length(); i++) {
            txtCount[txt.charAt(i) - 97]++;
            txtCount[txt.charAt(i - pat.length()) - 97]--;
            if (checkIfSameCount(txtCount, patCount)) {
                result++;
            }
        }
        return result;
    }

    private static boolean checkIfSameCount(int[] txtCount, int[] patCount) {
        for (int i = 0; i < patCount.length; i++) {
            if (txtCount[i] != patCount[i]) {
                return false;
            }
        }
        return true;
    }
}
