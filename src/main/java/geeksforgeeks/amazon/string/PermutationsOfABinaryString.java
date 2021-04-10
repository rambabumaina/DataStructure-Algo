package geeksforgeeks.amazon.string;

public class PermutationsOfABinaryString {
    public static void main(String[] args) {
        String str = "110";//110,101,011,110,101,110,101
        //<3,6,5>
        int i = str.length() - 1;
        double d = 0;
        while (i >= 0) {

            d = Math.pow(2, str.charAt(i));
            System.out.println(d);
            i--;
        }
        System.out.println(d);
    }

    void permutation() {
    }
}
