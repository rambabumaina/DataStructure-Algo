package geeksforgeeks.mustdo.array;

// How many special numbers in array
// 22 = 11+11 , 121 = 29+92
public class SpecialNumber {
    public static void main(String[] args) {
//        String[] str = {"121", "22"};
//        System.out.println(isSpecial(str, str.length));
        System.out.println(getReverse(1));
    }

    public static int isSpecial(String[] inp, int inpSize) {
        int arr[] = new int[inp.length];
        for (int i = 0; i < inpSize; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        int spclCount = 0;
        //Check all possibilities for number/2 times
        //Run inner loop from 1 to number/2 times and add number to its reverse number
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < ((arr[i] / 2) + 1); j++) {
                if (j + getReverse(j) == arr[i]) {
                    spclCount++;
                    break;
                }
            }
        }

        return spclCount;
    }

    public static int getReverse(int n) {
        int rem, rev = 0;
        while (n != 0) {
            rem = n % 10;
            rev = (rev * 10) + rem;
            n /= 10;
        }
        return rev;
    }
}
