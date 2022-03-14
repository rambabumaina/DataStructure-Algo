package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Subset  means take something skip something
 * Example: abc :=: a,b,c, ab, ac, bc, abc : here taking one character and skipping one character
 *
 */
public class SubsetForGivenString {
    public static void main(String[] args) {
        String str = "abc";
        List<String> result = new ArrayList<>();

        System.out.println(result);

        subsetSubStringPrint(str, "", result);

        System.out.println(result);

        List<String> res2 = subsetSubStringReturn(str, "");

        System.out.println(">> :" + res2);

        //Iterative approach
        int [] a = {1,2,3};
        subsetStringsIterative(a).forEach(System.out::println);
    }

    //Add the results in the function argument and add the results
    private static void subsetSubStringPrint(String str, String ans, List<String> result) {

        if (str.isEmpty()) {
            //Result, you can only print it
            System.out.println(ans);

            //Result, you can store in list
            result.add(ans);
            return;
        }

        //Take first character
        char ch = str.charAt(0);

        //Here two options: either take it or ignore it

        //1. Take first character
        subsetSubStringPrint(str.substring(1), ans + ch, result);

        //2. Ignore first character
        subsetSubStringPrint(str.substring(1), ans, result);
    }


    //Create new list for every function call and return it
    private static List<String> subsetSubStringReturn(String str, String ans) {

        if (str.isEmpty()) {
            List<String> result = new ArrayList<>();
            //Result, you can store in list
            result.add(ans);
            return result;
        }

        //Take first character
        char ch = str.charAt(0);

        //Here two options: either take it or ignore it

        //1. Take first character
        List<String> left = subsetSubStringReturn(str.substring(1), ans + ch);

        //2. Ignore first character
        List<String> right = subsetSubStringReturn(str.substring(1), ans);

        left.addAll(right);
        return left;
    }

    private static List<List<Integer>> subsetStringsIterative(int [] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num : arr){

            int n = outer.size();
            for (int i = 0; i <n ; i++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }
}
