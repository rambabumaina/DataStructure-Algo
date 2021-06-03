package java8.intStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NonInterfaring {
    public static void main(String[] args) {


        List<String> stringList = Arrays.asList("A", "B" ,"M","D");
        stringList.stream().forEachOrdered(System.out ::print);

        Stream.generate(() -> 1).limit(10).forEach(System.out::print);

        //Non Interfaring
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> peek = list.stream().peek(s -> list.add(6));
        peek.forEach(System.out::print);

        whenModificationDuringItratting();

    }

    private static void whenModificationDuringItratting() {

        //concurent modification exception during modification
        List<Integer> listOfIntegers = new ArrayList<>();
        Integer[] intArray = new Integer[]{40, 34, 21, 37, 20};
        for (Integer in : intArray) {
            listOfIntegers.add(in);
        }
        listOfIntegers.parallelStream()

                .peek(i -> listOfIntegers.add(7))
                .forEach(e -> System.out.print(e + " "));
    }
}

