package amazon.string;

public class EncodingString {
    static int count = 0;
    public static void main(String[] args) {

        EncodingString e = new EncodingString();
        String str = "102";
        e.CountWays(str);

        System.out.println("Count :" + count);
    }

    public int CountWays(String str)
    {
        count= 0;
//        if(!checkIfZeroPresent(str)){
//            encodeStr(str, 0);
//        }

        encodeStr(str, 0);
        return count;
    }

    private boolean checkIfZeroPresent(String str) {
        for (int i = 0 ; i< str.length(); i++){
            if(str.charAt(i) == '0'){
                return true;
            }
        }
        return false;
    }

    public void encodeStr(String str, int index) {
        if (index == str.length()) {
            count++;
            return;
        }

        if(str.charAt(index) == '0'){
            return;
        }

        encodeStr(str, index + 1);
        int x = (str.charAt(index) - 48) * 10;
        if(index+1 < str.length()) {
            int y = str.charAt(index + 1) - 48;
            if (y + x <= 26) {
                encodeStr(str, index + 2);
            }
        }
    }
}
