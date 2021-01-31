package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStringUsingLambda {

    public static void main(String[] args) {

        String[] str = {"aa", "cc", "hh", "bb", "gg", "jj", "uu"};

        List<String> list = Arrays.asList(str);

//        String[] result = CompareWithoutLambda(str);
//        String[] result = withLambda(str);

        List<String> result = withList(list);

       list.stream().forEach(System.out::println);

    }

    private static List<String> withList(List<String> list) {
        Collections.sort(list, (a, b) -> b.compareTo(a));
        return list;
    }

    private static String[] withLambda(String[] str) {
        System.out.println("Sort String with lambda...");
        Arrays.sort(str, (a, b) -> a.compareTo(b));
        return str;
    }


    private static String[] CompareWithoutLambda(String[] str) {
        System.out.println("Sort String without lambda...");
        Arrays.sort(str, new myComPare());
        return str;
    }


    static class myComPare implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }
}
