package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//
public class FilterDemo {
    public static void main(String[] args) {

        //Add all
        IntStream IS1 = IntStream.range(1,11);
        System.out.println(IS1.sum());

        //Print All
        IntStream IS2 = IntStream.range(1,11);
        IS2.forEach(f -> System.out.print(f + " "));
        System.out.println();

        //FindMax
        IntStream IS3 = IntStream.range(1,11);
        System.out.println(IS3.max().getAsInt());


        //
        Test1 t1 = new Test1("ram", 900);
        Test1 t2 = new Test1("shayam", 1100);

        Stream<Test1> list = Stream.of(t1,t2);
        list.filter(f->f.salary > 1000).forEach(d-> System.out.println(d.name));


        List<String> name = Stream.of(t1,t2)
                .sorted((e,f)->e.name.compareTo(f.name))
                .map(e->e.name)
                .collect(Collectors.toList());

        System.out.println("->>>"+ name);
    }
}

class Test1{
    String name;
    int salary;

    public Test1(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

