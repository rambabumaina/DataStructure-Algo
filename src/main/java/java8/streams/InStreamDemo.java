package java8.streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class InStreamDemo {
    public static void main(String[] args) {

        //Example: 1 Even Number
        IntStream stream = IntStream.of(1,2,3,4,5,6);
        stream.filter((x) -> x%2 == 0).forEach((s)->System.out.print(s+ " "));

        //Example:2
        System.out.println();
        IntStream stream1 = IntStream.range(1,6);
        stream1.forEach((s)->System.out.print(s+ " "));


        //Example:3 SUM
        System.out.println();
        int Sum = IntStream.of(1,2,3,4,5,6,7).sum();
        System.out.println("Print Sum:"+Sum);

        //Example:3 MAX
        System.out.println();
        OptionalInt Max = IntStream.of(1, 2, 3, 4, 5, 6, 7).max();
        System.out.println("Print Max:"+Max.getAsInt());

    }
}
