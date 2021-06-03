package java8.streams;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {

        //what is the use of this ?
        Supplier<String> supplier = ()->"s";
        System.out.println(supplier.get());

        //Generate Method
        //Supplier interface used here
        Stream.generate(supplier).limit(10).forEach(System.out::print);
        System.out.println();

        //Another Example of generate method
        Stream.generate(()->new Random().nextInt(10)).limit(5).forEach(s->System.out.print(s + " "));
        System.out.println();

        //Iterator
        Stream.iterate(100,(i -> i+1)).limit(11).forEach(s-> System.out.print(s + " "));

        Stream<Integer> integerStream = Stream.of(1, 2, 3).map(s -> s * s);
        integerStream.forEach(System.out::print);
        System.out.println();


        //Peek Method
        long max = Stream.of(1, 2, 3, 4).map(m -> m * m).peek(e -> System.out.print(e)).count();
        System.out.println(max);
    }
}
