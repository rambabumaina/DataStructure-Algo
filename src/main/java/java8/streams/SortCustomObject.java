package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortCustomObject {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student(3,"Ram");
        Student s2 = new Student(1,"Anu");
        Student s3 = new Student(2,"Meena");

        list.add(s1);
        list.add(s2);
        list.add(s3);

        Collections.sort(list);
        list.forEach(s->{ System.out.println(s.name + " "+ s.id); });

//        Collections.sort(list,Comparator.comparing(Student::getName).thenComparing(Student::getId));
//
//        list.forEach(s->{ System.out.println(s.name + " "+ s.id); });
//        System.out.println(" ");



//         list.stream().sorted().forEach(student -> System.out.println(student.name));
//        List<Integer> integers = Arrays.asList(10,3,2,5,1);
//        Collections.sort(integers);
//        integers.forEach(s-> System.out.println(s));


//        //String Class compar
//        List<String> strings = Arrays.asList("Ram","Anu");
//        Collections.sort(strings);
//        strings.forEach(s-> System.out.println(s));



    }
}


class Student implements Comparable<Student>{
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}

class SortStudent implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }

}