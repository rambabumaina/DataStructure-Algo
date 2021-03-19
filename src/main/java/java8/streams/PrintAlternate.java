package java8.streams;

import java.util.stream.IntStream;

public class PrintAlternate {


    public static void main(String[] args) {
        int [] num = {1, 2, 3};

        IntStream.range(0, num.length).filter(x->x%2==0).forEach(s-> System.out.println(num[s]));

        IntStream stream = IntStream.range(0, num.length).filter(x -> x % 2 == 0).map(s -> s * 2);

    }
}
