package geeksforgeeks.mustdo.stackAndQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
public class NextGreaterElement {

    public static void main(String[] args) {
        long[] input = {1, 3, 2, 4};

        Arrays.stream(nextLargerElement(input, input.length)).forEach(l -> System.out.print(l + " "));
    }

    //keep push element into stack if empty and stack push is greater then array of index
    //Else Keep pooping util stack empty or stack peek element found greater
    //Make key to stack peek element and value to the array element
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();

        //To store the sequence, since stack will not give the correct order
        Map<Long, Long> map = new HashMap<>();

        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || stack.peek() > arr[i]) {
                stack.push(arr[i]);
                i++;
            } else {
                if (stack.peek() < arr[i]) {
                    map.put(stack.pop(), arr[i]);
                }
            }
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), (long) -1);
        }
        long[] result = new long[map.size()];
        int j = 0;
        while (j< n){
            result[j] = map.get(arr[j]);
            j++;
        }
        return result;
    }
}
