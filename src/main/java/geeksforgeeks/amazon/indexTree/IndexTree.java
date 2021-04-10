package geeksforgeeks.amazon.indexTree;

import java.util.Arrays;

//https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
public class IndexTree {
    public static void main(String[] args) {

        int[] original = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] indexArray = new int[original.length + 1];

        buildIndexTree(original, indexArray);
        Arrays.stream(original).forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(indexArray).forEach(s -> System.out.print(s + " "));
        System.out.println();

        System.out.println("result: " + rangeSum(indexArray, 6, 11));
        System.out.println("Get Sum :"+ getSum(indexArray, 5));
    }


    private static int rangeSum(int[] tree, int l, int r) {
        int result = 0;
        if (l == r) {
            result = tree[l];
        } else if (l > r) {
            return result;
        } else {
            if (l > 0 && l < tree.length && r > l && r < tree.length) {
                result =  getSum(tree, r ) - getSum(tree, l-1);
            }
        }
        return result;
    }

    private static int getSum(int[] tree, int i) {
        int sum = 0;
        int j = i+1;
        while (j > 0) {
            sum += tree[j];
            j = getParent(j);
        }
        return sum;
    }

    private static int getParent(int i) {
        return i & (i - 1);
    }

    private static void buildIndexTree(int[] orig, int[] tree) {
        tree[0] = 0;
        int len = tree.length;

        for (int i = 1; i < len; i++) {
            tree[i] = tree[i] + orig[i - 1];

            int nextIndex = i;
            while ((nextIndex = getNextIndex(nextIndex)) < len) {
                tree[nextIndex] = orig[i - 1] + tree[nextIndex];
            }
        }
    }

    private static int getNextIndex(int i) {
        return i + (i & (-i));
    }
}
