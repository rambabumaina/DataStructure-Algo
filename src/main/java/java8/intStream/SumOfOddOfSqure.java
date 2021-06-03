package java8.intStream;

import java.util.stream.IntStream;

public class SumOfOddOfSqure {
    public static void main(String[] args) {
        IntStream is = IntStream.range(1,6);

        int sum = is.filter(f -> f % 2 != 0).map(m -> m * m).sum();
        System.out.println(sum);


        IntStream is2 = IntStream.range(1,6);
        is2.forEachOrdered(System.out::print);

    }


}
