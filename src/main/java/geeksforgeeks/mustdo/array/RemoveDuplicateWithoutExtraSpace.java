package geeksforgeeks.mustdo.array;

import java.util.Arrays;

public class RemoveDuplicateWithoutExtraSpace {
    public static void main(String[] args) {

        int [] input = {1, 2, 3, 1, 3, 6, 6};

        for (int i = 0; i < input.length; i++) {
            //
            int j = Math.abs(input[i]);
            if (input[j] >= 0)
                input[j] = -input[j];
            else
                System.out.print(j + " ");
        }
    }
}
