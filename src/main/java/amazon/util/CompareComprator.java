package amazon.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareComprator {

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "ram", 10);
        Employee e2 = new Employee(2, "r", 20);
        Employee e3 = new Employee(3, "a", 400);
        Employee e4 = new Employee(4, "m", 1077);

        List<Employee> list = Arrays.asList(e4, e2, e1, e3);

        List<Integer> li = Arrays.asList(1,23,4,15);
        Collections.sort(li, (o1, o2)->o2-o1);

        System.out.println(li);
    }



    static class Employee {
        int id;
        String name;
        int salary;

        Employee(int id, String name, int salary) {
            this.id = id;
            this.name=name;
            this.salary=salary;
        }


        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }

    }
}
