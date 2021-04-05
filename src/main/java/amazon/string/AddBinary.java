package amazon.string;

public class AddBinary {


    public static void main(String[] args) {
        String a = "0", b = "0";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {

        StringBuffer sb = new StringBuffer();
        int sum,carry=0;

        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int n1 = (i >= 0) ? a.charAt(i) - 48 : 0;
            int n2 = (j >= 0) ? b.charAt(j) - 48 : 0;

            sum = carry + n1 + n2;
            if (sum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sum = sum % 2;
            sb.append(sum);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
