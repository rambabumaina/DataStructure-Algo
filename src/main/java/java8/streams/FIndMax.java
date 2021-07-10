package java8.streams;

import java.util.stream.Stream;

public class FIndMax {
    public static void main(String[] args) {

        String[] input = {"1", "40", "100", "50", "400"};
        int max = Stream.of(input).map(m -> Integer.parseInt(m)).max((a, b) -> a - b).get();
        System.out.println(max);
    }
}
