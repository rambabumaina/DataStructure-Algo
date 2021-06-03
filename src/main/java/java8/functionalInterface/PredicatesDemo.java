package java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//Predicate is a Functional interface it ave test method that takes one argument and returns TURE or FALSE
public class PredicatesDemo {
    public static void main(String[] args) {

        PrintMoreThan1000Salary();
    }


    //Print Name of the objects whos salary is more then 1000
    public static void PrintMoreThan1000Salary(){
        Test1 t1 = new Test1("ram", 9000);
        Test1 t2 = new Test1("shayam", 1100);

        List<Test1> list = Arrays.asList(t1,t2);

        //Defined a predicate whose salary more then 100 and name starts with "r"
        Predicate<Test1> p = (t->t.salary> 1000 && t.name.startsWith("r"));

        list.forEach(f->{
            if(p.test(f)){
                System.out.println(f.name);
            }
        });
    }

    //print more than 5
    public static void printGreaterThan5(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        //Defined Test Method IMPL
        Predicate<Integer> ss = (s)-> s>5;

        list.forEach(a->{

            //calling test method
            if(ss.test(a)){
                System.out.println(a);
            }
        });
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