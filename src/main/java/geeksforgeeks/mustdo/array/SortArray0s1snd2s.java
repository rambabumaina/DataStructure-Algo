package geeksforgeeks.mustdo.array;

//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
public class SortArray0s1snd2s {

    public static void main(String[] args) {
        int input[] = {0, 2, 1, 2, 0};
        sort012(input, input.length);
    }

    public static void sort012(int a[], int n) {

        int[] count = new int[3];
        for (int i : a) {
            switch (i) {
                case 0: {
                    count[0]++;
                    break;
                }
                case 1: {
                    count[1]++;
                    break;
                }
                case 2: {
                    count[2]++;
                    break;
                }
            }
        }

        int j = 0, k = 0, l = 0;
        while (j < count.length) {
            if (k < count[j]) {
                a[l++] = j;
                k++;
                continue;
            }
            j++;
            k = 0;
        }
    }
}
