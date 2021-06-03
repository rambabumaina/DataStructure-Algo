package java8.streams;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PremitiveIstream {
    public static void main(String[] args) {

        //Stream to IntStream
        int sum = Stream.of("10","20","30")
                .mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

        //IntStream to stream

        Stream.of("10","20","30")
                .max(Comparator.reverseOrder())
                .ifPresent(s-> System.out.println(s));

        Stream.of("ram","shayam").flatMap(e->Stream.of(e)).forEach(System.out::println);
    }
}
