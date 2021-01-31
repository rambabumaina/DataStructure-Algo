package java8.streams;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("ah");
        list.add("az");
        list.add("bg");
        list.add("cc");


        //print list using stream
        list.stream().forEach((s) -> System.out.println(s + " "));

        // filter starts with a
        System.out.println("Filter..");
        list.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

        //Sort
        System.out.println("Sort..");
        list.stream().sorted().forEach(System.out::println);

        //Sort Reverse order
        System.out.println("R Sort..");
        list.stream().filter((a) -> a.startsWith("a"))
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        //Reduce
        System.out.println("Reduce Optional..");
       Optional<String> optionalS =list.stream().sorted().reduce((a, b)->a +","+ b);
        System.out.println(optionalS.isPresent());
        System.out.println(optionalS.get());

        //All Records In Upper Case
        System.out.println("UpperCase..");
        list.stream()
                .filter((a) ->a.startsWith("b"))
                .sorted().map((a)->a.toUpperCase())
                .forEach(System.out::println);

        //Any record Starts with c
        System.out.println("Any match starts with C..");
        boolean anyRecordsStartsWith_C= list.stream().anyMatch((s)->s.startsWith("c"));
        System.out.println("Any match starts with C :"+ anyRecordsStartsWith_C);

        //All record Starts with c
        System.out.println("All match starts with C..");
        boolean allRecordsStartsWith_C= list.stream().allMatch((s)->s.startsWith("c"));
        System.out.println("All match starts with C :"+ allRecordsStartsWith_C);

        //Get the count
        System.out.println("Get the count, who is start with a..");
        long count= list.stream().filter((s)->s.startsWith("a")).count();
        System.out.println("Count :"+ count);


        //convert list to stream
        System.out.println("Convert list to stream..");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        // Create Integer Stream
        System.out.println("Create Integer stream..");
        Stream<Integer> stream1 = Stream.of(11,12,23);
        stream1.sorted((a,b) ->b-a)
                .forEach(System.out::println);

        //Create integer array to stream
        System.out.println("Create Integer array stream..");
        Integer[] arr = {1,2,44,56};
        Stream<Integer> stream2 = Stream.of(arr);
        stream2.forEach(System.out::println);

    }
}
