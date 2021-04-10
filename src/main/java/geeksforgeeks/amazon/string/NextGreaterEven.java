package geeksforgeeks.amazon.string;

public class NextGreaterEven {

    public long getNextEven(String str) {
        if(!checkStringHavingEvenNumber(str)){
            return -1;
        }

        while(true){
            str = findNextGreaterNumber(str.toCharArray());
            System.out.println(str);
            if(str == null){
                return -1;
            }else
            {
                if(str.charAt(str.length()-1) % 2 == 0){
                    return Long.valueOf(str);
                }
            }
        }

    }

    public String findNextGreaterNumber(char[] number){
        for (int i = number.length - 1; i > 0; i--) {
            if (number[i - 1] < number[i]) {

                //Get the index of the number which is just greater then i-1 from (i to N)
                int minIndex = getMinValue(number, i);

                char temp = number[i - 1];
                number[i - 1] = number[minIndex];
                number[minIndex] = temp;

                sortRemainingDigits(number, i);
                return new String(number);
            }
        }
        return null;
    }

    private static int getMinValue(char[] number, int i){
        int min = Integer.MAX_VALUE;
        int minIndex =0;

        for (int j = i ; j<number.length;j++){
            if(number[j] > number[i-1] && min > number[j]){
                minIndex = j;
                min=number[j];
            }
        }
        return minIndex;
    }

    private void sortRemainingDigits(char[] ch, int i) {
        for (; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] > ch[j]) {
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                }
            }
        }
    }

    public boolean checkStringHavingEvenNumber(String str){
        for (int i =0 ; i < str.length() ; i++){
            if ( str.charAt(i) % 2 ==0){
               return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NextGreaterEven e = new NextGreaterEven();
        long input = 1893; // 1938
        String str = String.valueOf(input);

//        System.out.println(e.getNextEven(str));

        System.out.println(e.findNextGreaterNumber(str.toCharArray()));

    }
}
