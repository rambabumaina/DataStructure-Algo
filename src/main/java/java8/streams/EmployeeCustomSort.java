package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeCustomSort {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ram", "Meena", 31);
        Employee e2 = new Employee("Anu", "Meena", 30);
        Employee e3 = new Employee("Raj", "Raghu", 30);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3);
        System.out.println(employeeList);

        employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName)).forEach(e-> System.out.println(e));
    }
}


class Employee {
    String firstName;
    String lastName;
    int age;

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
