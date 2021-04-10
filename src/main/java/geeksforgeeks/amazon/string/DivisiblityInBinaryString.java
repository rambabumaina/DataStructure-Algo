package geeksforgeeks.amazon.string;

public class DivisiblityInBinaryString {
    public static void main(String[] args) {

        String str = "101"; //21
        int decimalEquivalent = 0;

        for (int i = 0 ; i< str.length(); i++){
            int n = str.charAt(i)-48;

            decimalEquivalent = decimalEquivalent *2 +n;
            decimalEquivalent %= 3;
        }

        if(decimalEquivalent ==0){
            System.out.println("value is divisible");
        }else{
            System.out.println("value is not divisible");
        }
    }


}
